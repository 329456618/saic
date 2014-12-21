package com.saic.sweep.activitys.tehk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.saic.sweep.BaseActivity;
import com.saic.sweep.R;

//盘点3
@ContentView(R.layout.tehk3)
public class TehkActivity3 extends BaseActivity {
	//s/t/o	odo	sold date	pmt date	pif date	comments

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// 确定
	@OnClick(R.id.dqpg)
	public void dqpg(View but) {
		makeText(context, "确定");
	}

	// 返回
	@OnClick(R.id.rclk)
	public void rclk(View but) {
		finish();
	}
}
