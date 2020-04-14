package com.example.employeemanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    public static String DataBase_Name = "EmployeeDatabase.db";
    public static String COL_1 = "Name";
    public static String COL_2 = "Age";
    public static String COL_3 = "AnnualSalary";
    public static String COL_4 = "Rate";
    public static String COL_5 = "EmpId";
    public static String COL_6 = "EmpType";
    public static String COL_7 = "EmpPerformance";
    public static String COL_8 = "VehicleType";
    public static String COL_9 = "VTypeType";
    public static String COL_10 = "VehicleModel";
    public static String COL_11 = "VehiclePlate";
    public static String COL_12 = "VehicleColor";

    public DataHelper(@Nullable Context context) {
        super(context,DataBase_Name,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table EmplyeeTable(Name text,Age Text,AnnualSalary text,Rate text,EmpId text,EmpType text,EmpPerformance text,VehicleType text,VTypeType text,VehicleModel text,VehiclePlate text,VehicleColor text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int newVersion) {
        db.execSQL("Drop table if exists EmployeeTable");

    }