package com.cookandroid.timetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {
    static final String DB_TIMETABLE = "timetable.db";
    static final String TABLE_TIMETABLE = "timeTables";
    static final String DB_VERSION = "1";

    Context myContext = null;

    private  static DataBaseManager myDBManager = null;
    private SQLiteDatabase myDataBase = null;

    static DataBaseManager getInstance(Context context)
    {
        if(myDBManager == null)
        {
            myDBManager = new DataBaseManager(context);
        }
        return myDBManager;
    }

    private DataBaseManager(Context context)
    {
        myContext = context;

        myDataBase = context.openOrCreateDatabase(DB_TIMETABLE, context.MODE_PRIVATE,null);

        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_TIMETABLE + "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"day INTEGER," + "time INTEGER,"+"lectureName TEXT);");
    }



}
