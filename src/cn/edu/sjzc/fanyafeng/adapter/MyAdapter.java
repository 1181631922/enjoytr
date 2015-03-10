package cn.edu.sjzc.fanyafeng.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sjzc.fanyafeng.R;
import cn.edu.sjzc.fanyafeng.uiFragment.MyCollege;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<Map<String, Object>> mData;

	public MyAdapter(Context context) {
		mData = getData();
		this.mInflater = LayoutInflater.from(context);
	}

	public final class ViewHolder {
		public ImageView img;
		public TextView mycollege_title;
		public TextView info;
		public Button viewBut;
	}

	private List<Map<String, Object>> getData() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "G1");
		map.put("info", "google 1");
		map.put("img", R.drawable.a);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G2");
		map.put("info", "google 2");
		map.put("img", R.drawable.b);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "G3");
		map.put("info", "google 3");
		map.put("img", R.drawable.c);
		list.add(map);

		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		if (convertView == null) {

			holder = new ViewHolder();

			convertView = mInflater.inflate(R.layout.fragment_mycollege, null);
//			holder.img = (ImageView) convertView.findViewById(R.id.img);
			holder.mycollege_title = (TextView) convertView
					.findViewById(R.id.title);
//			holder.info = (TextView) convertView.findViewById(R.id.info);
//			holder.viewBut = (Button) convertView.findViewById(R.id.view_btn);
			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();
		}

		holder.img.setBackgroundResource((Integer) mData.get(position).get(
				"img"));
		holder.mycollege_title.setText((String) mData.get(position)
				.get("title"));
		holder.info.setText((String) mData.get(position).get("info"));

		holder.viewBut.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new MyCollege().onCreateDialog();
			}
		});

		return convertView;
	}

}
