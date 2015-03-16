package cn.edu.sjzc.fanyafeng.adapter;

import java.util.List;

import cn.edu.sjzc.fanyafeng.R;
import cn.edu.sjzc.fanyafeng.bean.FindMoneyBean;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FindMoneyAdapter extends BaseAdapter {
	
	private Context context;
	
	private List<FindMoneyBean> findMoneyBeans;
	
	

	public FindMoneyAdapter(Context context, List<FindMoneyBean> findMoneyBeans) {
		
		this.context = context;
		this.findMoneyBeans = findMoneyBeans;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return findMoneyBeans.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return findMoneyBeans.get(position);
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
		
		if(view == null){
			
			view = LayoutInflater.from(context).inflate(R.layout.item_listview_findmoney, null);
			
			holder = new ViewHolder();
			view.setTag(holder);
			
			holder.mon_title = (TextView) view.findViewById(R.id.mon_title);
			holder.mon_add = (TextView) view.findViewById(R.id.mon_add);
			
			
			
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.mon_title.setText(findMoneyBeans.get(position).getFindMoneyTitle());
		holder.mon_add.setText(findMoneyBeans.get(position).getFindMoneyAddress());
		//这是关键试试吧
		return view;
	}
	
	static class ViewHolder{
		TextView mon_title;
		TextView mon_add;
	}
//等下
}
