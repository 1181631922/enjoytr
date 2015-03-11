package cn.edu.sjzc.fanyafeng.uiFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sjzc.fanyafeng.R;
import cn.edu.sjzc.fanyafeng.adapter.FindMoneyAdapter;
import cn.edu.sjzc.fanyafeng.bean.FindMoneyBean;
import cn.edu.sjzc.fanyafeng.uiActivity.FindMoneyInfoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FindMoney extends BaseFragment {

	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new FindProject();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}

	private ListView mon_listview;
	private FindMoneyAdapter findMoneyAdapter;
	private List<FindMoneyBean> findMoneyBeans;
	private List<Map<String, Object>> findMoneyList = new ArrayList<Map<String, Object>>();
	private String mAddress, mTitle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_findmoney, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		init();
	}

	private void init() {

		mon_listview = (ListView) getActivity().findViewById(R.id.mon_listview);

		findMoneyBeans = new ArrayList<FindMoneyBean>();

		FindMoneyBean[] findMoneyArray = new FindMoneyBean[] {
				new FindMoneyBean("�п���ʵ1", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ2", "�ӱ�ʡ�������п���ʵ2"),
				new FindMoneyBean("�п���ʵ3", "�ӱ�ʡ�������п���ʵ3"),
				new FindMoneyBean("�п���ʵ4", "�ӱ�ʡ�������п���ʵ4"),
				new FindMoneyBean("�п���ʵ5", "�ӱ�ʡ�������п���ʵ5"),
				new FindMoneyBean("�п���ʵ6", "�ӱ�ʡ�������п���ʵ6"),
				new FindMoneyBean("�п���ʵ7", "�ӱ�ʡ�������п���ʵ7"),
				new FindMoneyBean("�п���ʵ8", "�ӱ�ʡ�������п���ʵ8"),
				new FindMoneyBean("�п���ʵ9", "�ӱ�ʡ�������п���ʵ9"),
				new FindMoneyBean("�п���ʵ10", "�ӱ�ʡ�������п���ʵ10"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("�п���ʵ", "�ӱ�ʡ�������п���ʵ"),
				new FindMoneyBean("����ʵ", "�ӱ�ʡ�����п���ʵ") };

		for (int i = 0; i < findMoneyArray.length; i++) {

			FindMoneyBean findMoneyBeans = new FindMoneyBean(mTitle, mAddress);

			String mtitle = findMoneyArray[i].getFindMoneyTitle();
			String madd = findMoneyArray[i].getFindMoneyAddress();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("m_title", mtitle);
			map.put("m_address", madd);

			findMoneyList.add(map);

		}

		Arrays.sort(findMoneyArray);

		findMoneyBeans = Arrays.asList(findMoneyArray);

		findMoneyAdapter = new FindMoneyAdapter(getActivity(), findMoneyBeans);

		mon_listview.setAdapter(findMoneyAdapter);

		mon_listview.setOnItemClickListener(new monInfoOnItemClickListener());
	}

	protected class monInfoOnItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Intent it_mon_info = new Intent(getActivity(),
					FindMoneyInfoActivity.class);

			for (int i = 0; i <= position; i++) {
				if (position == i) {

					Map map = (Map) findMoneyList.get(i);
					String mti = (String) map.get("m_title");
					String mad = (String) map.get("m_address");
					it_mon_info.putExtra("title_info", mti);
					it_mon_info.putExtra("address_info", mad);
				}
			}

			startActivity(it_mon_info);

		}

	}

}