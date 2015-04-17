package com.lemeng.application;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

public class App extends Application{
	public Context mContext;
	public static ArrayList<Activity> activities;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mContext = getApplicationContext();
	}
	
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	
	public static void removeAcyivity(Activity activity){
		activities.remove(activity);
	}
	
	public static void exist(){
		for(Activity activity :activities){
			if(activity != null){
			activity.finish();
			}
		}
	}
	

}
