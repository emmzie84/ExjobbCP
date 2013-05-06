package com.example.exjobb;

import java.lang.reflect.Array;
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
	private static final String BASE_PATH = "drugs";
	
	public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/" + BASE_PATH);
	public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + BASE_PATH;
	public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + BASE_PATH;
	
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
		//checkColumns(projection);
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
	
	/*private void checkColumns(String[] projection) {
		String[] available = { DrugsTable.DRUG_NAME, DrugsTable.TYPE, DrugsTable.POTENCY, DrugsTable.SIZE, DrugsTable.PREFERENTIAL_PRICE, DrugsTable.PRESCRIPTION_ONLY, DrugsTable.ROW_ID};
		if (projection != null) {
			HashSet<String> requestedColumns = new HashSet<String>(Array.asList(projection));
			Has
		}		
	}*/

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
