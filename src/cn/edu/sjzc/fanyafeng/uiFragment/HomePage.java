package cn.edu.sjzc.fanyafeng.uiFragment;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.edu.sjzc.fanyafeng.R;
import cn.edu.sjzc.fanyafeng.uiActivity.LoginActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends BaseFragment {

	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new FindProject();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}
	
	int[] images = null;// ͼƬ��ԴID
	String[] titles = null;// ����

	ArrayList<ImageView> imageSource = null;// ͼƬ��Դ
	ArrayList<View> dots = null;// ��
	TextView title = null;
	ViewPager viewPager;// ������ʾͼƬ
	MyPagerAdapter adapter;// viewPager��������
	private int currPage = 0;// ��ǰ��ʾ��ҳ
	private int oldPage = 0;// ��һ����ʾ��ҳ
	View dot1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		LayoutInflater myInflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = myInflater.inflate(R.layout.fragment_homepage, container, false);

		return view;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();
		View dot1 = (View) getActivity().findViewById(R.id.dot1);
		dot1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(getActivity(), LoginActivity.class);
				HomePage.this.startActivity(it);
			}
		});

	}

	public void init() {
		images = new int[] { R.drawable.a, R.drawable.b, R.drawable.c,
				R.drawable.a, R.drawable.b };
		titles = new String[] { "", "", "", "", "" };
		// ��Ҫ��ʾ��ͼƬ�ŵ�list������
		imageSource = new ArrayList<ImageView>();
		for (int i = 0; i < images.length; i++) {
			ImageView image = new ImageView(getActivity());
			image.setBackgroundResource(images[i]);
			imageSource.add(image);

			final int j = i;
			image.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {

					if (j == 0) {
						Toast.makeText(getActivity(), "��һ��ͼƬ��Ư����", 1000).show();
					}
					if (j == 1) {
						Toast.makeText(getActivity(), "�ڶ���ͼƬ�����԰�", 1000).show();
					}
					if (j == 2) {
						Toast.makeText(getActivity(), "������ͼƬ���ù�ȥ", 1000).show();
					}
					if (j == 3) {
						Toast.makeText(getActivity(), "�͵�һ��ͼƬһ��", 1000).show();
					}
					if (j == 4) {
						Toast.makeText(getActivity(), "�͵ڶ���ͼƬһ��", 1000).show();
					}

					// Toast.makeText(getActivity(), "���ǵ�" + j + "��ͼƬ",
					// 1000).show();

				}
			});

		}

		// ��ȡ��ʾ�ĵ㣨�������·��ĵ㣬��ʾ��ǰ�ǵڼ��ţ�
		dots = new ArrayList<View>();
		dots.add(getActivity().findViewById(R.id.dot1));
		dots.add(getActivity().findViewById(R.id.dot2));
		dots.add(getActivity().findViewById(R.id.dot3));
		dots.add(getActivity().findViewById(R.id.dot4));
		dots.add(getActivity().findViewById(R.id.dot5));

		// ͼƬ�ı���
		title = (TextView) getActivity().findViewById(R.id.title);
		title.setText(titles[0]);

		// ��ʾͼƬ��VIew
		viewPager = (ViewPager) getActivity().findViewById(R.id.vp);
		// ΪviewPager����������
		adapter = new MyPagerAdapter();
		viewPager.setAdapter(adapter);
		// ΪviewPager��Ӽ��������ü��������ڵ�ͼƬ�任ʱ������͵�Ҳ���ű仯
		MyPageChangeListener listener = new MyPageChangeListener();
		viewPager.setOnPageChangeListener(listener);

		// ������ʱ����ÿ��2���Զ�������һ�ţ�ͨ�������߳�ʵ�֣�����Timer���ƣ���ʹ��Timer���棩
		ScheduledExecutorService scheduled = Executors
				.newSingleThreadScheduledExecutor();
		// ����һ���̣߳����߳�����֪ͨUI�̱߳任ͼƬ
		ViewPagerTask pagerTask = new ViewPagerTask();
		scheduled.scheduleAtFixedRate(pagerTask, 6, 6, TimeUnit.SECONDS);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
	}

	// ViewPagerÿ�ν�����������ͼƬ�������ڷ�ֹ�����ڴ������
	private class MyPagerAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			System.out.println("getCount");
			return images.length;
		}

		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			View view = dots.get(position);
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent it = new Intent(getActivity(), LoginActivity.class);
					HomePage.this.startActivity(it);
				}
			});
			ViewPager viewPager = (ViewPager) container;
			viewPager.addView(view);
			return dots.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// �жϽ�Ҫ��ʾ��ͼƬ�Ƿ��������ʾ��ͼƬ��ͬһ��
			// arg0Ϊ��ǰ��ʾ��ͼƬ��arg1�ǽ�Ҫ��ʾ��ͼƬ
			System.out.println("isViewFromObject");
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			System.out.println("destroyItem==" + position);
			// ���ٸ�ͼƬ
			container.removeView(imageSource.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// ��ʼ����Ҫ��ʾ��ͼƬ������ͼƬ���뵽container�У���viewPager��
			container.addView(imageSource.get(position));
			System.out.println("instantiateItem===" + position + "===="
					+ container.getChildCount());
			return imageSource.get(position);
		}
	}

	// ����ViewPager�ı仯
	private class MyPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(final int position) {
			// ����ʾ��ͼƬ�����仯֮��
			// ���ñ���
			title.setText(titles[position]);
			// �ı���״̬
			dots.get(position).setBackgroundResource(R.drawable.dot_focused);
			dots.get(oldPage).setBackgroundResource(R.drawable.dot_normal);
			// ��¼��ҳ��

			oldPage = position;
			currPage = position;
		}
	}

	private class ViewPagerTask implements Runnable {
		@Override
		public void run() {
			// �ı䵱ǰҳ���ֵ
			currPage = (currPage + 1) % images.length;
			// ������Ϣ��UI�߳�
			handler.sendEmptyMessage(0);
		}
	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			// ���յ���Ϣ�󣬸���ҳ��
			viewPager.setCurrentItem(currPage);
		};
	};
}
