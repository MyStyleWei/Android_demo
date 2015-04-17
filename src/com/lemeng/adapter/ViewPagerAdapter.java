package com.lemeng.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerAdapter extends PagerAdapter{
	
	private List<View> viewList;
	Context context;
	
	public ViewPagerAdapter(Context context,List<View> list){
		this.context = context;
		this.viewList = list;
	}
	

	@Override
	public int getCount() {
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	
	//这个方法用来实例化页卡
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(viewList.get(position),0);
		return viewList.get(position);
	}
	
	//删除页卡  
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
             container.removeView(viewList.get(position));
	}
	
	

}
