/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL;
import java.sql.ResultSet;

/**
 *
 * @author langt
 */
public class BanDocBLL {
    
    DAL dal = new DAL();
    
    public ResultSet xemTatCaBanDoc() {
        String sql = "select * from BanDoc";
        return dal.getTable(sql);
    }
}
