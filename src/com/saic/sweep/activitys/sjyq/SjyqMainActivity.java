package com.saic.sweep.activitys.sjyq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.saic.sweep.BaseActivity;
import com.saic.sweep.R;

@ContentView(R.layout.sjyqmain)
public class SjyqMainActivity extends BaseActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// android:text="查已盘记录" />
	@OnClick(R.id.sntyv)
	public void sntyv(View btu) {
		Intent intent = new Intent(context, SntyvActivity.class);
		startActivity(intent);
	}

	// android:text="查未盘记录" />
	@OnClick(R.id.sityv)
	public void sityv(View btu) {
		Toast.makeText(this, "查未盘记录", Toast.LENGTH_LONG).show();
	}

	// android:text="按VIN查询" />
	@OnClick(R.id.rvinsy)
	public void rvinsy(View btu) {
		Toast.makeText(this, "按VIN查询", Toast.LENGTH_LONG).show();
	}

	// android:text="返回" />
	@OnClick(R.id.rclk)
	public void rclk(View btu) {
		finish();
	}
}
