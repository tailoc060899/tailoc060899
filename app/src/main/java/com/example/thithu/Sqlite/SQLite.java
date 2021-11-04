package com.example.thithu.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {
    public static String DB_NAME="AAAAA";
    public static int VERSION = 1;
    public SQLite(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table_TheLoai = "CREATE TABLE THELOAI (" +
                "MaTL TEXT PRIMARY KEY )";
        sqLiteDatabase.execSQL(table_TheLoai);

        String table_SanPham = "CREATE TABLE SANPHAM (" +
                "MaSP TEXT PRIMARY KEY, " +
                "MaTL TEXT REFERENCES THELOAI(MaTL))";
        sqLiteDatabase.execSQL(table_SanPham);

        String table_HoaDon = "CREATE TABLE HOADON (" +
                "MaHD TEXT PRIMARY KEY, " +
                "MaSP text references SANPHAM(MaSP), " +
                "SoLuongNhap integer, " +
                "SoLuongXuat integer )";
        sqLiteDatabase.execSQL(table_HoaDon);
        String table_HoaDonCT = "CREATE TABLE HOADONCT (" +
                "MaHDCT INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MaHD text references  HOADON(MaHD), " +
                "NgayNhap Text, " +
                "NgayXuat text, " +
                "DonGiaNhap integer,  " +
                "DonGiaXuat integer )";
        sqLiteDatabase.execSQL(table_HoaDonCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
