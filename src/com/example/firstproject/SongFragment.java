package com.example.firstproject;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SongFragment extends Fragment {
	private final String TAG = "SongFragment";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG,"onCreateView");
		
		View view = inflater.inflate(R.layout.song_layout, container, false);
		return view;
		
		//return super.onCreateView(inflater, container, savedInstanceState);
	}
}
