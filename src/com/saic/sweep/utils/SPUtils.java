package com.saic.sweep.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.saic.sweep.bane.User;

public class SPUtils {
	private static SharedPreferences sp;// 都保存在这个sp中
	private static final String ISUSER = "ISUSER";

	/**
	 * 设置sp
	 * 
	 * @param context
	 */
	public static void setSP(Context context) {
		// sp = PreferenceManager.getDefaultSharedPreferences(context);
		sp = context.getSharedPreferences("saic", Context.MODE_PRIVATE);
	}

	public static boolean isUser() {
		return sp.getBoolean(ISUSER, true);
	}

	public static void setIsUser(boolean user) {
		Editor e = sp.edit();
		e.putBoolean(ISUSER, user);
		e.commit();
	}
}
