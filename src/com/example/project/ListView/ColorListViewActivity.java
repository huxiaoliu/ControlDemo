package com.example.project.ListView;

import com.example.ch05project.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

/**
 * 改变ListView的背景色可以使用ListView标签的android:listSelector属性
 * 也可以使用ListView.setSelector方法。
 * */
public class ColorListViewActivity extends Activity implements OnClickListener {

	private Drawable defaultSelector;
	private ListView listView;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ColorListViewRbDefault:
			listView.setSelector(defaultSelector);
			break;

		case R.id.ColorListViewRbGreen:
			listView.setSelector(R.drawable.green);
			break;
			
		case R.id.ColorListViewRbSpectrum:
			listView.setSelector(R.drawable.spectrum);
			break;
		default:
			break;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colorlistview);
		String[] data = new String[] { "英俊", "帅气", "优雅", "正气" };

		ArrayAdapter<String> aaAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data);
		listView = (ListView) findViewById(R.id.ColorListView);
		listView.setAdapter(aaAdapter);
		defaultSelector = listView.getSelector();
		
		RadioButton rbDefault = (RadioButton) findViewById(R.id.ColorListViewRbDefault);
		rbDefault.setNextFocusDownId(R.id.ColorListView);
		rbDefault.setOnClickListener(this);
		RadioButton rbGreen = (RadioButton) findViewById(R.id.ColorListViewRbGreen);
		rbGreen.setNextFocusDownId(R.id.ColorListView);
		rbGreen.setOnClickListener(this);
		RadioButton rbSpectrum = (RadioButton) findViewById(R.id.ColorListViewRbSpectrum);
		rbSpectrum.setNextFocusDownId(R.id.ColorListView);
		rbSpectrum.setOnClickListener(this);

		
	}

}
