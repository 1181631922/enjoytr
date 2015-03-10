package cn.edu.sjzc.fanyafeng.bean;

public class FindMoneyBean implements java.lang.Comparable {

	private String FindMoneyTitle;
	private String FindMoneyAddress;

	@Override
	public int compareTo(Object another) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FindMoneyBean(String findMoneyTitle, String findMoneyAddress) {
		super();
		FindMoneyTitle = findMoneyTitle;
		FindMoneyAddress = findMoneyAddress;
	}

	public String getFindMoneyTitle() {
		return FindMoneyTitle;
	}

	public void setFindMoneyTitle(String findMoneyTitle) {
		FindMoneyTitle = findMoneyTitle;
	}

	public String getFindMoneyAddress() {
		return FindMoneyAddress;
	}

	public void setFindMoneyAddress(String findMoneyAddress) {
		FindMoneyAddress = findMoneyAddress;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return "FindMoneyBean [FindMoneyTitle=" + FindMoneyTitle
				+ ", FindMoneyAddress=" + FindMoneyAddress + "]";
	}

}
