package com.saic.sweep.bane;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;
import com.saic.sweep.BaseApplication;

public class UserDao {
	public static DbUtils db = BaseApplication.db;

	// 登录
	public static User login(String name, String paw) {
		User u = null;
		try {
			u = db.findFirst(Selector.from(User.class).where("name", "=", name)
					.and("paw", "=", paw));
		} catch (DbException e) {
			LogUtils.i("登录。 数据查询错误！！");
			e.printStackTrace();
		}
		return u;
	}

	// 设置用户
	public static boolean adduser(User u) {
		try {
			db.save(u);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
