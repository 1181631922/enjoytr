package cn.edu.sjzc.fanyafeng.uiFragment;

import cn.edu.sjzc.fanyafeng.R;
import cn.edu.sjzc.fanyafeng.uiActivity.CertificationActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.ChangepwdActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.ChargeActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.CollectActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.InformationActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.LoginActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.MessageActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.RelationActivity;
import cn.edu.sjzc.fanyafeng.uiActivity.UpgradeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class PersonalCenter extends BaseFragment implements OnClickListener {

	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new FindProject();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}

	private Button user_but, per_information, per_collect, per_relation,
			per_certification, per_message, per_upgrade, per_charge,
			per_password;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_personalcenter, container,
				false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();

	}

	private void init() {
		Button user_but = (Button) getActivity().findViewById(R.id.user_but);
		user_but.setOnClickListener(this);

		Button per_information = (Button) getActivity().findViewById(
				R.id.per_information);
		per_information.setOnClickListener(this);

		Button per_collect = (Button) getActivity().findViewById(
				R.id.per_collect);
		per_collect.setOnClickListener(this);

		Button per_charge = (Button) getActivity()
				.findViewById(R.id.per_charge);
		per_charge.setOnClickListener(this);

		Button per_password = (Button) getActivity().findViewById(
				R.id.per_password);
		per_password.setOnClickListener(this);

		Button per_relation = (Button) getActivity().findViewById(
				R.id.per_relation);
		per_relation.setOnClickListener(this);

		Button per_certification = (Button) getActivity().findViewById(
				R.id.per_certification);
		per_certification.setOnClickListener(this);

		Button per_message = (Button) getActivity().findViewById(
				R.id.per_message);
		per_message.setOnClickListener(this);

		Button per_upgrade = (Button) getActivity().findViewById(
				R.id.per_upgrade);
		per_upgrade.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.user_but:
			Intent it_login = new Intent(getActivity(), LoginActivity.class);
			PersonalCenter.this.startActivity(it_login);
			break;

		case R.id.per_information:
			Intent it = new Intent(getActivity(), InformationActivity.class);
			PersonalCenter.this.startActivity(it);
			break;

		case R.id.per_relation:
			Intent it_relation = new Intent(getActivity(),
					RelationActivity.class);
			PersonalCenter.this.startActivity(it_relation);
			break;

		case R.id.per_certification:
			Intent it_certification = new Intent(getActivity(),
					CertificationActivity.class);
			PersonalCenter.this.startActivity(it_certification);
			break;

		case R.id.per_message:
			Intent it_message = new Intent(getActivity(), MessageActivity.class);
			PersonalCenter.this.startActivity(it_message);
			break;

		case R.id.per_upgrade:
			Intent it_upgrade = new Intent(getActivity(), UpgradeActivity.class);
			PersonalCenter.this.startActivity(it_upgrade);
			break;

		case R.id.per_collect:
			Intent it_collect = new Intent(getActivity(), CollectActivity.class);
			PersonalCenter.this.startActivity(it_collect);
			break;

		case R.id.per_charge:
			Intent it_charge = new Intent(getActivity(), ChargeActivity.class);
			PersonalCenter.this.startActivity(it_charge);
			break;

		case R.id.per_password:
			Intent it_password = new Intent(getActivity(),
					ChangepwdActivity.class);
			PersonalCenter.this.startActivity(it_password);
			break;

		default:
			break;
		}
	}
}