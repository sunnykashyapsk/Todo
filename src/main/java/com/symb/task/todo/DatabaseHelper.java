package com.symb.task.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public  class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dname";
    public static final String TABLE_NAME = "tname";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createtable="create table "+ TABLE_NAME +"(id INTEGER PRIMARY KEY, txt TEXT,datetime default current_timestamp )";
        sqLiteDatabase.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertt(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("txt", s);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }
    public ArrayList getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> array_list = new ArrayList<String>();
        Cursor res = db.rawQuery( "select (txt || ' : '|| datetime) As Name from "+TABLE_NAME+" WHERE datetime >= DATE('now') ", null );
        res.moveToFirst();
        while(!res.isAfterLast()) {
            array_list.add(res.getString(res.getColumnIndex("Name")));
            res.moveToNext();
        }
        return array_list;
    }

}
