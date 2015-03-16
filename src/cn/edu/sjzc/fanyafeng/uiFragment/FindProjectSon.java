package cn.edu.sjzc.fanyafeng.uiFragment;

import cn.edu.sjzc.fanyafeng.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FindProjectSon extends BaseFragment {

	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new FindProjectSon();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}

	private View layoutView;
	private FragmentTabHost mTabHost;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		layoutView = inflater.inflate(R.layout.fragment_findproject, null);

		TextView tv = (TextView) layoutView.findViewById(R.id.textView111);
//		 tv.setText(getIndex() + "");
//		String st = getIndex() + "";
		// Log.e("标题栏为多少", getIndex() + "");
		init(getIndex());
		return layoutView;
	}

	public void init(int i) {

		if (i == 1) {
			TextView tv = (TextView) layoutView.findViewById(R.id.textView111);
			tv.setText("上海" + "");
			
		} else if (i == 2) {
			TextView tv = (TextView) layoutView.findViewById(R.id.textView111);
			tv.setText("其他" + "");
			
		} else {

			TextView tv = (TextView) layoutView.findViewById(R.id.textView111);
			tv.setText("北京" + "");

			

		}
	}

}
