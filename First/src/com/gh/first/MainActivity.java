package com.gh.first;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		android.app.FragmentManager  fm = getFragmentManager();
		android.app.Fragment startFragment = new android.app.Fragment();
		fm.beginTransaction().add(R.id.fragment_placeholder, startFragment);
		fm.beginTransaction().commit();
		

	}

	public void onSelectFragment(View view) {
		
		Fragment newFragment = new Fragment();
		
		if (view == findViewById(R.id.btnStartFrag)) {
			newFragment = new StartFragment();
		} else if (view == findViewById(R.id.btnFrag1)) {
			newFragment = new Fragment1();
		} else if (view == findViewById(R.id.btnFrag2)) {
			newFragment = new Fragment2();
		} else {
			newFragment = new StartFragment();
		}
		
		FragmentTransaction tr = 
		getFragmentManager().beginTransaction().replace(R.id.fragment_placeholder, newFragment);
		tr.addToBackStack(null);
		tr.commit();

	}
}
