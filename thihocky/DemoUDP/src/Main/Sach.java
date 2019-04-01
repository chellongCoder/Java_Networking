/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author chellong
 */
import java.io.Serializable;

public class Sach implements Serializable {
    private int maSach;
    private String tenSach;
    private String nxb;
    private int soLuongTong;
    private int soLuongMuon;

    public Sach(int maSach, String tenSach, String nxb, int soLuongTong, int soLuongMuon) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nxb = nxb;
        this.soLuongTong = soLuongTong;
        this.soLuongMuon = soLuongMuon;
    }

    public Sach() {
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public int getSoLuongTong() {
        return soLuongTong;
    }

    public void setSoLuongTong(int soLuongTong) {
        this.soLuongTong = soLuongTong;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    @Override
    public String toString() {
        return "Cau2.Sach{" +
                "maSach=" + maSach +
                ", tenSach='" + tenSach + '\'' +
                ", nxb='" + nxb + '\'' +
                ", soLuongTong=" + soLuongTong +
                ", soLuongMuon=" + soLuongMuon +
                '}';
    }
}
