package com.atguigu.cateyes.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class DBhelper extends SQLiteOpenHelper {

    public DBhelper(Context context,int version) {
        super(context,"users_db.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(_id integer primary key autoincrement,name varchar,password varchar)");

        db.execSQL("create table history(_id integer primary key autoincrement,history varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
