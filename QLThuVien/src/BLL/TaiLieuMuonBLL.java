/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Class.TaiLieuMuon;
import DAL.DAL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
/**
 *
 * @author langt
 */
public class TaiLieuMuonBLL {
    DAL dal = new DAL();
    Connection conn;
    
    private DefaultTableModel layDuLieuTaiLieuMuon(ResultSet rs, JTable tbl) {
        DefaultTableModel model = null;
        try {
            model = (DefaultTableModel) tbl.getModel();
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getInt(5), rs.getDate(6), rs.getDate(7)
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuMuonBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public DefaultTableModel xemTatCaTaiLieuMuon(JTable tbl) {
        DefaultTableModel model = null;
        try {
            
            String sql = "select * from TaiLieuMuon";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = layDuLieuTaiLieuMuon(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuMuonBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public  DefaultTableModel timKiemTaiLieuMuon(JTable tbl, String timKiem) {
        DefaultTableModel model = null;
        try {
            
            String sql = "select * from TaiLieuMuon where maTaiLieu like '%" + timKiem + "%'"
                    + "or maBanDoc like '%" + timKiem + "%' or maThuThu like '%" + timKiem + "%'"
                    + " or maMuon like '%" + timKiem + "%'";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = layDuLieuTaiLieuMuon(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuMuonBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public boolean themTaiLieuMuon(TaiLieuMuon taiLieuMuon) {
        String sql = "insert into TaiLieuMuon(maMuon, maBanDoc, maTaiLieu, maThuThu, soLuong, ngayMuon, ngayTra)"
                + " values(N'" + taiLieuMuon.getMaMuon() + "', N'" + taiLieuMuon.getMaBanDoc()+ "', N'" + taiLieuMuon.getMaTaiLieu()+ "',"
                + " '" + taiLieuMuon.getMaThuThu() + "', N'" + taiLieuMuon.getSoLuong()+
                "', '" + new Date(taiLieuMuon.getNgayMuon().getTime())+ "', '" + new Date(taiLieuMuon.getNgayTra().getTime()) + "');";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean xoaTaiLieuMuon(String maMuon) {
        String sql = "delete TaiLieuMuon where maMuon = '" + maMuon + "';";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean suaTaiLieuMuon(TaiLieuMuon taiLieuMuon) {
        String sql = "update TaiLieuMuon "
                + " set maBanDoc = N'" 
                + taiLieuMuon.getMaBanDoc()+ "', maTaiLieu = '" + taiLieuMuon.getMaTaiLieu()+ "',"
                + " maThuThu = '" + taiLieuMuon.getMaThuThu() + "', soLuong = '" + taiLieuMuon.getSoLuong()+
                "', ngayMuon = '" + new Date(taiLieuMuon.getNgayMuon().getTime())+ "', ngayTra = '" 
                + new Date(taiLieuMuon.getNgayTra().getTime()) + "' where maMuon = '" + taiLieuMuon.getMaMuon() + "';";
        return dal.excuteNonQuery(sql);
    }
}
