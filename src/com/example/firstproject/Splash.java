package com.example.firstproject;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Splash extends Activity implements OnClickListener, OnItemClickListener {

	private ListView listview;
	private ArrayList mListItem;
	private static final String TAG = "Splash";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.list_view);
		mListItem = ItemBO.getItems();
		ListAdapter adapter = new ListAdapter(Splash.this, R.id.list_view,
				mListItem);
		int count = adapter.getViewTypeCount();
		Log.d(TAG,"getViewTypeCount::"+count);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Log.d(TAG,"itemselected ::"+item.getItemId());
		switch (item.getItemId()) {
		case R.id.menu_item_listdemo:
			 startActivity(new Intent(this,ListDemo.class));
		return true;
			
		case R.id.menu_item_tab:
			Log.d(TAG,"tab menu click");
			 startActivity(new Intent(this,AndroidTabLayoutActivity.class));
			 return true;
			 
		case R.id.menu_item_static_fragment:
			startActivity(new Intent(this, RssfeedActivity.class));
			return true;
			
		case R.id.item_menu_fragment_tab:
			startActivity(new Intent(this,FragmentTabs.class));
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

	@Override
	public void onClick(View v) {
	}

	// ***ListAdapter***
	private class ListAdapter extends ArrayAdapter { //--CloneChangeRequired
		private ArrayList mList; //--CloneChangeRequired
		private Context mContext;

		public ListAdapter(Context context, int textViewResourceId,	ArrayList list) { //--CloneChangeRequired
			super(context, textViewResourceId, list);
			this.mList = list;
			this.mContext = context;
		}
		
		

		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;
			
//			Log.d(TAG,"convertView id ::"+convertView.getId());
			
		//	Log.d(TAG,"parent id ::"+parent.getId());
			Log.d(TAG,"getView ::");
			Log.d(TAG,"position::"+position);
		//	Log.d(TAG,"convertview::"+convertView.toString());
		//	Log.d(TAG,"parent::"+parent.toString());
			
			try {
				if (view == null) {
					LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					view = vi.inflate(R.layout.list_item, null); //modifying ui/data of list_item layout
				}
				final ItemBO listItem = (ItemBO) mList.get(position); //find value on the basis of position index.
				if (listItem != null) {
					// setting list_item views
					((TextView) view.findViewById(R.id.tv_name))
							.setText(listItem.getName());
					//implementing onclick listener on view ie row
					
				/*	view.setOnClickListener(new OnClickListener() {
						public void onClick(View arg0) { //--clickOnListItem
							Log.d(TAG,"setOnClickListener name ::"+listItem.getName());
							Intent myIntent = new Intent(Splash.this,
									Activity2.class);
							myIntent.putExtra("NAME", listItem.getName());
							startActivity(myIntent);
							finish();
						}
					});
					
				*/	
				}
			} catch (Exception e) {
				Log.i(Splash.ListAdapter.class.toString(), e.getMessage());
			}
			return view;
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	//	Log.d(TAG,"onItemClick::position::"+position);
	//	Log.d(TAG,"onItemClick::id::"+id);
	//	public void onClick(View arg0) { //--clickOnListItem
		
		ItemBO listItem = (ItemBO) mListItem.get(position);
		
			Log.d(TAG,"onItemClick name ::"+listItem.getName());
			Intent myIntent = new Intent(Splash.this,
					Activity2.class);
			myIntent.putExtra("NAME", listItem.getName());
			startActivity(myIntent);
			finish();
	//	}
		
			
	
		
	}
}
