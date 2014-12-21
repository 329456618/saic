package com.saic.sweep.activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.saic.sweep.BaseActivity;
import com.saic.sweep.R;
import com.saic.sweep.activitys.sjyq.SjyqMainActivity;
import com.saic.sweep.activitys.tehk.TehkActivity1;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
	@ViewInject(R.id.ymlf)
	private Button ymlf;// 设置

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if ("1".equals(user.getType())) {
			// 管理可以设置
			ymlf.setClickable(true);
		} else {
			// 普通不能设置
			ymlf.setClickable(false);
			ymlf.setTextColor(Color.GRAY);
		}
	}

	// 盘点
	@OnClick(R.id.tehk)
	public void tehk(View btn) {
		Intent intent = new Intent(context, TehkActivity1.class);
		startActivity(intent);
	}

	// 查询
	@OnClick(R.id.sjyq)
	public void sjyq(View btn) {
		Intent intent = new Intent(context, SjyqMainActivity.class);
		startActivity(intent);
	}

	// 设置
	@OnClick(R.id.ymlf)
	public void ymlf(View btn) {
		Intent intent = new Intent(context, YmlfActivity.class);
		startActivity(intent);
	}

	// 清空数据
	@OnClick(R.id.igpwovrn)
	public void igpwovrn(View btn) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// builder.setTitle("更新");
		builder.setMessage("是否要清空数据...");
		// 确定按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				makeToast("确定");
			}
		});

		// 取消按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				makeToast("取消");
			}
		});

		// 显示对话框
		builder.show();
	}

	private void makeToast(String text) {
		Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
	}

	// 返回
	@OnClick(R.id.rclk)
	public void rclk(View btn) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// builder.setTitle("更新");
		builder.setMessage("退出程序...");
		// 确定按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				endapp(null);
			}
		});

		// 取消按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		// 显示对话框
		builder.show();
	}

	// 退出
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			rclk(null);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
