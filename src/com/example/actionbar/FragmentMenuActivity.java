package com.example.actionbar;



import com.lemeng.fragment.FragmentCategory;
import com.lemeng.fragment.FragmentDown;
import com.lemeng.fragment.FragmentHome;
import com.lemeng.fragment.FragmentSetting;
import com.lemeng.fragment.FragmentUser;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;


public class FragmentMenuActivity extends FragmentActivity {

	private FragmentTabHost tabHost;
	private LayoutInflater inflater;
	// 定义数组来存放Fragment界面
	private Class fragmentArray[] = { FragmentHome.class,
			FragmentCategory.class, FragmentDown.class, FragmentUser.class,
			FragmentSetting.class };
	// 定义数组来存放按钮图片
	private int mImageViewArray[] = { R.drawable.main_tab_item_home,
			R.drawable.main_tab_item_category, R.drawable.main_tab_item_down,
			R.drawable.main_tab_item_user, R.drawable.main_tab_item_setting };

	// Tab选项卡的文字
	private String mTextviewArray[] = { "主页", "分类", "下载", "我的", "设置" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide_menu);
		initView();
	}

	private void initView(){
		
		inflater = LayoutInflater.from(this);
		// 实例化TabHost对象，得到TabHost
		tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		tabHost.setup(this, getSupportFragmentManager(),R.id.realtabcontent);
		
		// 得到fragment的个数
		int count = fragmentArray.length;
		for(int i = 0; i < count ; i++){
			// 为每一个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = tabHost.newTabSpec(mTextviewArray[i])
					.setIndicator(getTabItemView(i));
			// 将Tab按钮添加进Tab选项卡中
			tabHost.addTab(tabSpec,fragmentArray[i],null);
			// 设置Tab按钮的背景
			tabHost.getTabWidget().getChildAt(i)
			.setBackgroundResource(R.drawable.main_tab_item_bg);
			
		}

		
	}

	private View getTabItemView(int index){
		View view = inflater.inflate(R.layout.tab_item_view, null);
		
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);
		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextviewArray[index]);
		
		return view;
	}

}
