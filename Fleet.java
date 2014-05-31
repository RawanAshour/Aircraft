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
public class Fleet {

    private String fleetCode;
    private String fleetModel;

    void setFleetCode(String FC) {
        fleetCode = FC;
    }

    void setFleetModel(String FM) {
        fleetModel = FM;
    }

    String getFleetCode() {
        return fleetCode;
    }

    String getFleetModel() {
        return fleetModel;
    }
//************check fleet code in database
    boolean checkFleetCode() {
        // check in data base
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(IConstant.DB_URL, IConstant.USER, IConstant.PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("searching records into the table...");
            stmt = conn.createStatement();

            String sql = "select * from fleet where fleetCode = '"
                    + this.fleetCode + "'";
            ResultSet executeQuery = stmt.executeQuery(sql);

            if (executeQuery.first()) {
                System.out.print(executeQuery.getString("fleetCode"));
                conn.close();
                return false;
            } else {
                conn.close();
                return true;
            }
        } catch (SQLException se) {
        } catch (Exception e) {
        }
        return false;
    }
}
