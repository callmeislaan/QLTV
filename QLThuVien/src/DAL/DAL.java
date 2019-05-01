/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author langt
 */
public class DAL {
    public Connection  getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QuanLyThuVien;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public ResultSet getTable(String sql) {
        ResultSet rs = null;
        try {
            try (Connection conn = getConnection()) {
                PreparedStatement ps = conn.prepareCall(sql);
                rs = ps.executeQuery();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean excuteNonQuery(String sql) {
        int i = -1;
        try {
            try (Connection conn = getConnection()) {
                PreparedStatement ps = conn.prepareCall(sql);
                i = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i > 0;
    }
}