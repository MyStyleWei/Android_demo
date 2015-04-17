package com.example.actionbar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;

public class SplashActivity extends Activity implements Runnable{
	
	public static final int VERSION = 1;
	public  static SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		new Thread(this).start();
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
			
			
			sp = getSharedPreferences("cogfig", MODE_APPEND);
			if((sp.getInt("VERSION", 0) != VERSION)){
				startActivity(new Intent(this,GuideActivity.class));
				finish();
			}else{
				startActivity(new Intent(this,MainActivity.class));
				finish();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
