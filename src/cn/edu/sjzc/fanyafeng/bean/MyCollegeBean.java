package cn.edu.sjzc.fanyafeng.bean;

public class MyCollegeBean {

	private String title;

	
	/**
	 * ��ʶ�Ƿ����ɾ��
	 */
	private boolean canRemove = true;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCanRemove() {
		return canRemove;
	}

	public void setCanRemove(boolean canRemove) {
		this.canRemove = canRemove;
	}

	public MyCollegeBean(String title, boolean canRemove) {
		this.title = title;
		this.canRemove = canRemove;
	}

	public MyCollegeBean() {
	}

}
