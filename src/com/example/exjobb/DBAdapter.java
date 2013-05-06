package com.example.exjobb;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
	public static final String DATABASE_NAME = "mydb";
	public static final int DATABASE_VERSION = 1;
	
	/*private static final String CREATE_TABLE_DRUGS = "create table drugs (_id integer primary key autoincrement, "
			+ DrugsTable.DRUG_NAME + " TEXT,"
			+ DrugsTable.TYPE + " TEXT,"
			+ DrugsTable.POTENCY + " TEXT,"
			+ DrugsTable.SIZE + " TEXT,"
			+ DrugsTable.PREFERENTIAL_PRICE + " TEXT,"
			+ DrugsTable.PRESCRIPTION_ONLY + " TEXT" + ");";*/
	
	/*private static final String CREATE_TABLE_PHARMACIES = "create table pharmacies (_id integer primary key autoincrement, "
			+ PharmaciesDBAdapter.CHAIN_NAME + " TEXT,"
			+ PharmaciesDBAdapter.PHARMACY_NAME + " TEXT,"
			+ PharmaciesDBAdapter.ADDRESS + " TEXT,"
			+ PharmaciesDBAdapter.POSTAL_CODE + " INTEGER,"
			+ PharmaciesDBAdapter.POSTAL_AREA + " TEXT,"
			+ PharmaciesDBAdapter.LATITUDE + " TEXT,"
			+ PharmaciesDBAdapter.LONGITUDE + " TEXT,"
			+ PharmaciesDBAdapter.PHONE_NBR + " TEXT,"
			+ PharmaciesDBAdapter.OPENING_HOURS_WD + " TEXT,"
			+ PharmaciesDBAdapter.CLOSING_HOURS_WD + " TEXT,"
			+ PharmaciesDBAdapter.OPENING_HOURS_SAT + " TEXT,"
			+ PharmaciesDBAdapter.CLOSING_HOURS_SAT + " TEXT,"
			+ PharmaciesDBAdapter.OPENING_HOURS_SUN + " TEXT,"
			+ PharmaciesDBAdapter.CLOSING_HOURS_SUN + " TEXT" + ");";
	
	private static final String CREATE_TABLE_STOCK = "create table stock "
			+ StockDBAdapter.DRUG_ID + "(INTEGER,"
			+ StockDBAdapter.PHARMACY_ID + " INTEGER,"
			+ StockDBAdapter.NUMBER + " INTEGER,"
			+ StockDBAdapter.PRICE + " INTEGER" + ");";*/
	
	public void onCreate(SQLiteDatabase db) {
		//db.execSQL(CREATE_TABLE_DRUGS);
		//db.execSQL(CREATE_TABLE_PHARMACIES);
		//db.execSQL(CREATE_TABLE_STOCK);
	}
		
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DBAdapter.class.getName(), "Upgrading database from version " + oldVersion + "to " + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS drugs");
		onCreate(db);
	}
		
}
