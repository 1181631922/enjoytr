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

public class ChargeActivity extends Activity implements OnClickListener{

	private ImageButton charge_back;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// 生命周期方法
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		super.setContentView(R.layout.activity_personalcenter_charge);
		
		init();

	}



	private void init() {
		// TODO Auto-generated method stub
		ImageButton charge_back = (ImageButton)ChargeActivity.this.findViewById(R.id.charge_back);
		charge_back.setOnClickListener(this);
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.charge_back:
			
			ChargeActivity.this.finish();
			
			break;

		default:
			break;
		}
		
	}
	
	
	
	
	

}