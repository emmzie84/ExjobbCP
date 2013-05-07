package com.example.exjobb;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DrugsTable {
	public static final String DATABASE_TABLE = "drugs";
	public static final String ROW_ID = "_id";
	public static final String DRUG_NAME = "drug_name";
	public static final String TYPE = "type";
	public static final String POTENCY = "potency";
	public static final String SIZE = "size";
	public static final String PREFERENTIAL_PRICE = "preferential_price";
	public static final String PRESCRIPTION_ONLY = "prescription_only";
	
	private static final String CREATE_TABLE_DRUGS = "create table " + DATABASE_TABLE + "(" + ROW_ID + " integer primary key autoincrement, "
		+ DRUG_NAME + " text not null,"
		+ TYPE + " text not null,"
		+ POTENCY + " text not null,"
		+ SIZE + " text not null,"
		+ PREFERENTIAL_PRICE + " text not null,"
		+ PRESCRIPTION_ONLY + " text not null" + ");";
	
	public static void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_DRUGS);
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DrugsTable.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS "  + DATABASE_TABLE);
		onCreate(db);
			
	}
}
