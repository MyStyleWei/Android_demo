package com.example.actionbar;

import java.util.ArrayList;
import java.util.List;

import com.lemeng.adapter.ViewPagerAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

public class ViewPagerActivity extends Activity {
	
	private View view1,view2,view3;
	private List<View> viewList;
	private ViewPager pager;
	private ViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		
		initView();
	}
	
	private void initView(){
		pager = (ViewPager) findViewById(R.id.vp);
		
		LayoutInflater inflater = getLayoutInflater().from(this);
		view1 = inflater.inflate(R.layout.layout1, null);
		view2 = inflater.inflate(R.layout.layout2, null);
		view3 = inflater.inflate(R.layout.layout3, null);
		
		viewList = new ArrayList<View>();
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		
		
		adapter = new ViewPagerAdapter(this, viewList);
		
		pager.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_pager, menu);
		return true;
	}

}
