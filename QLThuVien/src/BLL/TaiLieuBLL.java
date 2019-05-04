/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Class.TaiLieu;
import DAL.DAL;
import java.sql.Connection;
import java.sql.Date;
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
public class TaiLieuBLL {
    DAL dal = new DAL();
    Connection conn;
    
    private DefaultTableModel layDuLieuTaiLieu(ResultSet rs, JTable tbl) {
        DefaultTableModel model = null;
        try {
            model = (DefaultTableModel) tbl.getModel();
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5)
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public DefaultTableModel xemTatCaTaiLieu(JTable tbl) {
        DefaultTableModel model = null;
        try {
            
            String sql = "select * from TaiLieu";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = layDuLieuTaiLieu(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
     public boolean datLaiMatKhau(TaiLieu taiLieu) {
        String sql = "update TaiKhoan set matKhau = '" +taiLieu.getTenTaiLieu()
                + "' where taiKhoan = N'" + taiLieu.getMaTaiLieu() + "'";
        return dal.excuteNonQuery(sql);
    }
    public DefaultTableModel timKiemTaiLieu(JTable tbl, String timKiem) {
        DefaultTableModel model = null;
        try {
            
            String sql = "select * from TaiLieu where maTaiLieu like '%" + timKiem + "%'"
                    + "or tenTaiLieu like '%" + timKiem + "%'";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = layDuLieuTaiLieu(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public boolean themTaiLieu(TaiLieu taiLieu) {
        String sql = "insert into TaiLieu(maTaiLieu, tenTaiLieu, soLuong, nhaXuatBan, gia)"
                + " values (N'" + taiLieu.getMaTaiLieu() + "', N'" + taiLieu.getTenTaiLieu() + "',"
                + " '" + taiLieu.getSoLuong() + "', N'" + taiLieu.getNhaXuatBan()+
                "', N'" + taiLieu.getGia()+ "');"
        + "insert into TaiKhoan values (N'" + taiLieu.getMaTaiLieu() + "',"
                + " '" + taiLieu.getTenTaiLieu() + "', 'bd')";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean xoaTaiLieu(String maTaiLieu) {
        String sql = "delete TaiLieu where maTaiLieu = '" + maTaiLieu + "';";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean suaTaiLieu(TaiLieu taiLieu) {
         String sql = "update TaiLieu "
                + "set tenTaiLieu = N'" + taiLieu.getTenTaiLieu() + "',"
                + " soLuong = '" + taiLieu.getSoLuong() + "', nhaXuatBan = N'" + taiLieu.getNhaXuatBan()+
                "', gia = N'" + taiLieu.getGia()+ "' where maTaiLieu = '" + taiLieu.getMaTaiLieu() + "';";
        return dal.excuteNonQuery(sql);
    }
}
