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
 * @author Sarah
 */
public class User {
    private String userName ,name ,password ;
    AbstractRole myRole;
    
   void setUserName(String n ){
   userName = n; 
   }
    
   void setName(String n ){
  name = n; 
   }
    
   void setPassword(String p ){
   password = p; 
   }
    void setMyRole(AbstractRole R ){
   myRole= R; 
   }
    
    
   String getUserName(){
   return userName ; 
   }
    
   String getName(){
 return name ; 
   }
    
   String getPassword(){
   return password ; 
   }
   AbstractRole getMyRole(){
   return myRole;
   }
   
   boolean checkForLogin () 
   {
   //**************check database lw mwgod yb2a true lw l2 yb2a false
      // we bat-check kman 3l password sa7 wala a
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
      
      String sql = "select * from user where userID = '" +
                   this.userName+"' and password = '" + this.password + "'";
             ResultSet executeQuery = stmt.executeQuery(sql);
           
             if(executeQuery.first())
             {
                 System.out.println("el username la2eto mogod abl kda wel pass sa7");
                // System.out.println(executeQuery.getString("Type"));
                 String Type = executeQuery.getString("Type"); 
                 if (Type.equals("CS"))
                 {
                     CS_profile c = new CS_profile();
                     c.show();
                 }
                 else if (Type.equals("SK"))
                 {
                     SK_profile c = new SK_profile();
                     c.show();
                 }
                 else if (Type.equals("SIM"))
                 {
                     SIM_profile c = new SIM_profile();
                     c.show();
                 }
                 conn.close();
                 
                 return true;
             }
             else
             {
                 System.out.println("el username msh la2eto mogod abl kda aw el user mogod bs el pass 8lt");
                  conn.close();
                 return false;
             }
   }catch(SQLException se){
   }catch(Exception e){
    }
        
        return true;
       
        
   }
   
   boolean checkForSignup () 
   {
   //**************check database lw <<MSH>> mwgod yb2a true lw mwgod yb2a false
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
      
      String sql = "select * from user where userID = '" +
                   this.userName+"'";
             ResultSet executeQuery = stmt.executeQuery(sql);
           
             if(executeQuery.first())
             {
                 System.out.println("el username la2eto mogod abl kda");
                  conn.close();
                 return false;
             }
             else
             {
                 System.out.println("el username msh la2eto mogod abl kda");
                  conn.close();
                 return true;
             }
   }catch(SQLException se){
   }catch(Exception e){
    }
        
        return false;
       
       
       //return true;
   }
   
   
    void showMenu(){
    myRole.showMenu();
    }
    
        
}
