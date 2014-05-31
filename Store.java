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
public class Store {

    String storeCode, storeName, storeAddress;

    void setStoreCode(String SC) {
        storeCode = SC;
    }

    void setStoreName(String SN) {
        storeName = SN;
    }

    void setStoreAddress(String SA) {
        storeAddress = SA;
    }

    String getStoreCode() {
        return storeCode;
    }

    String getStoreName() {
        return storeName;
    }

    String getStoreAddress() {
        return storeAddress;
    }
    //the verification length of store code is 9 digits

    //not exist in  database before 
    boolean CheckStoreCodeInDB(){
           //***************** check in database
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
      
      String sql = "select * from stores where storeCode = '" +
                   this.storeCode+"'";
             ResultSet executeQuery = stmt.executeQuery(sql);
           
             if(executeQuery.first())
             {
                 System.out.println("el store code la2eto mogod abl kda");
                  conn.close();
                 return false;
             }
             else
             {
                 System.out.println("el store code msh la2eto mogod abl kda");
                  conn.close();
                 return true;
             }
   }catch(SQLException se){
   }catch(Exception e){
    }
        
        return false;
       }
    
    boolean checkStoreCode() {
        
        if (getStoreCode().length() > 9 || getStoreCode().length() < 3) {
            return false;
        } else {
            String s = getStoreCode().substring(0, 3);
            if (!s.matches("CAI")) {
                return false;
            } else {
                for (int i = 3; i < this.getStoreCode().length(); i++) {
                    if (!Character.isLetter(this.getStoreCode().charAt(i))) {
                        return false;
                    }
                }

            }
        }

        return true;
    }
}
