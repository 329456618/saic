package com.saic.sweep.activitys;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.saic.sweep.BaseActivity;
import com.saic.sweep.R;
import com.saic.sweep.bane.User;
import com.saic.sweep.bane.UserDao;

/**
 * 设置
 * 
 * @author Administrator
 * 
 */
@ContentView(R.layout.ymlf)
public class YmlfActivity extends BaseActivity {
	@ViewInject(R.id.name)
	private EditText name;
	@ViewInject(R.id.paw)
	private EditText paw;

	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		super.onChildTitleChanged(childActivity, title);
	}

	// 确定
	@OnClick(R.id.dqpg)
	public void dqpg(View but) {
		String n = name.getText().toString();
		String p = paw.getText().toString();
		if(isStringNull(n)){
			makeText(context, "用户名为空...");
			return;
		}
		if(isStringNull(p)){
			makeText(context, "密码名为空...");
			return;
		}
		User user = new User(n, p);
		if (UserDao.adduser(user)) {
			makeText(context, "增加成功...");
			name.setText("");
			paw.setText("");
		} else {
			makeText(context, "增加失败...");
		}
	}

	// 是否为空，不能用
	public static boolean isStringNull(String context) {
		if (context == null) {
			return true;
		}
		context = context.replace(" ", "");
		if ("".equals(context)) {
			return true;
		}
		// if (context.indexOf("请点击输入") == 0) {
		// return true;
		// }
		return false;
	}

	// 返回
	@OnClick(R.id.rclk)
	public void rclk(View but) {
		finish();
	}
}
