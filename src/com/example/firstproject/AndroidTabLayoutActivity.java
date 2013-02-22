package com.example.firstproject;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AndroidTabLayoutActivity extends TabActivity {
	
	private String TAG = "TabLayoutActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_layout);
		
		TabHost tabHost = getTabHost();
		//PhotoTab
		TabSpec photospec = tabHost.newTabSpec("Photo");
		photospec.setIndicator("Photo", getResources().getDrawable(R.drawable.icon_photos_tab));
		Intent photoIntent = new Intent(this,PhotoActivity.class);
		photospec.setContent(photoIntent);
		
		
		//SongTab
		TabSpec musicspec = tabHost.newTabSpec("Song");
		musicspec.setIndicator("Song", getResources().getDrawable(R.drawable.icon_music_tab));
		Intent songIntent = new Intent(this,SongActivity.class);
		musicspec.setContent(songIntent);
		
		//Video Tab
		TabSpec videospec = tabHost.newTabSpec("Video");
		videospec.setIndicator("Video", getResources().getDrawable(R.drawable.icon_video_tab));
		Intent videoIntent = new Intent(this,VideoActivity.class);
		videospec.setContent(videoIntent);
		
	/*	videospec.setContent(new TabContentFactory() {
			
			@Override
			public View createTabContent(String tag) {
				
				return(new AnalogClock(AndroidTabLayoutActivity.this));
			}
				//return null;
		//	}
		});
		
	*/	
		
//		videospec.setContent(new TabContentFactory() {
//			
//			@Override
//			public View createTabContent(String tag) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		})
//		
		
		
		tabHost.addTab(photospec);
		tabHost.addTab(musicspec);
		tabHost.addTab(videospec);
		
		
//		
//        spec1.setContent(new TabContentFactory() {
//        	   
//   @Override
//   public View createTabContent(String tag) {
//    // TODO Auto-generated method stub
//    
//    return (new AnalogClock(TabDemo.this));
//   }
//		
//		
	}
}
