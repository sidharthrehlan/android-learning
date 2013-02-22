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
		bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

		Tab tab = bar.newTab();
		tab.setText("Simple");
		
//		TabListener<ArtistFragment> listener = new TabListener<ArtistFragment>(this, "sample", ArtistFragment.class);
//
//		 tab.setTabListener(listener);

		bar.addTab(tab);

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
