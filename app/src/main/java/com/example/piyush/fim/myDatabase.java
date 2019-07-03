package com.example.piyush.fim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDatabase extends SQLiteOpenHelper {
    private static  final String Database_Name="student.db";
    private static  final String TABLE_NAME="student";
    private static  final String COL_1="ID";
    private static  final String COL_2="ROLL";
    private static  final String COL_3="NAME";
    private static  final String COL_4="SURNAME";

    public myDatabase(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table  "+TABLE_NAME+" "+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ROLL TEXT, NAME TEXT, SURNAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String roll,String nem,String srnem)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,roll);
        contentValues.put(COL_3,nem);
        contentValues.put(COL_4,srnem);
        long res = database.insert(TABLE_NAME,null,contentValues);
        if (res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getAllData()
    {
        SQLiteDatabase database= this.getReadableDatabase();
        Cursor result= database.rawQuery("select * from "+TABLE_NAME, null);
        return result;
    }
    public boolean isUpate(String id, String roll ,String nem ,String srnem)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,roll);
        contentValues.put(COL_3,nem);
        contentValues.put(COL_4,srnem);

        database.update(TABLE_NAME,contentValues,"ID=?", new String[]{id});

        return  true;

    }

    public Integer deleteData(String id)
    {
        SQLiteDatabase database= this.getWritableDatabase();
        return database.delete(TABLE_NAME,"ID=?",new String[]{id});
    }
}