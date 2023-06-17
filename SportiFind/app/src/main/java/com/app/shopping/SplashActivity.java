package com.app.shopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.app.shopping.ViewHolder.SlideActivity;

public class SplashActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		ImageView myImage = findViewById(R.id.my_image);
		ImageView slogan1 = findViewById(R.id.slogan);
		AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
		fadeIn.setDuration(3000);
		myImage.startAnimation(fadeIn);
		slogan1.startAnimation(fadeIn);


		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this, SlideActivity.class);
				startActivity(intent);
				finish();
			}
		}, 5000);


	}
}