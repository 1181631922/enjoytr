package cn.edu.sjzc.fanyafeng.uiFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import cn.edu.sjzc.fanyafeng.R;
import cn.edu.sjzc.fanyafeng.adapter.FindProjectAdapter;
import cn.edu.sjzc.fanyafeng.bean.FindProjectBean;
import cn.edu.sjzc.fanyafeng.uiActivity.FindMoneyInfoActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.FindProjectInfoActivity;

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
	private ListView pro_listview;
	private FindProjectAdapter findProjectAdapter;
	private List<FindProjectBean> findProjectBeans;
	private List<Map<String, Object>> findProjectList = new ArrayList<Map<String, Object>>();
	private String ptitle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		layoutView = inflater.inflate(R.layout.fragment_findproject, null);

		return layoutView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		initView();

		init(getIndex());

	}

	public void initView() {
		// TextView tv = (TextView) layoutView.findViewById(R.id.textView111);
		ListView pro_listview = (ListView) getActivity().findViewById(
				R.id.pro_listview);

	}

	public void init(int i) {

		if (i == 1) {

			initShangHai();

		} else if (i == 2) {

			initQiTa();

		} else {

			initBeiJing();

		}
	}

	public void initShangHai() {

		ListView pro_listview = (ListView) getActivity().findViewById(
				R.id.pro_listview);
		findProjectBeans = new ArrayList<FindProjectBean>();
		FindProjectBean[] FindProjectArray = new FindProjectBean[] {
				new FindProjectBean("上海项目名称1"),
				new FindProjectBean("上海项目名称12"),
				new FindProjectBean("上海项目名称13"),
				new FindProjectBean("上海项目名称14"),
				new FindProjectBean("上海项目名称15"),
				new FindProjectBean("上海项目名称16"),
				new FindProjectBean("上海项目名称17"),
				new FindProjectBean("上海项目名称18"),
				new FindProjectBean("上海项目名称19"),
				new FindProjectBean("上海项目名称10"),
				new FindProjectBean("上海项目名称11"),
				new FindProjectBean("上海项目名称2"), new FindProjectBean("上海项目名称3"),
				new FindProjectBean("上海项目名称4"), new FindProjectBean("上海项目名称5"),
				new FindProjectBean("上海项目名称6"), new FindProjectBean("上海项目名称7"),
				new FindProjectBean("上海项目名称8"), new FindProjectBean("上海项目名称9") };

		for (int i = 0; i < FindProjectArray.length; i++) {
			FindProjectBean findProjectBeans = new FindProjectBean(ptitle);

			String ptitle = FindProjectArray[i].getFindProjectTitle();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("p_title", ptitle);

			findProjectList.add(map);
		}

		Arrays.sort(FindProjectArray);

		findProjectBeans = Arrays.asList(FindProjectArray);

		findProjectAdapter = new FindProjectAdapter(getActivity(),
				findProjectBeans);

		pro_listview.setAdapter(findProjectAdapter);

		pro_listview.setOnItemClickListener(new proInfoOnItemClickListener());

	}

	public void initBeiJing() {

		ListView pro_listview = (ListView) getActivity().findViewById(
				R.id.pro_listview);
		findProjectBeans = new ArrayList<FindProjectBean>();
		FindProjectBean[] FindProjectArray = new FindProjectBean[] {
				new FindProjectBean("北京项目名称1"),
				new FindProjectBean("北京项目名称12"),
				new FindProjectBean("北京项目名称13"),
				new FindProjectBean("北京项目名称14"),
				new FindProjectBean("北京项目名称15"),
				new FindProjectBean("北京项目名称16"),
				new FindProjectBean("北京项目名称17"),
				new FindProjectBean("北京项目名称18"),
				new FindProjectBean("北京项目名称19"),
				new FindProjectBean("北京项目名称10"),
				new FindProjectBean("北京项目名称11"),
				new FindProjectBean("北京项目名称2"), new FindProjectBean("北京项目名称3"),
				new FindProjectBean("北京项目名称4"), new FindProjectBean("北京项目名称5"),
				new FindProjectBean("北京项目名称6"), new FindProjectBean("北京项目名称7"),
				new FindProjectBean("北京项目名称8"), new FindProjectBean("北京项目名称9") };

		for (int i = 0; i < FindProjectArray.length; i++) {
			FindProjectBean findProjectBeans = new FindProjectBean(ptitle);

			String ptitle = FindProjectArray[i].getFindProjectTitle();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("p_title", ptitle);

			findProjectList.add(map);
		}

		Arrays.sort(FindProjectArray);

		findProjectBeans = Arrays.asList(FindProjectArray);

		findProjectAdapter = new FindProjectAdapter(getActivity(),
				findProjectBeans);

		pro_listview.setAdapter(findProjectAdapter);

		pro_listview.setOnItemClickListener(new proInfoOnItemClickListener());

	}

	public void initQiTa() {

		ListView pro_listview = (ListView) getActivity().findViewById(
				R.id.pro_listview);
		findProjectBeans = new ArrayList<FindProjectBean>();
		FindProjectBean[] FindProjectArray = new FindProjectBean[] {
				new FindProjectBean("其他项目名称1"),
				new FindProjectBean("其他项目名称12"),
				new FindProjectBean("其他项目名称13"),
				new FindProjectBean("其他项目名称14"),
				new FindProjectBean("其他项目名称15"),
				new FindProjectBean("其他项目名称16"),
				new FindProjectBean("其他项目名称17"),
				new FindProjectBean("其他项目名称18"),
				new FindProjectBean("其他项目名称19"),
				new FindProjectBean("其他项目名称10"),
				new FindProjectBean("其他项目名称11"),
				new FindProjectBean("其他项目名称2"), new FindProjectBean("其他项目名称3"),
				new FindProjectBean("其他项目名称4"), new FindProjectBean("其他项目名称5"),
				new FindProjectBean("其他项目名称6"), new FindProjectBean("其他项目名称7"),
				new FindProjectBean("其他项目名称8"), new FindProjectBean("其他项目名称9") };

		for (int i = 0; i < FindProjectArray.length; i++) {
			FindProjectBean findProjectBeans = new FindProjectBean(ptitle);

			String ptitle = FindProjectArray[i].getFindProjectTitle();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("p_title", ptitle);

			findProjectList.add(map);
		}

		Arrays.sort(FindProjectArray);

		findProjectBeans = Arrays.asList(FindProjectArray);

		findProjectAdapter = new FindProjectAdapter(getActivity(),
				findProjectBeans);

		pro_listview.setAdapter(findProjectAdapter);

		pro_listview.setOnItemClickListener(new proInfoOnItemClickListener());

	}

	private class proInfoOnItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub

			Intent it_pro_info = new Intent(getActivity(),
					FindProjectInfoActivity.class);

			for (int i = 0; i <= position; i++) {
				if (position == i) {

					Map map = (Map) findProjectList.get(i);
					String pti = (String) map.get("p_title");

					it_pro_info.putExtra("ptitle_info", pti);

				}
			}

			startActivity(it_pro_info);

		}

	}

}
