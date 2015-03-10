package cn.edu.sjzc.fanyafeng.uiFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sjzc.fanyafeng.R;
import cn.edu.sjzc.fanyafeng.adapter.DemoAdapter;
import cn.edu.sjzc.fanyafeng.adapter.DemoAdapter.ViewHolder;
import cn.edu.sjzc.fanyafeng.adapter.MyAdapter;
import cn.edu.sjzc.fanyafeng.bean.MyCollegeBean;
import cn.edu.sjzc.fanyafeng.uiActivity.MyListView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyCollege extends BaseFragment implements View.OnClickListener,
		OnItemClickListener {

	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new FindProject();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}

	/**
	 * 返回按钮
	 */
	private ViewGroup btnCancle = null;

	/**
	 * 确定按钮
	 */
	private ViewGroup btnAdd = null;

	/**
	 * 选择所有
	 */
	private Button btnSelectAll = null;

	/**
	 * 清除所有
	 */
	private Button btnDelete = null;

	/**
	 * ListView列表
	 */
	private ListView lvListView = null;

	/**
	 * 适配对象
	 */
	private DemoAdapter adpAdapter = null;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub

		super.onAttach(activity);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View root = inflater.inflate(R.layout.fragment_mycollege, container, false);

		return root;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// 初始化视图
		initView();

		// 初始化数据
		initData();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	/**
	 * 初始化控件
	 */
	private void initView() {

		ViewGroup btnCancle = (ViewGroup) getView()
				.findViewById(R.id.btnCancle);
		btnCancle.setOnClickListener((OnClickListener) this);

		btnAdd = (ViewGroup) getView().findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener((OnClickListener) this);

		btnDelete = (Button) getView().findViewById(R.id.btnDelete);
		btnDelete.setOnClickListener((OnClickListener) this);

		btnSelectAll = (Button) getView().findViewById(R.id.btnSelectAll);
		btnSelectAll.setOnClickListener((OnClickListener) this);

		lvListView = (ListView) getView().findViewById(R.id.lvListView);
		lvListView.setOnItemClickListener((OnItemClickListener) this);

	}

	/**
	 * 初始化视图
	 */
	private void initData() {

		// 模拟假数据
		List<MyCollegeBean> demoDatas = new ArrayList<MyCollegeBean>();

		demoDatas.add(new MyCollegeBean("张三", true));
		demoDatas.add(new MyCollegeBean("李四", true));
		demoDatas.add(new MyCollegeBean("王五", false));
		demoDatas.add(new MyCollegeBean("赵六", true));

		adpAdapter = new DemoAdapter(getActivity(), demoDatas);

		lvListView.setAdapter(adpAdapter);

	}

	/**
	 * 按钮点击事件
	 */
	@Override
	public void onClick(View v) {

		/*
		 * 当点击返回的时候
		 */
		if (v == btnCancle) {
			// finish();
			onCreateDialog();

		}

		/*
		 * 当点击增加的时候
		 */
		if (v == btnAdd) {

			adpAdapter.add(new MyCollegeBean("赵六", true));

			adpAdapter.notifyDataSetChanged();
		}

		/*
		 * 当点击删除的时候
		 */
		if (v == btnDelete) {

			/*
			 * 删除算法最复杂,拿到checkBox选择寄存map
			 */
			Map<Integer, Boolean> map = adpAdapter.getCheckMap();

			// 获取当前的数据数量
			int count = adpAdapter.getCount();

			// 进行遍历
			for (int i = 0; i < count; i++) {

				// 因为List的特性,删除了2个item,则3变成2,所以这里要进行这样的换算,才能拿到删除后真正的position
				int position = i - (count - adpAdapter.getCount());

				if (map.get(i) != null && map.get(i)) {

					MyCollegeBean bean = (MyCollegeBean) adpAdapter
							.getItem(position);

					if (bean.isCanRemove()) {
						adpAdapter.getCheckMap().remove(i);
						adpAdapter.remove(position);
					} else {
						map.put(position, false);
					}

				}
			}

			adpAdapter.notifyDataSetChanged();

		}

		/*
		 * 当点击全选的时候
		 */
		if (v == btnSelectAll) {

			if (btnSelectAll.getText().toString().trim().equals("全选")) {

				// 所有项目全部选中
				adpAdapter.configCheckMap(true);

				adpAdapter.notifyDataSetChanged();

				btnSelectAll.setText("全不选");
			} else {

				// 所有项目全部不选中
				adpAdapter.configCheckMap(false);

				adpAdapter.notifyDataSetChanged();

				btnSelectAll.setText("全选");
			}

		}
	}

	/**
	 * 当ListView 子项点击的时候
	 */
	@Override
	public void onItemClick(AdapterView<?> listView, View itemLayout,
			int position, long id) {

		if (itemLayout.getTag() instanceof ViewHolder) {

			ViewHolder holder = (ViewHolder) itemLayout.getTag();

			// 会自动出发CheckBox的checked事件
			holder.cbCheck.toggle();

		}

	}

	public Dialog onCreateDialog() {

		return new AlertDialog.Builder(getActivity())
				.setIcon(R.drawable.detail).setTitle("我的listview")
				.setMessage("介绍...")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				}).show();

	}

}