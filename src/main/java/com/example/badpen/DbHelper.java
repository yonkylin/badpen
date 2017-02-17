package com.example.badpen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/2/7.
 */

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        StringBuilder sql = new StringBuilder();
        sql.append("create table if not exists tb_bwl(")
                .append("id integer primary key autoincrement,")
                .append("title varchar(50),")
                .append("content varchar(200),")
                .append("createDate varchar(10),")
                .append("noticeDate varchar(10),")
                .append("noticeTime varchar(5))");
        db.execSQL(sql.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase name , int arg1,int arg2){

    }
}
