package com.saic.sweep;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.saic.sweep.bane.User;

public class BaseActivity extends Activity {
	// 所有activity
	private static ArrayList<Activity> activitys = new ArrayList<Activity>();
	public static User user;
	public Context context;

	public String site_no;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置findbyid 在属性上设置就行呢
		ViewUtils.inject(this);
		context = this;
		// 都设置为坚屏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// 加入
		activitys.add(this);
	}

	// 提示
	public void makeText(Context context, String text) {
		Toast.makeText(context, text, 1).show();
	}

	protected void onDestroy() {
		super.onDestroy();
		// 删除
		activitys.remove(this);
	}

	public void endapp(View btn) {
		int j = activitys.size();
		for (int i = 0; i < j; i++) {
			activitys.get(i).finish();
		}
	}
}
