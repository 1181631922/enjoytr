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

public class FindMoneyInfoActivity extends Activity implements OnClickListener {

	private ImageButton mon_title_back;

	private TextView mon_title, mon_address;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// 生命周期方法
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		super.setContentView(R.layout.activity_findmoney_info);

		init();

		initData();
	}

	private void init() {
		// TODO Auto-generated method stub

		ImageButton changepwd_back = (ImageButton) FindMoneyInfoActivity.this
				.findViewById(R.id.mon_title_back);
		changepwd_back.setOnClickListener(this);

		this.mon_title = (TextView) FindMoneyInfoActivity.this
				.findViewById(R.id.mon_title);

		this.mon_address = (TextView) FindMoneyInfoActivity.this
				.findViewById(R.id.mon_address);

	}

	private void initData() {
		Intent it = this.getIntent();

		String moninfo_title = it.getStringExtra("title_info");
		String moninfo_add = it.getStringExtra("address_info");

		this.mon_title.setText(moninfo_title);
		this.mon_address.setText(moninfo_add);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.mon_title_back:
			FindMoneyInfoActivity.this.finish();
			break;

		default:
			break;
		}

	}

}