package com.example.firstproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener {
	
	private final String TAG = "RssfeedActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rssfeed);
		Log.d(TAG,"onCreate");
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	 @Override
	  public void onRssItemSelected(String link) {
		 Log.d(TAG,"onRssItemSelected");
	    DetailFragment fragment = (DetailFragment) getFragmentManager()
	            .findFragmentById(R.id.detailFragment);
	        if (fragment != null && fragment.isInLayout()) {
	          fragment.setText(link);
	        } 
	        else {
		          Intent intent = new Intent(getApplicationContext(),
		              DetailActivity.class);
		          intent.putExtra(DetailActivity.EXTRA_URL, link);
		          startActivity(intent);

		        }
	  }
	
	
}
