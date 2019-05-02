/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Class.TaiLieu;
import DAL.DAL;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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

public class TaiLieuBLL {
DAL dal=new DAL();
Connection conn;
private DefaultTableModel laydulieuTaiLieu(ResultSet rs,JTable tbl) throws SQLException
{
    DefaultTableModel model=null;
    try
    {
    model= (DefaultTableModel) tbl.getModel();
    while (rs.next())
    {
    model.addRow(new Object[]
    {
        rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getFloat(5)
    });
    }
    }
    catch(SQLException ex)
    {
        Logger.getLogger(TaiLieuBLL.class.getName()).log(Level.SEVERE,null,ex);
    }
    return model;
}
  public DefaultTableModel xemTatCaTaiLieu(JTable tbl) {
        DefaultTableModel model = null;
        try {
            
            String sql = "select * from dbo.TaiLieu";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = laydulieuTaiLieu(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BanDocBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
public DefaultTableModel timKiemTaiLieu(JTable tbl, String timKiem) {
        DefaultTableModel model = null;
        try {
            
            String sql = "select * from dbo.TaiLieu where maTaiLieu like '%" + timKiem + "%'"
                    + "or tenTaiLieu like '%" + timKiem + "%'";
            conn = dal.getConnection();
            ResultSet rs = dal.getTable(conn, sql);
            model = laydulieuTaiLieu(rs, tbl);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TaiLieuBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
 public boolean themTaiLieu(TaiLieu taiLieu) {
        String sql = "insert into dbo.TaiLieu(maTaiLieu, tenTaiLieu, soLuong, nhaXuatBan, gia)"
                + " values (N'" + taiLieu.getMaTaiLieu() + "', N'" + taiLieu.getTenTaiLieu() + "',"
                + " '" + taiLieu.getSoLuong() + "', N'" + taiLieu.getNhaXuatBan() +
                "', N'" + taiLieu.getGia() + "');";

        return dal.excuteNonQuery(sql);
    }
 public boolean xoaTaiLieu(String maTaiLieu) {
        String sql = "delete dbo.TaiLieu where maTaiLieu = '" + maTaiLieu + "';"
                +"delete TaiKhoan Where taiKhoan='"+maTaiLieu+"'";
                        
        return dal.excuteNonQuery(sql);
    }
       public boolean suaTaiLieu(TaiLieu taiLieu) {
         String sql = "update dbo.TaiLieu "
                + "set tenTaiLieu = N'" + taiLieu.getTenTaiLieu() + "',"
                + " soLuong = '" + taiLieu.getSoLuong() + "', nhaXuatBan = N'" + taiLieu.getNhaXuatBan() +
                "', gia = N'" + taiLieu.getGia() + "' where maTaiLieu = '" + taiLieu.getMaTaiLieu() + "';";
        return dal.excuteNonQuery(sql);
    }
    
}
