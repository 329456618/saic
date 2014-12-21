package com.saic.sweep.activitys.tehk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.saic.sweep.BaseActivity;
import com.saic.sweep.R;

//盘点1
@ContentView(R.layout.tehk1)
public class TehkActivity1 extends BaseActivity {
	@ViewInject(R.id.siteNo)
	private EditText siteNo;
	@ViewInject(R.id.name)
	private TextView name;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		name.setText(user.getName());
	}

	// 确定
	@OnClick(R.id.dqpg)
	public void dqpg(View but) {
		site_no = siteNo.getText().toString();
		Intent intent = new Intent(context, TehkActivity2.class);
		startActivity(intent);
	}

	// 返回
	@OnClick(R.id.rclk)
	public void rclk(View but) {
		finish();
	}
}
