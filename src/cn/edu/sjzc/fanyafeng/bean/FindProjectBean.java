package cn.edu.sjzc.fanyafeng.bean;

public class FindProjectBean implements java.lang.Comparable{

	private String FindProjectTitle;

	public FindProjectBean(String findProjectTitle) {

		FindProjectTitle = findProjectTitle;
	}

	public String getFindProjectTitle() {
		return FindProjectTitle;
	}

	public void setFindProjectTitle(String findProjectTitle) {
		FindProjectTitle = findProjectTitle;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FindProjectBean [FindProjectTitle=" + FindProjectTitle + "]";
	}

	@Override
	public int compareTo(Object another) {
		// TODO Auto-generated method stub
		return 0;
	}

}
