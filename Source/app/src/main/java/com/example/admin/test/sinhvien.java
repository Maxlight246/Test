package com.example.admin.test;

import android.util.Log;

public class sinhvien {
    int tuoi;
    String ten,diachi;
    public static String Tag  = "sinhvien";
    public sinhvien(int tuoi, String ten, String diachi) {
        this.tuoi = tuoi;
        this.ten = ten;
        this.diachi = diachi;
    }

    public sinhvien() {
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
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


}
