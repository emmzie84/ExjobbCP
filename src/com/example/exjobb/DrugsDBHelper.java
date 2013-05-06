package com.example.exjobb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DrugsDBHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "mydb";
	private static final int DATABASE_VERSION = 1;
	
	public DrugsDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		DrugsTable.onCreate(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		DrugsTable.onUpgrade(db, oldVersion, newVersion);
	}
	
}
