package com.example.exjobb;

import java.util.Arrays;
import java.util.HashSet;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
	private DrugsDBHelper db;

	private static final int DRUGS = 10;
	private static final int DRUG_ID = 20;
	
	private static final String PROVIDER_NAME = "com.example.exjobb.mycontentprovider";
	private static final String BASE_PATH = "mydb"; //eller drugs?
	
	public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/" + BASE_PATH);
	public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/drugs";
	public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/drug";
	
	private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	static {
		sUriMatcher.addURI(PROVIDER_NAME, BASE_PATH, DRUGS);
		sUriMatcher.addURI(PROVIDER_NAME, BASE_PATH + "/#", DRUG_ID);
	}
	
	@Override
	public boolean onCreate() {
		db = new DrugsDBHelper(getContext());
		return false;
	}
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		checkColumns(projection);
		queryBuilder.setTables(DrugsTable.DATABASE_TABLE);
		
		int uriType = sUriMatcher.match(uri);
		switch(uriType) {
		case DRUGS:
			break;
		case DRUG_ID:
			queryBuilder.appendWhere(DrugsTable.ROW_ID + "=" + uri.getLastPathSegment());
			break;
		default:
			throw new IllegalArgumentException("Unknown URI: " + uri);
		}
		
		SQLiteDatabase sqldb = db.getWritableDatabase();
		Cursor c = queryBuilder.query(sqldb, projection, selection, selectionArgs, null, null, sortOrder);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}
	
	@Override
	public String getType(Uri uri) {
		return null;
	}
	
	@Override
	public Uri insert(Uri uri, ContentValues values) { //Behövs ej då jag bara ska hämta data
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) { //Behövs ej då jag bara ska hämta data
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int update(Uri uri, ContentValues values, String selection, //Behövs ej då jag bara ska hämta data
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void checkColumns(String[] projection) {
		String[] available = { DrugsTable.DRUG_NAME, DrugsTable.TYPE, DrugsTable.POTENCY, DrugsTable.SIZE, DrugsTable.PREFERENTIAL_PRICE, DrugsTable.PRESCRIPTION_ONLY, DrugsTable.ROW_ID};
		if (projection != null) {
			HashSet<String> requestedColumns = new HashSet<String>(Arrays.asList(projection));
			HashSet<String> availableColumns = new HashSet<String>(Arrays.asList(available));
			
			if (!availableColumns.containsAll(requestedColumns)) {
				throw new IllegalArgumentException("Unknown columns in projection");
			}
		}		
	}
}
