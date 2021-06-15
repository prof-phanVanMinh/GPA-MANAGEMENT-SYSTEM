/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class SinhVien {
         private String MaSV, HoTen, Email, DienThoai, DiaChi;
         private Boolean GioiTinh;

    public SinhVien(String MaSV, String HoTen, String Email, String DienThoai, String DiaChi, Boolean GioiTinh) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.Email = Email;
        this.DienThoai = DienThoai;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
    }

    public SinhVien() {
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
}
