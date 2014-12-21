package com.saic.sweep;

import android.app.Application;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;
import com.saic.sweep.bane.User;
import com.saic.sweep.utils.SPUtils;

public class BaseApplication extends Application {
	public static DbUtils db;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		// log管理
		LogUtils.customTagPrefix = "leshifu";
		LogUtils.allowI = true;
		db = DbUtils.create(this, "saic.db");
		// 得到SPUtils
		SPUtils.setSP(this);
		// 加入管理员账号
		if (SPUtils.isUser()) {
			// 删除表
			try {
				db.dropTable(User.class);
			} catch (DbException e) {
				e.printStackTrace();
			}

			try {
				User u = new User("1", "1");
				u.setType("1");
				db.save(u);
				SPUtils.setIsUser(false);
			} catch (DbException e) {
				e.printStackTrace();
			}
		}
	}
}
