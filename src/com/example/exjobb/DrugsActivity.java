package com.example.exjobb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

public class DrugsActivity extends Activity {
	String[] drugs;
	String[] types;
	String[] volumes;
	String[] potency;
	String[] nbr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drugs);
		
		Uri uri = Uri.parse("content://com.example.exjobb.MyContentProvider/drugs");
		String[] projection = { DrugsTable.DRUG_NAME, DrugsTable.TYPE, DrugsTable.POTENCY, DrugsTable.SIZE, DrugsTable.PREFERENTIAL_PRICE, DrugsTable.PRESCRIPTION_ONLY};
		//Cursor c = getContentResolver().query(uri, projection, null, null, null);
		//if (c != null) {
			//c.moveToFirst();
			//Toast.makeText(getBaseContext(), "Första raden i tabellen", Toast.LENGTH_SHORT).show();
			/*do{
				Toast.makeText(this,
				c.getString(c.getColumnIndex(DrugsTable.ROW_ID)) + ", " +
				c.getString(c.getColumnIndex(DrugsTable.DRUG_NAME)) + ", " +
				c.getString(c.getColumnIndex(DrugsTable.TYPE)),
				Toast.LENGTH_SHORT).show();
				} while (c.moveToNext());*/
		//}
		
		drugs = getResources().getStringArray(R.array.drugs_array);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, drugs);
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.txtDrugs);		
		textView.setThreshold(2);
		textView.setAdapter(adapter);
		
		types = getResources().getStringArray(R.array.type_array);
		Spinner sp1 = (Spinner) findViewById(R.id.spiType);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
		sp1.setAdapter(adapter2);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = arg0.getSelectedItemPosition();
				Toast.makeText(getBaseContext(), "You've selected item: " + types[index], Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		potency = getResources().getStringArray(R.array.potency_array);
		Spinner sp2 = (Spinner) findViewById(R.id.spiPot);
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, potency);
		sp2.setAdapter(adapter3);
		sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = arg0.getSelectedItemPosition();
				Toast.makeText(getBaseContext(), "You've selected item: " + potency[index], Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		volumes = getResources().getStringArray(R.array.volumes_array);
		Spinner sp4 = (Spinner) findViewById(R.id.spiVol);
		ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, volumes);
		sp4.setAdapter(adapter5);
		sp4.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = arg0.getSelectedItemPosition();
				Toast.makeText(getBaseContext(), "You've selected item: " + volumes[index], Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		nbr = getResources().getStringArray(R.array.nbr_array);
		Spinner sp3 = (Spinner) findViewById(R.id.spiNbr);
		//ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.nbr_array, R.layout.spinner_item_row);
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nbr);
		sp3.setAdapter(adapter4);
		sp3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = arg0.getSelectedItemPosition();
				Toast.makeText(getBaseContext(), "You've selected item: " + nbr[index], Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	private void DisplayDrug(Cursor c) {
		Toast.makeText(this, "Display my drug...", Toast.LENGTH_LONG).show();
		Toast.makeText(this, "id: " + c.getString(0) + "\n" + "name: " + c.getShort(1), Toast.LENGTH_LONG).show();		
	}

	public void CopyDB(InputStream inputStream, FileOutputStream outputStream) throws IOException {
		Toast.makeText(getBaseContext(), "File copied in DrugsDBAdapter!", Toast.LENGTH_LONG).show();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}
	
	public void onClickNext(View view) {
		startActivity(new Intent(this, PharmaciesActivity.class));
		finish();
	}
	
	public void onClickBack(View view) {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drugs, menu);
		return true;
	}*/

}
