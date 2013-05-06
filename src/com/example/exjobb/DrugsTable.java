package com.example.exjobb;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DrugsTable {
	static final String DATABASE_TABLE = "drugs";
	static final String ROW_ID = "_id";
	static final String DRUG_NAME = "drug_name";
	static final String TYPE = "type";
	static final String POTENCY = "potency";
	static final String SIZE = "size";
	static final String PREFERENTIAL_PRICE = "preferential_price";
	static final String PRESCRIPTION_ONLY = "prescription_only";
	
	static final String CREATE_TABLE_DRUGS = "create table drugs (_id integer primary key autoincrement, "
		+ DRUG_NAME + " TEXT,"
		+ TYPE + " TEXT,"
		+ POTENCY + " TEXT,"
		+ SIZE + " TEXT,"
		+ PREFERENTIAL_PRICE + " TEXT,"
		+ PRESCRIPTION_ONLY + " TEXT" + ");";
	
	public static void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_DRUGS);
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DBAdapter.class.getName(), "Upgrading database from version " + oldVersion + "to " + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS drugs");
		onCreate(db);
			
	}
	
	/*public Cursor getAllDrugs() {
		return this.mDB.query(DATABASE_TABLE, new String[] {ROW_ID, DRUG_NAME, TYPE, POTENCY, SIZE, PREFERENTIAL_PRICE, PRESCRIPTION_ONLY}, null, null, null, null, null);
	}*/
}
