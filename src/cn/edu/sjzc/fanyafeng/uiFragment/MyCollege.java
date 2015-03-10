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
	 * ���ذ�ť
	 */
	private ViewGroup btnCancle = null;

	/**
	 * ȷ����ť
	 */
	private ViewGroup btnAdd = null;

	/**
	 * ѡ������
	 */
	private Button btnSelectAll = null;

	/**
	 * �������
	 */
	private Button btnDelete = null;

	/**
	 * ListView�б�
	 */
	private ListView lvListView = null;

	/**
	 * �������
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

		// ��ʼ����ͼ
		initView();

		// ��ʼ������
		initData();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	/**
	 * ��ʼ���ؼ�
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
	 * ��ʼ����ͼ
	 */
	private void initData() {

		// ģ�������
		List<MyCollegeBean> demoDatas = new ArrayList<MyCollegeBean>();

		demoDatas.add(new MyCollegeBean("����", true));
		demoDatas.add(new MyCollegeBean("����", true));
		demoDatas.add(new MyCollegeBean("����", false));
		demoDatas.add(new MyCollegeBean("����", true));

		adpAdapter = new DemoAdapter(getActivity(), demoDatas);

		lvListView.setAdapter(adpAdapter);

	}

	/**
	 * ��ť����¼�
	 */
	@Override
	public void onClick(View v) {

		/*
		 * ��������ص�ʱ��
		 */
		if (v == btnCancle) {
			// finish();
			onCreateDialog();

		}

		/*
		 * ��������ӵ�ʱ��
		 */
		if (v == btnAdd) {

			adpAdapter.add(new MyCollegeBean("����", true));

			adpAdapter.notifyDataSetChanged();
		}

		/*
		 * �����ɾ����ʱ��
		 */
		if (v == btnDelete) {

			/*
			 * ɾ���㷨���,�õ�checkBoxѡ��Ĵ�map
			 */
			Map<Integer, Boolean> map = adpAdapter.getCheckMap();

			// ��ȡ��ǰ����������
			int count = adpAdapter.getCount();

			// ���б���
			for (int i = 0; i < count; i++) {

				// ��ΪList������,ɾ����2��item,��3���2,��������Ҫ���������Ļ���,�����õ�ɾ����������position
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
		 * �����ȫѡ��ʱ��
		 */
		if (v == btnSelectAll) {

			if (btnSelectAll.getText().toString().trim().equals("ȫѡ")) {

				// ������Ŀȫ��ѡ��
				adpAdapter.configCheckMap(true);

				adpAdapter.notifyDataSetChanged();

				btnSelectAll.setText("ȫ��ѡ");
			} else {

				// ������Ŀȫ����ѡ��
				adpAdapter.configCheckMap(false);

				adpAdapter.notifyDataSetChanged();

				btnSelectAll.setText("ȫѡ");
			}

		}
	}

	/**
	 * ��ListView ��������ʱ��
	 */
	@Override
	public void onItemClick(AdapterView<?> listView, View itemLayout,
			int position, long id) {

		if (itemLayout.getTag() instanceof ViewHolder) {

			ViewHolder holder = (ViewHolder) itemLayout.getTag();

			// ���Զ�����CheckBox��checked�¼�
			holder.cbCheck.toggle();

		}

	}

	public Dialog onCreateDialog() {

		return new AlertDialog.Builder(getActivity())
				.setIcon(R.drawable.detail).setTitle("�ҵ�listview")
				.setMessage("����...")
				.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				})
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				}).show();

	}

}