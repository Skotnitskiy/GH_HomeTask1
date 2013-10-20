package com.exe.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class MainActivity extends ActionBarActivity implements OnNavigationListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.action_array,
		          android.R.layout.simple_spinner_dropdown_item);
		bar.setListNavigationCallbacks(mSpinnerAdapter, this);
		
		
	}

	public void onSelectFragment(View view) {
		Fragment page = new Fragment();
		Intent anmIntent = new Intent();
		if (view == findViewById(R.id.btnPage1)) {
			page = new Page1();
		} else if (view == findViewById(R.id.btnPage2)) {
			page = new Page2();
		} else if (view == findViewById(R.id.btnPage3)) {
			page = new Page3();
		} else if(view == findViewById(R.id.btnAnims)){
			anmIntent.setClass(this, Anims.class);
			startActivity(anmIntent);
			finish();
		}

		FragmentTransaction tr = getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_placeholder, page);
		tr.commit();

	}

	
	@Override
	public boolean onNavigationItemSelected(int arg0, long arg1) {
	
		return false;
	}
}
