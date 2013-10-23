package com.exe.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Anims extends FragmentActivity implements AnimationListener {
	TextView txtMessage;
	Button btnStart;

	// Animation
	Animation animFadein;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anims_layout);
		txtMessage = (TextView) findViewById(R.id.txtMsg);

	}

	public void onLoadAnim(View view) {
		if (view == findViewById(R.id.btnZoomOut))
			animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
					R.anim.zoom_out);

		else if (view == findViewById(R.id.btnBlink))
			animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
					R.anim.blink);

		else if (view == findViewById(R.id.btnZoomIn))
			animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
					R.anim.zoom_in);
		else if (view == findViewById(R.id.btnRotate))
			animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
					R.anim.rotate);
		else
			animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
					R.anim.move);
		animFadein.setAnimationListener(this);
		txtMessage.startAnimation(animFadein);
	}

	public void onBack(View view) {
		Intent backToMainActivity = new Intent();
		backToMainActivity.setClass(this, MainActivity.class);
		startActivity(backToMainActivity);
	}

	@Override
	public void onAnimationEnd(Animation arg0) {
		// TODO Auto-generated method stub
		if (arg0 == animFadein) {
			Toast.makeText(getApplicationContext(), "Animation Stopped",
					Toast.LENGTH_SHORT).show();
			txtMessage.setVisibility(View.INVISIBLE);
		}

	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation arg0) {
		// TODO Auto-generated method stub

	}
}
