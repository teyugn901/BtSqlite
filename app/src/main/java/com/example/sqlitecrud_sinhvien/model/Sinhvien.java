package com.example.sqlitecrud_sinhvien.model;

public class Sinhvien {
    private String masv, ten, lop;

    public Sinhvien() {
    }

    public Sinhvien(String masv, String ten, String lop) {
        this.masv = masv;
        this.ten = ten;
        this.lop = lop;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
