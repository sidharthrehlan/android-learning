package com.example.firstproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDemo extends Activity implements OnItemClickListener {
	private static final String TAG = "ListDemo"; 

	ListView mylist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_demo);
		
		ListView mylist = (ListView) findViewById(R.id.listView_mylistdemo);
		String[] value = new String[] { "Android", "iPhone", "WindowsMobile",
				  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				  "Linux", "OS/2" };
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, value);
		
		mylist.setAdapter(adapter);
		
		mylist.setOnItemClickListener(this);
		
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Log.d(TAG, "onItemClick:: position::"+position);
		Log.d(TAG, "onItemClick:: id::"+id);
		
		Log.d(TAG,"item at position::"+parent.getItemAtPosition(position));
		
	}
	
	
	

}
