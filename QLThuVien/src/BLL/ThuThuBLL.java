/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Class.BanDoc;
import Class.ThuThu;
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
public class ThuThuBLL 
{
    DAL dal=new DAL();
    Connection conn;
    public DefaultTableModel laydulieuthuthu(ResultSet rs,JTable tbl) 
    {
            DefaultTableModel model=null;
            try
            {
            model=(DefaultTableModel) tbl.getModel();
            while(rs.next())
            {
            model.addRow(new Object[]
            {
                rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
            });
            }
    }
    
            catch(SQLException ex)
            {
                Logger.getLogger(ThuThuBLL.class.getName()).log(Level.SEVERE,null,ex);
            }
            return model;
    }
     public DefaultTableModel xemtatcathuthu(JTable tbl) {
        DefaultTableModel model = null;
        try {
            String sql = "select * from dbo.ThuThu";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = laydulieuthuthu(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ThuThuBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
      public boolean themthuthu(ThuThu thuThu) {
            int i = 0;
        try {
            String sql = "insert into BanDoc(maBanDoc, tenBanDoc, ngaySinh, diaChi, lop)"
                    + " values (N'" + thuThu.getMaThuThu() + "', N'" + thuThu.getDiaChi()+ "',"
                    + " '" + new Date(thuThu.getNgaySinh().getTime()) + "', N'" + thuThu.getDiaChi() +
                    "', N'" + thuThu.getSoDT()+ "')";
            conn = dal.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThuThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i > 0;
    }
    
public DefaultTableModel timKiemThuThu(JTable tbl, String timKiem) {
        DefaultTableModel model = null;
        try {
            
            String sql = "select * from dbo.ThuThu where maThuThu like '%" + timKiem + "%'"
                    + "or tenThuThu like '%" + timKiem + "%'";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = laydulieuthuthu(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BanDocBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public boolean xoaThuThu(String maThuThu) {
        String sql = "delete dbo.ThuThu where maThuThu = '" + maThuThu + "';"
                + "delete TaiKhoan where taiKhoan = '" + maThuThu + "'";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean datLaiMatKhau(ThuThu thuthu) {
        String sql = "update TaiKhoan set matKhau = '" + new SimpleDateFormat("ddMMyyyy").format(thuthu.getNgaySinh())
               + "' where taiKhoan = N'" + thuthu.getMaThuThu() + "'";
        return dal.excuteNonQuery(sql);
    }
    
    public boolean suaThuThu(ThuThu thuthu) {
         String sql = "update dbo.ThuThu "
                + "set tenThuThu = N'" + thuthu.getTenThuThu() + "',"
                + " ngaySinh = '" + new Date(thuthu.getNgaySinh().getTime()) + "', diaChi = N'" + thuthu.getDiaChi() +
                "', soDT = N'" + thuthu.getSoDT() + "' where maThuThu = '" + thuthu.getMaThuThu() + "';";
        return dal.excuteNonQuery(sql);
    }
    
}
