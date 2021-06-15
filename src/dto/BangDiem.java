/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author w7
 */
public class BangDiem {
    private String MaSV;
    private Float TiengAnh, TinHoc, GDTC;

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public Float getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(Float TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public Float getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(Float TinHoc) {
        this.TinHoc = TinHoc;
    }

    public Float getGDTC() {
        return GDTC;
    }

    public void setGDTC(Float GDTC) {
        this.GDTC = GDTC;
    }

    public BangDiem(String MaSV, Float TiengAnh, Float TinHoc, Float GDTC) {
        this.MaSV = MaSV;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
    }

    public BangDiem() {
    }
}
