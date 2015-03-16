package cn.edu.sjzc.fanyafeng.util;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.Application;

public class FinishApplication extends Application {
	private List<Activity> finishActivity = new ArrayList<Activity>();
	private static FinishApplication instance;

	private FinishApplication() {
	}

	/**
	 * 单例模式获取唯一的FinishApplication实例
	 * 
	 * @return
	 */
	public static FinishApplication getInstantce() {
		if (instance == null) {
			instance = new FinishApplication();
		}
		return instance;
	}

	// 添加activity到list中
	public void addActivity(Activity activity) {
		finishActivity.add(activity);
	}

	/**
	 * 循环遍历所有的activity并且finish掉
	 */
	public void exit() {
		for (Activity activity : finishActivity) {
			activity.finish();
		}
		System.exit(0);

	}


}
