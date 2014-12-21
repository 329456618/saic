package com.saic.sweep.activitys.tehk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.saic.sweep.BaseActivity;
import com.saic.sweep.R;

//盘点2
@ContentView(R.layout.tehk2)
public class TehkActivity2 extends BaseActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// 确定
	@OnClick(R.id.dqpg)
	public void dqpg(View but) {
		Intent intent = new Intent(context, TehkActivity3.class);
		startActivity(intent);
	}

	// 返回
	@OnClick(R.id.rclk)
	public void rclk(View but) {
		finish();
	}
}
