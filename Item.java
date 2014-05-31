/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mscs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ahmed nasser
 */
public class Item {

    private String itemCode, itemName,
            itemApplicabilty, unitOfMeasure, unitOfIssue;

    void setItemCode(String IC) {
        itemCode = IC;
    }

    void setItemName(String IN) {
        itemName = IN;
    }

    void setItemApplicabilty(String IA) {
        itemApplicabilty = IA;
    }

    void setUnitOfMeasure(String UOM) {
        unitOfMeasure = UOM;
    }

    void setUnitOfIssue(String UOI) {
        unitOfIssue = UOI;
    }

    String getItemCode() {
        return itemCode;
    }

    String getItemName() {
        return itemName;
    }

    String getItemApplicabilty() {
        return itemApplicabilty;
    }

    String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    String getUnitOfIssue() {
        return unitOfIssue;
    }
    boolean CheckItemCodeInDB() { 
        // check in data base
         Connection conn = null;
       Statement stmt = null;
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(IConstant.DB_URL, IConstant.USER, IConstant.PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("searching records into the table...");
      stmt = conn.createStatement();
      
      String sql = "select * from items where itemCode = '" +
                   this.itemCode+"'";
             ResultSet executeQuery = stmt.executeQuery(sql);
           
             if(executeQuery.first())
             {
                 System.out.println("el item code la2eto mogod abl kda");
                  conn.close();
                 return false;
             }
             else
             {
                 System.out.println("el item code msh la2eto mogod abl kda");
                  conn.close();
                 return true;
             }
   }catch(SQLException se){
   }catch(Exception e){
    }
        
        return false;
    }

//varfication of itemcode at least 7 alphanumeric 
    boolean checkItemCode() {
        if (this.getItemCode().length() > 7 || this.getItemCode().length() < 1) {
            return false;
        }
        for (int i = 0; i < this.getItemCode().length(); i++) {
            if (!Character.isLetter(this.getItemCode().charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // varification of item applicability must be from fleet code 
    boolean checkItemApplicabilty() {

     //*********************check database
     
      // check in data base
         Connection conn = null;
       Statement stmt = null;
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(IConstant.DB_URL, IConstant.USER, IConstant.PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("searching records into the table...");
      stmt = conn.createStatement();
      
      String sql = "select * from fleet where fleetCode = '" +
                   this.itemApplicabilty+"'";
             ResultSet executeQuery = stmt.executeQuery(sql);
           
             if(executeQuery.first())
             {
                 
                 System.out.println("el fleet code la2eto fe table el fleet");
                  conn.close();
                 return true;
             }
             else
             {
                 System.out.println("el fleet code msh la2eto fe table el fleet");
                  conn.close();
                 return false;
             }
   }catch(SQLException se){
   }catch(Exception e){
    }
        return  true;
    }

    boolean checkUnitOfMeasure() {

        if (!this.getUnitOfMeasure().matches("EA")
                && !this.getUnitOfMeasure().matches("DZ")
                && !this.getUnitOfMeasure().matches("GA")) {
            return false;
        }
        return true;
    }

    boolean checkUnitOfIssue() {

        if (!this.getUnitOfIssue().matches("EA")
                && !this.getUnitOfIssue().matches("DZ")
                && !this.getUnitOfIssue().matches("GA")) {
            return false;
        }
        return true;
    }
}
