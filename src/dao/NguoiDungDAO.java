/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DbContext;
import dto.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w7
 */
public class NguoiDungDAO {
    private DbContext db = new DbContext();
    public NguoiDung checkLogin(String TenDangNhap, String MatKhau)
    {
      NguoiDung user = null;
      Connection cnn=db.getConnection();
        try {
            PreparedStatement pstm=cnn.prepareStatement("select * from NguoiDung where TenDangNhap=? and MatKhau=?");
            pstm.setString(1, TenDangNhap);
            pstm.setString(2, MatKhau);
            ResultSet rs=pstm.executeQuery();
            if(rs.next())
            {
                user =new NguoiDung();
                user.setTenDangNhap(rs.getString(1));
                user.setMatKhau(rs.getString(2));
                user.setVaiTro(rs.getString(3));
            }

        } catch (SQLException ex) {
            System.err.print(ex.toString());
        }
      
      return user;
    }
   
}
