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
public class Order {

    String purchaseOrderNumber;
    String stockItemCode;
    String unitOfMeasure;
    String quanitity;
    String vendorCode;
    OrderState myStatues;

    void setPurchaseOrderNumber(String PON) {
        purchaseOrderNumber = PON;
    }

    void setStockItemCode(String i) {
        stockItemCode = i;
    }

    void setQuanitity(String q) {
        quanitity = q;
    }

    void setVendorCode(String VC) {
        vendorCode = VC;
    }

    void setUnitOfMeasure(String m) {
        unitOfMeasure = m;
    }

    String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    String getVendorCode() {
        return vendorCode;
    }

    String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    String getQuanitity() {
        return quanitity;
    }

    String getStockItem() {
        return stockItemCode;
    }
// check from (EA, DZ, GA)

    boolean checkUnitOfMeasure() {

        if (!this.getUnitOfMeasure().matches("EA")
                && !this.getUnitOfMeasure().matches("DZ")
                && !this.getUnitOfMeasure().matches("GA")) {
            return false;
        }
        return true;

    }
    boolean checkOrderNumInDB() {
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
      
      String sql = "select * from orders where orderNum = '" +
                   this.purchaseOrderNumber+"'";
             ResultSet executeQuery = stmt.executeQuery(sql);
           
             if(executeQuery.first())
             {
                 System.out.println("el order num la2eto mogod abl kda");
                  conn.close();
                 return false;
             }
             else
             {
                 System.out.println("el order num code msh la2eto mogod abl kda");
                  conn.close();
                 return true;
             }
   }catch(SQLException se){
   }catch(Exception e){
    }
        
        return false;
}
    
    //the  verification of purchase order  max 6 digit 

    boolean checkPurchaseOrderNumber() {
        if (this.getPurchaseOrderNumber().length() > 6 || this.getPurchaseOrderNumber().length() < 1) {
            return false;
        }
        for (int i = 0; i < this.getPurchaseOrderNumber().length(); i++) {
            if (!Character.isDigit(this.getPurchaseOrderNumber().charAt(i))) {
                return false;
            }
        }

        return true;
    }
    // stock item must exists in database 

    boolean checkStockItemCode() {
 //************************** check database
         
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
      
      String sql = "select * from orders where itemCode = '" +
                   this.stockItemCode+"'";
             ResultSet executeQuery = stmt.executeQuery(sql);
           
             if(executeQuery.first())
             {
                 System.out.println("el item code la2eto abl kda");
                  conn.close();
                 return false;
             }
             else
             {
                 System.out.println("el item code msh la2eto abl kda");
                  conn.close();
                 return true;
             }
   }catch(SQLException se){
   }catch(Exception e){
    }
        return  false;
         
    }

    //the vendor code known 
    boolean checkVendor() {
        if (!this.getVendorCode().matches("V1")
                && !this.getVendorCode().matches("V2")
                && !this.getVendorCode().matches("V3")
                && !this.getVendorCode().matches("V4")) {
            return false;
        }
        return true;
    }

    //quantity must be numeric 
    boolean checkQuanitity() {
        if (this.getQuanitity().length() < 1) {
            return false;
        }

        for (int i = 0; i < this.getQuanitity().length(); i++) {
            if (!Character.isDigit(this.getQuanitity().charAt(i))) {
                return false;
            }
        }

        return true;

    }
}
