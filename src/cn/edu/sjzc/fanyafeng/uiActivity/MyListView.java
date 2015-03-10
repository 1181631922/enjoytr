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

				Toast.makeText(getParent(), "我点击的是" + position,
						Toast.LENGTH_LONG).show();
			}
		});
		setListAdapter(adapter);
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();

		map = new HashMap<String, Object>();
		map.put("title", "雪豹");
		map.put("info", "简介: 　电视剧《雪豹》由“一二八事变”淞沪会战起始，以日本战败投降作结，从时间上贯穿了整个抗日战争时期。");
		map.put("img", R.drawable.xue);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "士兵突击");
		map.put("info",
				"简介: 青山绿水之间，人们日出而作，日落而息。许三多（王宝强饰演）喜欢读书，父亲却要把他送进部队，认为只有这样，这个从小怯懦被他叫做龟儿子的许三多才会有些出息。");
		map.put("img", R.drawable.shi);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "雪豹");
		map.put("info", "简介: 　电视剧《雪豹》由“一二八事变”淞沪会战起始，以日本战败投降作结，从时间上贯穿了整个抗日战争时期。");
		map.put("img", R.drawable.xue);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "士兵突击");
		map.put("info",
				"简介: 青山绿水之间，人们日出而作，日落而息。许三多（王宝强饰演）喜欢读书，父亲却要把他送进部队，认为只有这样，这个从小怯懦被他叫做龟儿子的许三多才会有些出息。");
		map.put("img", R.drawable.shi);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "雪豹");
		map.put("info", "简介: 　电视剧《雪豹》由“一二八事变”淞沪会战起始，以日本战败投降作结，从时间上贯穿了整个抗日战争时期。");
		map.put("img", R.drawable.xue);

		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "士兵突击");
		map.put("info",
				"简介: 青山绿水之间，人们日出而作，日落而息。许三多（王宝强饰演）喜欢读书，父亲却要把他送进部队，认为只有这样，这个从小怯懦被他叫做龟儿子的许三多才会有些出息。");
		map.put("img", R.drawable.shi);

		list.add(map);
		return list;
	}

}
