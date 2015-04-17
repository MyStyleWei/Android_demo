package com.example.actionbar;

import com.lemeng.application.App;
import com.lemeng.util.DeskTopUtil;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;

public class DeskTopActivity extends Activity {
	
	
	private Button button;
	private DeskTopUtil util;
	private WindowManager manager;
	private WindowManager.LayoutParams params;
	private long startTime;
	
	//声明屏幕的宽高
	float x,y;
	int top;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_desk_top);
		
		createWindowManager();
		createDeskTopLayout();
		
		button = (Button) findViewById(R.id.btn);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showDesk();
			}
		});
	}
	//设置悬浮窗体
	private void createDeskTopLayout(){
		util = new DeskTopUtil(this);
		util.setOnTouchListener(new OnTouchListener() {
			float mTouchStartX;
			float mTouchStartY;
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//获取相对屏幕的坐标，即以屏幕左上角为原点
				x = event.getRawX();
				y = event.getRawY() - top;//25是系统状态栏的高度
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					//获取相对view的坐标，即以此view左上角为原点
					mTouchStartX = event.getX();
					mTouchStartY = event.getY();
					
					long end = System.currentTimeMillis() - startTime;
					//双击间隔在300ms一下
					if(end < 300){
						closeDesk();
					}
					startTime = System.currentTimeMillis();
					
					break;
				case MotionEvent.ACTION_MOVE:
					//更新悬浮窗口的位置参数
					params.x = (int)(x - mTouchStartX);
					params.y = (int)(y - mTouchStartY);
					manager.updateViewLayout(v, params);

					break;
				case MotionEvent.ACTION_UP:
					//更新悬浮窗口的位置参数
					params.x = (int)(x - mTouchStartX);
					params.y = (int)(y - mTouchStartY);
					manager.updateViewLayout(v, params);
					//可以在此记录最后一次的位置
					mTouchStartX = mTouchStartY = 0;
				default:
					break;
				}
				
				return true;
			}
		});
	}
	
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		Rect rect = new Rect();
		// /取得整个视图部分,注意，如果你要设置标题样式，这个必须出现在标题样式之后，否则会出错
	     getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
	     top = rect.top; //状态栏的高度,所以rect.height,rect.width分别是系统的高度的宽度
	     System.out.println("top++++++++++"+top);

	}
	
	
	private void showDesk(){
		manager.addView(util, params);
		finish();
	}
	
	/**
	 * 关闭Desktiop
	 */
	private void closeDesk(){
		manager.removeView(util);
		finish();
	}
	private void createWindowManager(){
		//取得系统窗体
		manager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
		//窗体的布局样式
		params = new WindowManager.LayoutParams();
		
		//设置窗体显示类型 ---TYPE_SYSTEM_ALERT(系统提示)
		params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
		
		//设置窗体焦点及触摸
		//FLAG_NOT_FOCUSABLE(不能获得按键输入焦点)
		params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		
		//设置显示的模式
		params.format = PixelFormat.RGBA_8888;
		
		//设置对其的方式
		params.gravity = Gravity.TOP | Gravity.LEFT;
		
		//设置窗体刻度和高度
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
	}

}
