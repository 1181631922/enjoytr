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
	 * ����ģʽ��ȡΨһ��FinishApplicationʵ��
	 * 
	 * @return
	 */
	public static FinishApplication getInstantce() {
		if (instance == null) {
			instance = new FinishApplication();
		}
		return instance;
	}

	// ���activity��list��
	public void addActivity(Activity activity) {
		finishActivity.add(activity);
	}

	/**
	 * ѭ���������е�activity����finish��
	 */
	public void exit() {
		for (Activity activity : finishActivity) {
			activity.finish();
		}
		System.exit(0);

	}


}
