/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DbContext;
import dto.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class SinhVienDAO {
    private DbContext db =new DbContext();
     public boolean insert(SinhVien sv)
    {  
        Connection cnn=db.getConnection();
        try {
            PreparedStatement pstm=cnn.prepareStatement("insert into sinhvien(masv,hoten,email,dienthoai,diachi,gioitinh) values(?, ?, ?, ?, ?, ?)");
            pstm.setString(1, sv.getMaSV());
            pstm.setString(2, sv.getHoTen());
            
            pstm.setString(3, sv.getEmail());
            pstm.setString(4, sv.getDienThoai());
            pstm.setString(5, sv.getDiaChi());
            pstm.setBoolean(6, sv.getGioiTinh());
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }
    public SinhVien FindSV(String masv)
    {
        SinhVien sv=null;
        Connection cnn=db.getConnection();
        PreparedStatement pstm;
        try {
            pstm = cnn.prepareStatement("select * from sinhvien where masv=?");
            pstm.setString(1, masv);
            ResultSet rs=pstm.executeQuery();
            if(rs.next())
            {
                sv=new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return sv;
    }
    public boolean delete(String masv)
    {
        Connection cnn=db.getConnection();
        try {
            PreparedStatement pstm=cnn.prepareStatement("delete from sinhvien where masv=?");
            pstm.setString(1, masv);
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }
    public ArrayList<SinhVien> selectAll()
    {
          ArrayList<SinhVien> dsSinhViens = new ArrayList<>();
        try {
            Connection cnn=db.getConnection();
            PreparedStatement pstm=cnn.prepareStatement("select * from sinhvien");
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                SinhVien sv =new SinhVien(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(5), rs.getString(6),rs.getBoolean(3));
                dsSinhViens.add(sv);
            }
        } catch (SQLException ex) {
            System.err.print(ex.toString());
        }
        return dsSinhViens;
    }
    public  boolean Edit(SinhVien sv)
    {
        try {
            Connection cnn = db.getConnection();
            PreparedStatement pstm=cnn.prepareStatement("update sinhvien set hoten=?, gioitinh=?, email=?, dienthoai=?, diachi=? where masv=?");
            pstm.setString(1, sv.getHoTen());
            pstm.setBoolean(2, sv.getGioiTinh());
            pstm.setString(3, sv.getEmail());
            pstm.setString(4, sv.getDienThoai());
            pstm.setString(5, sv.getDiaChi());
            pstm.setString(6, sv.getMaSV());
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            System.err.print(ex.toString());
        }
        return false;
    }
}
