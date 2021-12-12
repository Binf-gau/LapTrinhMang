/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vohoa
 */
public class DBConnection {
    public static Connection getConnection(){
        Connection con= null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;Database=DECUONG_BAI24;user=sa;password=123456";
            con= DriverManager.getConnection(url);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void disCon(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }
    } 
}


