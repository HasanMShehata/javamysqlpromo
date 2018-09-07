package com.hms.working;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class mysqlpromo {

    public static void main(String[] args) {
        querry();
    }

    public static void querry(){
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String sample_querry =  "SELECT `name` AS `names` FROM `hasandb`.`brothers_table`;";
        String create_table_quary;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://HW7-PC/test?"+"user=hasan&password=password");
            // Do something with the Connection

            System.out.println("connection ok");
            stmt = conn.createStatement();
            stmt.executeQuery(sample_querry);
            System.out.println("querry ok");
            rs = stmt.getResultSet();

            while(rs.next()){
                //System.out.print(String.valueOf(rs.getInt(1))+"   ");
                System.out.println(String.valueOf(rs.getString(1))+"   ");
                //System.out.print(String.valueOf(rs.getInt(3))+"   ");
                //System.out.println(String.valueOf(rs.getDouble(4)));
            }





        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                }
                catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }

    }

}

