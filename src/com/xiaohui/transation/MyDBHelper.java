package com.xiaohui.transation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

	public MyDBHelper(Context context) {
		super(context, "Account.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table account(idCard carchar(20),name varchar(20),money varchar(15))");
		db.execSQL("insert into account(idCard,name,money) values(?,?,?)",new String[]{"111","张三","2000"});
		db.execSQL("insert into account(idCard,name,money) values(?,?,?)",new String[]{"222","李四","3000"});
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
