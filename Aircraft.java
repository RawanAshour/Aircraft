/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mscs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ahmed nasser
 */
public class Aircraft {

    private String registrationCode;
    private String dateOfPurchasing, fleetCode;

    void setRegistrationCode(String RC) {

        registrationCode = RC;


    }

    void setFleetCode(String FC) {
        fleetCode = FC;
    }

    void setDateOfPurchasing(String DOP) {
        dateOfPurchasing = DOP;

    }

    String getRegistrationCode() {
        return registrationCode;
    }

    String getFleetCode() {
        return fleetCode;
    }

    String getDateOfPurchasing() {
        return dateOfPurchasing;
    }
    
    boolean CheckRegistrationCodeInDB(){
    // check in data base
         @SuppressWarnings("UnusedAssignment")
         Connection conn;
        conn = null;
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
      
      String sql = "select * from airfact where registerationCode = '" +
                   this.registrationCode+"'";
             ResultSet executeQuery = stmt.executeQuery(sql);
           
             if(executeQuery.first())
             {
                 System.out.println("el airfact la2eto mogod abl kda");
                  conn.close();
                 return false;
             }
             else
             {
                 System.out.println("el airfact msh la2eto mogod abl kda");
                  conn.close();
                 return true;
             }
   }catch(SQLException se){
   }catch(Exception e){
    }
        
        return false;
    }

    boolean checkRegistrationCode() {
        //the verification of airfract code 
        if (getRegistrationCode().length() != 6) {
            return false;
        } else {
            String s = getRegistrationCode().substring(0, 3);
            if (!s.matches("SU-")) {
                return false;
            } else {
                for (int i = 3; i < this.getRegistrationCode().length(); i++) {
                    if (!Character.isLetter(this.getRegistrationCode().charAt(i))) {
                        return false;
                    }
                }

            }
        }

        return true;
    }

    /*
     the verification of airfracft fleet code 
     */
    boolean checkFleetCode() {

       
        //*****************check it from database
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
                   this.fleetCode+"'";
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

    /*the verification of date 
     */
    boolean checkDate() {

        if (this.getDateOfPurchasing().length() > 10) {    //===> 00/00/0000
            return false;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = this.getDateOfPurchasing();

        try {

            Date date = formatter.parse(dateInString);

        } catch (ParseException e) {
            return false;
        }
        return true;

    }
}
