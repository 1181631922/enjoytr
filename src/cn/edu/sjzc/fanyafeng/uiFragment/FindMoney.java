package cn.edu.sjzc.fanyafeng.uiFragment;

import cn.edu.sjzc.fanyafeng.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FindMoney extends BaseFragment{

	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new FindProject();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		return inflater.inflate(R.layout.fragment_findmoney, null);		
	}	
}