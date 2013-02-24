package com.example.firstproject;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

public class FragmentTabs extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// return activity action bar
		final ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.setDisplayOptions(1, ActionBar.DISPLAY_SHOW_TITLE);
		bar.setDisplayShowTitleEnabled(false);


		Tab tab = bar.newTab();
		tab.setText("Song");
		TabListener<SongFragment> listener1 = new TabListener<SongFragment>(this, "Song", SongFragment.class);
		tab.setTabListener(listener1);
		tab.setIcon(getResources().getDrawable(R.drawable.icon_music_tab));
		
	//	getResources().getDrawable(R.drawable.icon_photos_tab);
		
		
		bar.addTab(tab);
		
		
		Tab tab2 = bar.newTab();
		tab2.setText("Video");
		TabListener<VideoFragment> listener2 = new TabListener<VideoFragment>(this, "Video", VideoFragment.class);
		tab2.setTabListener(listener2);
		tab2.setIcon(getResources().getDrawable(R.drawable.icon_video_tab));
		bar.addTab(tab2);
		
		Tab tab3 = bar.newTab();
		tab3.setText("Photo");
		TabListener<ImageFragment> listener3 = new TabListener<ImageFragment>(this, "Video", ImageFragment.class);
		tab3.setTabListener(listener3);
		tab3.setIcon(getResources().getDrawable(R.drawable.icon_photos_tab));
		bar.addTab(tab3);
		
		Tab tab4 = bar.newTab();
		tab4.setText("Song2");
		TabListener<SongFragment> listener4 = new TabListener<SongFragment>(this, "Song2", SongFragment.class);
		tab4.setTabListener(listener4);
		bar.addTab(tab4);
		
		Tab tab5 = bar.newTab();
		tab5.setText("Video2");
		TabListener<VideoFragment> listener5 = new TabListener<VideoFragment>(this, "Video2", VideoFragment.class);
		tab5.setTabListener(listener5);
		bar.addTab(tab5);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
	}

	public static class TabListener<T extends Fragment> implements ActionBar.TabListener {
		private Activity mActivity;
		private String mTag;
		private Class<T> mClass;
		private Bundle mArgs;
		private Fragment mFragment;

		public TabListener(Activity activity, String tag, Class<T> clz) {
			this(activity, tag, clz, null);
		}

		public TabListener(Activity activity, String tag, Class<T> clz,
				Bundle args) {

			mActivity = activity;
			mTag = tag;
			mClass = clz;
			mArgs = args;

			mFragment = mActivity.getFragmentManager().findFragmentByTag(mTag);

			// if fragment is alread attached(only work with api 13)
			if (mFragment != null && !mFragment.isDetached()) {
				FragmentTransaction ft = mActivity.getFragmentManager()
						.beginTransaction();
				ft.detach(mFragment);
				ft.commit();
			}
		}

		// if mFragment is null then add it to fragment Transation
		// else attach it to fragmentTransation
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if(mFragment == null){
				mFragment = Fragment.instantiate(mActivity, mClass.getName(), mArgs);
				ft.add(android.R.id.content, mFragment, mTag);
			}
			else{
				ft.attach(mFragment);
			}
		}
		
		//if mFragment already exist then detach it on tab unselected
		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if(mFragment !=null){
				ft.detach(mFragment);
			}
		}
		
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			Toast.makeText(mActivity, "Tab released", Toast.LENGTH_SHORT).show();
		}
		
		

	}
}
