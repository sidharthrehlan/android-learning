package com.example.firstproject;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyListFragment extends Fragment {
	private final String TAG = "MyListFragment";
	private OnItemSelectedListener listener;
	
 @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	 Log.d(TAG,"onCreateView");
	 View view = inflater.inflate(R.layout.fragment_rsslist_overview, container, false);
	 
	 Button button = (Button) view.findViewById(R.id.button1);
	 button.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			 Log.d(TAG,"onClick");
			updateDetail();
		}
	});
	return view;
}
 
 public interface OnItemSelectedListener {
	
     public void onRssItemSelected(String link);
   }
 
 @Override
 public void onAttach(Activity activity) {
	 Log.d(TAG,"onAttach");
   super.onAttach(activity);
   if (activity instanceof OnItemSelectedListener) {
     listener = (OnItemSelectedListener) activity;
   } else {
     throw new ClassCastException(activity.toString()
         + " must implemenet MyListFragment.OnItemSelectedListener");
   }
 }
 
 
 public void updateDetail(){
	 Log.d(TAG,"updateDetail");
	  String newTime = String.valueOf(System.currentTimeMillis());
	  listener.onRssItemSelected(newTime);
 }
}
 