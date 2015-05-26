package com.mindblock.kw;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private ImageButton rotationButton;

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
		this.rotationButton.setLayoutParams(new LayoutParams(
				this.getScreenDimension().x, 
				this.getScreenDimension().x));
		
		this.rotationButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Rotate
				RotateAnimation ra =new RotateAnimation(0, 360);
		        ra.setFillAfter(true);
		        ra.setDuration(1000);
		        rotationButton.startAnimation(ra);
				
		        //Play sound
		        
			}
		});
	}
	
	@SuppressLint("NewApi")
	private Point getScreenDimension(){
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		return size;
	}
}
