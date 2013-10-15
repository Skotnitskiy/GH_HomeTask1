package com.gh.first;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onSelectFragment(View view) {
		Fragment newFragment = new Fragment();
		if (view == findViewById(R.id.btnStartFrag)) {
			newFragment = new StartFragment();
		} else if (view == findViewById(R.id.btnFrag1)) {
			newFragment = new Fragment1();
		} else if (view == findViewById(R.id.btnFrag2)) {
			newFragment = new Fragment2();
		}

		FragmentTransaction tr = getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_placeholder, newFragment);
		tr.commit();

	}
}
