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
				new FindProjectBean("�Ϻ���Ŀ����1"),
				new FindProjectBean("�Ϻ���Ŀ����12"),
				new FindProjectBean("�Ϻ���Ŀ����13"),
				new FindProjectBean("�Ϻ���Ŀ����14"),
				new FindProjectBean("�Ϻ���Ŀ����15"),
				new FindProjectBean("�Ϻ���Ŀ����16"),
				new FindProjectBean("�Ϻ���Ŀ����17"),
				new FindProjectBean("�Ϻ���Ŀ����18"),
				new FindProjectBean("�Ϻ���Ŀ����19"),
				new FindProjectBean("�Ϻ���Ŀ����10"),
				new FindProjectBean("�Ϻ���Ŀ����11"),
				new FindProjectBean("�Ϻ���Ŀ����2"), new FindProjectBean("�Ϻ���Ŀ����3"),
				new FindProjectBean("�Ϻ���Ŀ����4"), new FindProjectBean("�Ϻ���Ŀ����5"),
				new FindProjectBean("�Ϻ���Ŀ����6"), new FindProjectBean("�Ϻ���Ŀ����7"),
				new FindProjectBean("�Ϻ���Ŀ����8"), new FindProjectBean("�Ϻ���Ŀ����9") };

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
				new FindProjectBean("������Ŀ����1"),
				new FindProjectBean("������Ŀ����12"),
				new FindProjectBean("������Ŀ����13"),
				new FindProjectBean("������Ŀ����14"),
				new FindProjectBean("������Ŀ����15"),
				new FindProjectBean("������Ŀ����16"),
				new FindProjectBean("������Ŀ����17"),
				new FindProjectBean("������Ŀ����18"),
				new FindProjectBean("������Ŀ����19"),
				new FindProjectBean("������Ŀ����10"),
				new FindProjectBean("������Ŀ����11"),
				new FindProjectBean("������Ŀ����2"), new FindProjectBean("������Ŀ����3"),
				new FindProjectBean("������Ŀ����4"), new FindProjectBean("������Ŀ����5"),
				new FindProjectBean("������Ŀ����6"), new FindProjectBean("������Ŀ����7"),
				new FindProjectBean("������Ŀ����8"), new FindProjectBean("������Ŀ����9") };

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
				new FindProjectBean("������Ŀ����1"),
				new FindProjectBean("������Ŀ����12"),
				new FindProjectBean("������Ŀ����13"),
				new FindProjectBean("������Ŀ����14"),
				new FindProjectBean("������Ŀ����15"),
				new FindProjectBean("������Ŀ����16"),
				new FindProjectBean("������Ŀ����17"),
				new FindProjectBean("������Ŀ����18"),
				new FindProjectBean("������Ŀ����19"),
				new FindProjectBean("������Ŀ����10"),
				new FindProjectBean("������Ŀ����11"),
				new FindProjectBean("������Ŀ����2"), new FindProjectBean("������Ŀ����3"),
				new FindProjectBean("������Ŀ����4"), new FindProjectBean("������Ŀ����5"),
				new FindProjectBean("������Ŀ����6"), new FindProjectBean("������Ŀ����7"),
				new FindProjectBean("������Ŀ����8"), new FindProjectBean("������Ŀ����9") };

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
