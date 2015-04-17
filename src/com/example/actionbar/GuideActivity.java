package com.example.actionbar;

import java.util.ArrayList;
import java.util.List;

import com.lemeng.adapter.ViewPagerAdapter;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GuideActivity extends Activity {
	
	private List<View> view;
	private View view1,view2,view3,view4;
	private ViewPagerAdapter adapter;
	private ViewPager pager;
	private Button button;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		
		pager = (ViewPager) findViewById(R.id.viewpager);
		
		view = new ArrayList<View>();
		
		LayoutInflater inflater = getLayoutInflater().from(this);
		view1 = inflater.inflate(R.layout.guide_view1, null);
		view2 = inflater.inflate(R.layout.guide_view2, null);
		view3 = inflater.inflate(R.layout.guide_view3, null);
		view4 = inflater.inflate(R.layout.guide_view4, null);
		
		view.add(view1);
		view.add(view2);
		view.add(view3);
		view.add(view4);
		
		adapter = new ViewPagerAdapter(this, view);
		
		pager.setAdapter(adapter);
		
		
		button = (Button) view4.findViewById(R.id.startBtn);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SplashActivity.sp.edit().putInt("VERSION", SplashActivity.VERSION).commit();
				startActivity(new Intent(GuideActivity.this,MainActivity.class));
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.guide, menu);
		return true;
	}

}
