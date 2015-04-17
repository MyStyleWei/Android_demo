package com.example.actionbar;

import com.lemeng.fragment.Fragment1;
import com.lemeng.fragment.Fragment2;
import com.lemeng.fragment.Fragment3;
import com.lemeng.fragment.TabListener;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.Tab;
import android.view.Menu;

public class CustomThemeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_theme);
		initView();
	}


	private void initView() {
		ActionBar bar = getActionBar();
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//添加选项卡
		Tab  tab = bar.newTab().setText("澳门风云2")
				     .setTabListener(new TabListener<Fragment1>(this,"file1",Fragment1.class));
		bar.addTab(tab);
		
		tab = bar.newTab().setText("五十度会")
				.setTabListener(new TabListener<Fragment2>(this,"file2",Fragment2.class));
		bar.addTab(tab);
		
		tab = bar.newTab().setText("爸爸去那儿饿2").
				setTabListener(new TabListener<Fragment3>(this,"file3",Fragment3.class));
		bar.addTab(tab);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.custom_theme, menu);
		return true;
	}

}
