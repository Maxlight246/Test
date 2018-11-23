package com.example.admin.test.Danhsachsinhvien;

public class Sinhvien {
    public String ten,diachi;
    public int tuoi;

    public Sinhvien(String ten, String diachi, int tuoi) {
        this.ten = ten;
        this.diachi = diachi;
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
