/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Class.BanDoc;
import DAL.DAL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class BanDocBLL {
    
    DAL dal = new DAL();
    Connection conn;
    
    private DefaultTableModel layDuLieuBanDoc(ResultSet rs, JTable tbl) {
        DefaultTableModel model = null;
        try {
            model = (DefaultTableModel) tbl.getModel();
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanDocBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public DefaultTableModel xemTatCaBanDoc(JTable tbl) {
        DefaultTableModel model = null;
        try {
            String sql = "select * from BanDoc";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = layDuLieuBanDoc(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BanDocBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public boolean themBanDoc(BanDoc banDoc) {
            int i = 0;
        try {
            String sql = "insert into BanDoc(maBanDoc, tenBanDoc, ngaySinh, diaChi, lop)"
                    + " values (N'" + banDoc.getMaBanDoc() + "', N'" + banDoc.getTenBanDoc() + "',"
                    + " '" + new Date(banDoc.getNgaySinh().getTime()) + "', N'" + banDoc.getDiaChi() +
                    "', N'" + banDoc.getLop() + "')";
            conn = dal.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BanDocBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i > 0;
    }
    
}
