package cn.edu.sjzc.fanyafeng.uiActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sjzc.fanyafeng.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MyListView extends ListActivity {

	// private List<String> data = new ArrayList<String>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getListView().setCacheColorHint(0);
		this.getListView().setBackgroundColor(android.graphics.Color.WHITE);
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.mylist, new String[] { "title", "info", "img" },
				new int[] { R.id.title, R.id.info, R.id.img });

		this.getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					final int position, final long id) {
				// TODO Auto-generated method stub

				Toast.makeText(getParent(), "�ҵ������" + position,
						Toast.LENGTH_LONG).show();
			}
		});
		setListAdapter(adapter);
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();

		map = new HashMap<String, Object>();
		map.put("title", "ѩ��");
		map.put("info", "���: �����Ӿ硶ѩ�����ɡ�һ�����±䡱������ս��ʼ�����ձ�ս��Ͷ�����ᣬ��ʱ���Ϲᴩ����������ս��ʱ�ڡ�");
		map.put("img", R.drawable.xue);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "ʿ��ͻ��");
		map.put("info",
				"���: ��ɽ��ˮ֮�䣬�����ճ������������Ϣ�������ࣨ����ǿ���ݣ�ϲ�����飬����ȴҪ�����ͽ����ӣ���Ϊֻ�������������С��ų������������ӵ�������Ż���Щ��Ϣ��");
		map.put("img", R.drawable.shi);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "ѩ��");
		map.put("info", "���: �����Ӿ硶ѩ�����ɡ�һ�����±䡱������ս��ʼ�����ձ�ս��Ͷ�����ᣬ��ʱ���Ϲᴩ����������ս��ʱ�ڡ�");
		map.put("img", R.drawable.xue);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "ʿ��ͻ��");
		map.put("info",
				"���: ��ɽ��ˮ֮�䣬�����ճ������������Ϣ�������ࣨ����ǿ���ݣ�ϲ�����飬����ȴҪ�����ͽ����ӣ���Ϊֻ�������������С��ų������������ӵ�������Ż���Щ��Ϣ��");
		map.put("img", R.drawable.shi);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "ѩ��");
		map.put("info", "���: �����Ӿ硶ѩ�����ɡ�һ�����±䡱������ս��ʼ�����ձ�ս��Ͷ�����ᣬ��ʱ���Ϲᴩ����������ս��ʱ�ڡ�");
		map.put("img", R.drawable.xue);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "ʿ��ͻ��");
		map.put("info",
				"���: ��ɽ��ˮ֮�䣬�����ճ������������Ϣ�������ࣨ����ǿ���ݣ�ϲ�����飬����ȴҪ�����ͽ����ӣ���Ϊֻ�������������С��ų������������ӵ�������Ż���Щ��Ϣ��");
		map.put("img", R.drawable.shi);

		list.add(map);
		return list;
	}

}
