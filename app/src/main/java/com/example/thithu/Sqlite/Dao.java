package com.example.thithu.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    Context context;
    SQLite sqLite;
    SQLiteDatabase db;

    public Dao(Context context) {
        this.context = context;
        sqLite = new SQLite(context);
        db = sqLite.getWritableDatabase();
    }

    public void insert(String ml, String msp, int dgn, int dgx, int sln, int slx, String nn, String nx,String maHD){
        ContentValues values = new ContentValues();
        values.put("MaTL",ml);
        ContentValues values1 = new ContentValues();
        values1.put("MaSP",msp);
        values1.put("MaTL",ml);
        ContentValues values2  = new ContentValues();
        values2.put("MaSP",msp);
        values2.put("MaHD",maHD);
        values2.put("SoLuongNhap",sln);
        values2.put("SoLuongXuat",slx);
        ContentValues values3  = new ContentValues();
        values3.put("MaHD",maHD);
        values3.put("NgayNhap",nn);
        values3.put("NgayXuat",nx);
        values3.put("DonGiaNhap",dgn);
        values3.put("DonGiaXuat",dgx);
        db.insert("THELOAI",null,values);
        db.insert("SANPHAM",null,values1);
        db.insert("HOADON",null,values2);
        db.insert("HOADONCT",null,values3);
    }
    public List<String> getAll(){
        List<String> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select MaTL,SANPHAM.MaSP, SoLuongNhap, SoLuongXuat, DonGiaNhap, DonGiaXuat, " +
                                                "NgayNhap, NgayXuat FROM HOADONCT INNER JOIN HOADON ON HOADONCT.MaHD = HOADON.MaHD " +
                                                "INNER JOIN SANPHAM ON HOADON.MaSP = SANPHAM.MaSp ",
                                                null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            list.add("Mã thể loại: "+cursor.getString(0)+"\n"+
                    "Mã sản phẩm: "+cursor.getString(1)+"\n"+
                    "Số lượng nhập: "+cursor.getInt(2)+"\n"+
                     "Số lượng xuất: "+cursor.getInt(3)+"\n"+
                     "Đơn giá nhập: "+cursor.getInt(4)+"\n"+
                     "Đơn giá xuất: "+cursor.getInt(5)+"\n"+
                     "Ngày nhập: "+cursor.getString(6)+"\n"+
                     "Ngày xuất: "+cursor.getString(7));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}