/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Class.ThuThu;
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
public class ThuThuBLL {

    DAL dal = new DAL();
    Connection conn;

    private DefaultTableModel layDuLieuThuThu(ResultSet rs, JTable tbl) {
        DefaultTableModel model = null;
        try {
            model = (DefaultTableModel) tbl.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuThuBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public DefaultTableModel xemTatCaThuThu(JTable tbl) {
        DefaultTableModel model = null;
        try {

            String sql = "select * from ThuThu";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = layDuLieuThuThu(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ThuThuBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public DefaultTableModel timKiemThuThu(JTable tbl, String timKiem) {
        DefaultTableModel model = null;
        try {

            String sql = "select * from ThuThu where maThuThu like '%" + timKiem + "%'"
                    + "or tenThuThu like '%" + timKiem + "%'";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = layDuLieuThuThu(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ThuThuBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public boolean themThuThu(ThuThu thuThu) {
        String sql = "insert into ThuThu(maThuThu, tenThuThu, ngaySinh, diaChi, soDT)"
                + " values (N'" + thuThu.getMaThuThu() + "', N'" + thuThu.getTenThuThu() + "',"
                + " '" + new Date(thuThu.getNgaySinh().getTime()) + "', N'" + thuThu.getDiaChi()
                + "', N'" + thuThu.getSoDT() + "');"
                + "insert into TaiKhoan values (N'" + thuThu.getMaThuThu() + "',"
                + " '" + new SimpleDateFormat("ddMMyyyy").format(thuThu.getNgaySinh()) + "', 'tt')";
        return dal.excuteNonQuery(sql);
    }

    public boolean xoaThuThu(String maThuThu) {
        String sql = "delete ThuThu where maThuThu = '" + maThuThu + "';"
                + "delete TaiKhoan where taiKhoan = '" + maThuThu + "'";
        return dal.excuteNonQuery(sql);
    }

    public boolean datLaiMatKhau(ThuThu thuThu) {
        String sql = "update TaiKhoan set matKhau = '" + new SimpleDateFormat("ddMMyyyy").format(thuThu.getNgaySinh())
                + "' where taiKhoan = N'" + thuThu.getMaThuThu() + "'";
        return dal.excuteNonQuery(sql);
    }

    public boolean suaThuThu(ThuThu thuThu) {
        String sql = "update ThuThu "
                + "set tenThuThu = N'" + thuThu.getTenThuThu() + "',"
                + " ngaySinh = '" + new Date(thuThu.getNgaySinh().getTime()) + "', diaChi = N'" + thuThu.getDiaChi()
                + "', soDT = N'" + thuThu.getSoDT() + "' where maThuThu = '" + thuThu.getMaThuThu() + "';";
        return dal.excuteNonQuery(sql);
    }
    
}
