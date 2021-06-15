/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import dto.BangDiem;

/**
 *
 * @author LENOVO
 */
public class BangDiemDAO {
    private DbContext db =new DbContext();
     public boolean insert( BangDiem bd)
    {  
        Connection cnn=db.getConnection();
        try {
            PreparedStatement pstm=cnn.prepareStatement("insert into bangdiem(masv,tienganh,tinhoc,gdtc) values(?, ?, ?, ?)");
            pstm.setString(1, bd.getMaSV());
            pstm.setString(2, String.valueOf(bd.getTiengAnh()));
            pstm.setString(3, String.valueOf(bd.getTinHoc()));
            pstm.setString(4, String.valueOf(bd.getGDTC()));
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }
    public BangDiem FindSV(String masv)
    {
        BangDiem bd=null;
        Connection cnn=db.getConnection();
        PreparedStatement pstm;
        try {
            pstm = cnn.prepareStatement("select * from bangdiem where masv=?");
            pstm.setString(1, masv);
            ResultSet rs=pstm.executeQuery();
            if(rs.next())
            {
                bd=new BangDiem(rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5));
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return bd;
    }
    public boolean delete(String masv)
    {
        Connection cnn=db.getConnection();
        try {
            PreparedStatement pstm=cnn.prepareStatement("delete from bangdiem where masv=?");
            pstm.setString(1, masv);
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }
    public ArrayList<BangDiem> selectAll()
    {
          ArrayList<BangDiem> dsBangDiems = new ArrayList<>();
        try {
            Connection cnn=db.getConnection();
            PreparedStatement pstm=cnn.prepareStatement("select * from bangdiem");
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                BangDiem sv =new BangDiem(rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5));
                dsBangDiems.add(sv);
            }
        } catch (SQLException ex) {
            System.err.print(ex.toString());
        }
        return dsBangDiems;
    }
//    public  boolean Edit(SinhVien sv)
//    {
//        try {
//            Connection cnn = db.getConnection();
//            PreparedStatement pstm=cnn.prepareStatement("update sinhvien set hoten=?, gioitinh=?, email=?, dienthoai=?, diachi=? where masv=?");
//            pstm.setString(1, sv.getHoTen());
//            pstm.setBoolean(2, sv.getGioiTinh());
//            pstm.setString(3, sv.getEmail());
//            pstm.setString(4, sv.getDienThoai());
//            pstm.setString(5, sv.getDiaChi());
//            pstm.setString(6, sv.getMaSV());
//            return pstm.executeUpdate()>0;
//        } catch (SQLException ex) {
//            System.err.print(ex.toString());
//        }
//        return false;
//    }
}
