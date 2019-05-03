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
import java.text.SimpleDateFormat;
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
    
    public DefaultTableModel timKiemBanDoc(JTable tbl, String timKiem) {
        DefaultTableModel model = null;
        try {
            
            String sql = "select * from BanDoc where maBanDoc like '%" + timKiem + "%'"
                    + "or tenBanDoc like '%" + timKiem + "%'";
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
        String sql = "insert into BanDoc(maBanDoc, tenBanDoc, ngaySinh, diaChi, lop)"
                + " values (N'" + banDoc.getMaBanDoc() + "', N'" + banDoc.getTenBanDoc() + "',"
                + " '" + new Date(banDoc.getNgaySinh().getTime()) + "', N'" + banDoc.getDiaChi() +
                "', N'" + banDoc.getLop() + "');"
                + "insert into TaiKhoan values (N'" + banDoc.getMaBanDoc() + "',"
                + " '" + new SimpleDateFormat("ddMMyyyy").format(banDoc.getNgaySinh()) + "', 'bd')";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean xoaBanDoc(String maBanDoc) {
        String sql = "delete BanDoc where maBanDoc = '" + maBanDoc + "';"
                + "delete TaiKhoan where taiKhoan = '" + maBanDoc + "'";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean datLaiMatKhau(BanDoc banDoc) {
        String sql = "update TaiKhoan set matKhau = '" + new SimpleDateFormat("ddMMyyyy").format(banDoc.getNgaySinh())
               + "' where taiKhoan = N'" + banDoc.getMaBanDoc() + "'";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean suaBanDoc(BanDoc banDoc) {
         String sql = "update BanDoc "
                + "set tenBanDoc = N'" + banDoc.getTenBanDoc() + "',"
                + " ngaySinh = '" + new Date(banDoc.getNgaySinh().getTime()) + "', diaChi = N'" + banDoc.getDiaChi() +
                "', lop = N'" + banDoc.getLop() + "' where maBanDoc = '" + banDoc.getMaBanDoc() + "';";
        return dal.excuteNonQuery(sql);
    }
}
