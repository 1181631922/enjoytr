package cn.edu.sjzc.fanyafeng.uiActivity;

import cn.edu.sjzc.fanyafeng.R;
import android.R.layout;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FindProjectInfoActivity extends Activity implements
		OnClickListener {

	private ImageButton pro_title_back;
	private TextView pro_title;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// 生命周期方法
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		super.setContentView(R.layout.activity_findproject_info);

		init();

		initData();

	}

	private void init() {
		// TODO Auto-generated method stub
		ImageButton projecr_back = (ImageButton) FindProjectInfoActivity.this
				.findViewById(R.id.pro_title_back);
		projecr_back.setOnClickListener(this);

		this.pro_title = (TextView) FindProjectInfoActivity.this
				.findViewById(R.id.pro_title);

	}

	private void initData() {

		Intent it = this.getIntent();

		String pro_title_info = it.getStringExtra("ptitle_info");

		this.pro_title.setText(pro_title_info);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.pro_title_back:
			FindProjectInfoActivity.this.finish();
			break;

		default:
			break;
		}

	}

}