package com.example.actionbar;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView listView;
	private String[] str = {"SecondActivity","ListActivity","TabActivity","CustomThemeActivity","ViewPagerActivity"
			                   ,"ViewGuideActivity","DeskTopActivity","FragmentMenuActivity"};
	private ArrayAdapter<String> adapter;
	private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setOverflowShowingAlways();
        
        actionBar = getActionBar();
        
        listView = (ListView) findViewById(R.id.lv);
        adapter = new ArrayAdapter<String>(getApplicationContext(), 
        		android.R.layout.simple_list_item_1, str);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener() {

			@SuppressWarnings("unused")
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Class targetClass = null;
				
					switch (position) {
					case 0:
						targetClass = SecondActivity.class;
						break;
					case 1:
						targetClass = ListActivity.class;
						break;
					case 2:
						targetClass = TabActivity.class;
						break;
					case 3:
						targetClass = CustomThemeActivity.class;
						break;
					case 4:
						targetClass = ViewPagerActivity.class;
						break;
					case 5:
						targetClass = ViewGuideActivity.class;
						break;
					case 6:
						targetClass = DeskTopActivity.class;
						break;
					case 7:
						targetClass = FragmentMenuActivity.class;
						break;

					default:
						break;
					}
					if(targetClass != null){
					
					Intent intent = new Intent(MainActivity.this,targetClass);
					startActivity(intent);
					
				}
				
			}
		});
        
        
        
    }
    
    
    private void setOverflowShowingAlways(){
		try {
			ViewConfiguration configuration = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
		   	menuKeyField.setAccessible(true);
	    	
				menuKeyField.setBoolean(configuration, false);
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			} 
		 catch (NoSuchFieldException e) {

			e.printStackTrace();
		}
 
    }
    
    
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
    	if(featureId == Window.FEATURE_ACTION_BAR && menu != null){
    		if(menu.getClass().getSimpleName().equals("MenuBuilder")){
    			
				try {
					Method	m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", 
							Boolean.TYPE);
					m.setAccessible(true);
	    		
						m.invoke(menu, true);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    		}
    	}
    	return super.onMenuOpened(featureId, menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case android.R.id.home:
				Toast.makeText(getApplicationContext(), "ergw ", 0).show();
			case R.id.action_settings1:
				Toast.makeText(getApplicationContext(), "1", 0).show();
				break;
			case R.id.action_settings2:
				Toast.makeText(getApplicationContext(), "2", 0).show();
				break;
			case R.id.action_settings3:
				Toast.makeText(getApplicationContext(), "3", 0).show();
				break;
			case R.id.action_settings4:
				Toast.makeText(getApplicationContext(), "4", 0).show();
				break;
			
			default:
				break;
			}
    	return super.onOptionsItemSelected(item);
    }
    
}
