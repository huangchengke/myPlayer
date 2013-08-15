package com.hck.player.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.hck.video.player.R;


/**
 * 
 * @author 老科
 *比较常用的一个类，不多做介绍了
 */
public class MainActivity extends TabActivity implements OnCheckedChangeListener{
	private Button button;
	private TabHost tabHost;
	private TabSpec tabSpec;
	private static final String HOME = "home";
	private static final String HOT = "hot";
	private static final String TJ = "tj";
	private static final String USER = "user";
	private static final String LOCAL = "local";
	private RadioGroup rGroup;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        init();  //初始化view
        setLister(); //绑定事件
	}

	private void init() {
		rGroup = (RadioGroup) findViewById(R.id.RadioGroup);
		tabHost = this.getTabHost();
		tabSpec = tabHost.newTabSpec(HOT).setIndicator(HOT)
				.setContent(new Intent(this, HotActivity.class));   //进入会首先显示这个activity，展示热门视频的activity
		tabHost.addTab(tabSpec);
		tabSpec = tabHost.newTabSpec(TJ).setIndicator(TJ)  
				.setContent(new Intent(this, TuiJianActivity.class));  //展示推荐视频的activity
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec(HOME).setIndicator(HOME)
				.setContent(new Intent(this, HomeActivity.class));  //展示全部视频的activity，名字乱起的，大家不要介意
		tabHost.addTab(tabSpec);
		tabSpec = tabHost.newTabSpec(LOCAL).setIndicator(LOCAL)
				.setContent(new Intent(this, LocalActivity.class));  //本地视频activity
		tabHost.addTab(tabSpec);
		tabSpec = tabHost.newTabSpec(USER).setIndicator(USER)
				.setContent(new Intent(this, DownActivity.class));  //广告activity
		tabHost.addTab(tabSpec);
	}

	private void setLister() {
		rGroup.setOnCheckedChangeListener(this);
	}
//用RadioGroup代替tabSpec，作为切换视图用
	public void onCheckedChanged(RadioGroup group, int checkedId) { //点击下面5个button，触发这里的事件
		switch (checkedId) {
		case R.id.hot_id:
			tabHost.setCurrentTab(0);
			break;
		case R.id.tuijian_id:
			tabHost.setCurrentTab(1);
			break;
		case R.id.home_id:
			tabHost.setCurrentTab(2);
			break;
		case R.id.local_id:
			tabHost.setCurrentTab(3);
			break;
		case R.id.user_id:
			tabHost.setCurrentTab(4);
			break;

		}
	}
	
	

}
