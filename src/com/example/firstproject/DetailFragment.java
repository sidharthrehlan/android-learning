package com.example.firstproject;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
	private final String TAG ="DetailFragment";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG,"onCreateView");
		
		View view = inflater.inflate(R.layout.fragment_rssitem_detail, container, false);
		return view;
	}
	
	 public void setText(String item) {
		 Log.d(TAG,"setText");
		    TextView view = (TextView) getView().findViewById(R.id.detailsText);
		    view.setText(item);
		  }
}
