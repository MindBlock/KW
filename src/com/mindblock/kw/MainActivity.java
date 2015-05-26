package com.mindblock.kw;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private ImageButton rotationButton;
	private final int audioSamples = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_main);
		
		this.initButtonEffect();
	}
	
	private void initButtonEffect(){
		this.rotationButton = (ImageButton) findViewById(R.id.kw_rotate_ib);
//		this.rotationButton.setLayoutParams(new LayoutParams(
//				this.getScreenDimension().x, 
//				this.getScreenDimension().x));
		
		
		
		this.rotationButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Play sound
				final MediaPlayer mp = MediaPlayer.create(MainActivity.this, getRandomAudioSample());
				mp.start();

				//Rotate
				RotateAnimation ra =new RotateAnimation(0, 360*3, 
						Animation.RELATIVE_TO_SELF, 0.5f, 
						Animation.RELATIVE_TO_SELF, 0.5f);
		        ra.setFillAfter(true);
		        ra.setDuration(2000);
		        rotationButton.startAnimation(ra);
			}
			
		});
	}
	
	private int getRandomAudioSample(){
		
		int r = new Random().nextInt(this.audioSamples);
		
		switch(r){
		
		case 0: 
			return R.raw.roy1;
		case 1:
			return R.raw.roy2;
		case 2:
			return R.raw.roy3;
		default:
			return R.raw.roy1;
		}
	}
	
	@SuppressLint("NewApi")
	private Point getScreenDimension(){
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		return size;
	}
}
