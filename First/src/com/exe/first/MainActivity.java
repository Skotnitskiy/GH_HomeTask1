package com.exe.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements
		OnItemClickListener{
	private String[] mTitles;
	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	public ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer);
		mTitles = getResources().getStringArray(R.array.drawer_names);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.dravwer_items, mTitles));

		mDrawerList.setOnItemClickListener(this);

		mDrawerToggle = new ActionBarDrawerToggle(
				this,
				mDrawerLayout,
				R.drawable.ic_navigation_drawer_indicator,
				R.string.drawer_open, R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(R.string.app_name);
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle("Navigation Drawer");
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
	    super.onPostCreate(savedInstanceState);
	    mDrawerToggle.syncState();
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		if(mDrawerToggle.onOptionsItemSelected(item)) 
			return true;
      
      return super.onOptionsItemSelected(item);
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		selectItem(position);
	}

	private void selectItem(int position) {
		
		Fragment page = new Fragment();
		Intent anmIntent = new Intent();
		switch (position) {
		case 0:
			page = new Page1();
			break;
		case 1:
			page = new Page2();
			break;
		case 2:
			page = new Page3();
			break;
		case 3:
			anmIntent.setClass(this, Anims.class);
			startActivity(anmIntent);
		}
		FragmentTransaction tr = getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, page);
		tr.addToBackStack(null);
		tr.commit();
	}

}
