package com.example.actionbar;

import java.util.ArrayList;
import java.util.List;

import com.lemeng.adapter.ViewPagerAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class ViewGuideActivity extends Activity implements OnClickListener{
	
	private ViewPager pager;
	private List<View> view;
	private ImageView[] points;
	private int currentPoint;
	private static final int[] images = {R.drawable.guide1, R.drawable.guide2,
			R.drawable.guide3, R.drawable.guide4};
	
	private ViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_guide);
		
		initView();
		initData();
		initPoint();
	}
	private void initView(){
		pager = (ViewPager) findViewById(R.id.viewpager);
		view = new ArrayList<View>();
		adapter = new ViewPagerAdapter(this, view);
	}
	
	private void initData(){
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT, 
				LinearLayout.LayoutParams.MATCH_PARENT);
		for(int i = 0; i < images.length;i++){
			ImageView imageView = new ImageView(this);
			imageView.setLayoutParams(layoutParams);
			imageView.setScaleType(ScaleType.FIT_XY);
			imageView.setImageResource(images[i]);
			view.add(imageView);
		}
		
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
				setCurDot(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
				
			}
		});
		
	}
	
	
	private void initPoint(){
		LinearLayout layout = (LinearLayout) findViewById(R.id.ll);
		
		points = new ImageView[images.length];
		for(int i = 0;i< images.length;i++){
			points[i] = (ImageView) layout.getChildAt(i);
			points[i].setEnabled(true);
			points[i].setOnClickListener(this);
			points[i].setTag(i);
		}
		
		currentPoint = 0;
		points[currentPoint].setEnabled(false);
		
	}
	
	private void setCurView(int position){
		if(position < 0 || position >= images.length){
			return;
		}
		pager.setCurrentItem(position);
	}
	
	private void setCurDot(int positoin){
		if(positoin < 0 || positoin >images.length - 1|| currentPoint == positoin){
			return;
		}
		points[positoin].setEnabled(false);
		points[currentPoint].setEnabled(true);
		currentPoint = positoin;
	}

	@Override
	public void onClick(View v) {
	 int position = (Integer) v.getTag();
	  setCurView(position);
	  setCurDot(position);
		
	}

}
