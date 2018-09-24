package com.xiaohui.transation;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyDBHelper dbHelper = new MyDBHelper(getApplicationContext());
		db = dbHelper.getReadableDatabase();
	}

	public void trans(View v) {

		db.beginTransaction();
		try {
			db.execSQL("update account set money=money-100 where idCard=?",new String[]{"1111"});
			
			if(Math.random()*10 > 5){
				throw new Exception();
			}
			
			db.execSQL("update account set money=money+100 where idCard=?",new String[]{"2222"});
			db.setTransactionSuccessful();
			Toast.makeText(getApplicationContext(), "转账成功", 1).show();
		}catch(Exception e){
			Toast.makeText(getApplicationContext(), "转账失败", 1).show();
		} finally {
			db.endTransaction();
		}

	}
}
