/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author langt
 */
public class DangNhapBLL {
    
    DAL dal = new DAL();
    Connection conn;
    public int dangNhap(String taiKhoan, String matKhau) {
        int i = -1;
        try {
            
            String sql = "select * from TaiKhoan where taiKhoan = '" + taiKhoan + "' and matKhau = '" + matKhau + "'";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            if (rs.next()) {
                if ("bd".equals(rs.getString(3))) {
                    i = 1;
                } else if ("tt".equals(rs.getString(3))) {
                    i = 2;
                } else {
                    i = 3;
                }
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BanDocBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
