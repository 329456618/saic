package com.saic.sweep.activitys;

import java.util.Date;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.saic.sweep.BaseActivity;
import com.saic.sweep.R;
import com.saic.sweep.bane.UserDao;

@ContentView(R.layout.login)
public class LoginActivity extends BaseActivity {
	@ViewInject(R.id.versionName)
	private TextView versionName;
	@ViewInject(R.id.timer)
	private TextView timer;
	@ViewInject(R.id.name)
	private EditText name;
	@ViewInject(R.id.paw)
	private EditText paw;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		user = null;
		init();
	}

	private void init() {
		java.text.DateFormat format1 = new java.text.SimpleDateFormat(
				"yyyy-MM-dd  hh:mm:ss");
		timer.setText(format1.format(new Date()));
		// app信息
		try {
			PackageInfo pkg;
			pkg = getPackageManager().getPackageInfo(
					getApplicationContext().getPackageName(), 0);
			// String appName =
			// pkg.applicationInfo.loadLabel(getPackageManager())
			// .toString();
			// int versionCode = pkg.versionCode;
			String name = pkg.versionName;
			versionName.setText("V " + name);
		} catch (Exception e) {
		}
	}

	// 登录
	@OnClick(R.id.login)
	public void login(View btn) {
		String n = name.getText().toString();
		String p = paw.getText().toString();
		user = UserDao.login(n, p);
		if (user == null) {
			makeText(context, "登录失败.查看用户名或密码...");
		} else {
			Intent intent = new Intent(context, MainActivity.class);
			startActivity(intent);
			finish();
		}
	}

	// 退出
	@OnClick(R.id.endapp)
	public void endapp(View btn) {
		super.endapp(btn);
	}
}
