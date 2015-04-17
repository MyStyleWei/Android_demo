
package com.example.actionbar;

import com.lemeng.fragment.Fragment1;
import com.lemeng.fragment.Fragment2;
import com.lemeng.fragment.Fragment3;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Fragment;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class ListActivity extends Activity {
	
	private String[] array_list;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		initView();
	}

	private void initView() {
		ActionBar bar = getActionBar();
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
		
		array_list = getResources().getStringArray(R.array.action_fragment);
		SpinnerAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(),
				R.array.action_fragment,
				android.R.layout.simple_spinner_dropdown_item);
		
		bar.setListNavigationCallbacks(adapter, new OnNavigationListener() {
			
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				
				Fragment fragment = null;
				switch (itemPosition) {
				case 0:
					fragment = new Fragment1();
					break;
				case 1:
					fragment = new Fragment2();
					break;
				case 2:
					fragment = new Fragment3();
					break;

				default:
					break;
				}
				
				getFragmentManager().beginTransaction()
				   .replace(R.id.container, fragment,array_list[itemPosition]).commit();
		
				return true;
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

}
