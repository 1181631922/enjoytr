package cn.edu.sjzc.fanyafeng.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.edu.sjzc.fanyafeng.R;
import cn.edu.sjzc.fanyafeng.bean.FindProjectBean;

public class FindProjectAdapter extends BaseAdapter {

	private Context context;

	private List<FindProjectBean> findProjectBeans;

	public FindProjectAdapter(Context context,
			List<FindProjectBean> findProjectBeans) {

		this.context = context;
		this.findProjectBeans = findProjectBeans;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return findProjectBeans.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return findProjectBeans.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = convertView;
		ViewHolder holder = null;

		if (view == null) {

			view = LayoutInflater.from(context).inflate(
					R.layout.item_listview_findproject, null);

			holder = new ViewHolder();
			view.setTag(holder);

			holder.pro_title = (TextView) view.findViewById(R.id.pro_title);

		} else {

			holder = (ViewHolder) convertView.getTag();

		}

		holder.pro_title.setText(findProjectBeans.get(position)
				.getFindProjectTitle());

		return view;
	}

	static class ViewHolder {
		TextView pro_title;
	}

}
