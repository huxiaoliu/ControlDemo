package com.example.project.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.example.ch05project.R;

/**
 * 下拉列表控件
 * */
public class SpinnerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_main);
		// 开始创建第一个Spinner对象
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		String[] mobilOS = new String[] { "Android", "IPhone", "Symbian",
				"Meego", "Window Phone7" };
		ArrayAdapter<String> aaAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mobilOS);
		// 为第一个Spinner设置Adapter对象
		spinner1.setAdapter(aaAdapter);
		// 开始创建第二个Spinner对象
		Spinner spinne2 = (Spinner) findViewById(R.id.spinner2);

		// 第二个Spinner中的数据是一个Map对象的集合
		final List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
		Map<String, Object> item1 = new HashMap<String, Object>();
		item1.put("ivLogo", R.drawable.calendar);
		item1.put("tvApplicationName", "多功能日历");
		Map<String, Object> item2 = new HashMap<String, Object>();
		item2.put("ivLogo", R.drawable.eoemarket);
		item2.put("tvApplicationName", "eoeMarket客户端");
		items.add(item1);
		items.add(item2);
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, items,
				R.layout.spinner_item, new String[] { "ivLogo",
						"tvApplicationName" }, new int[] { R.id.spinnerLvLogo,
						R.id.spinnerTvApplicationName });
		//为第二个Spinner设置Adapter对象
		spinne2.setAdapter(simpleAdapter);
		//设置第二个Spinner的列表选择事件，当选中某个列表项时，会在Activity的标题栏显示当前列表项的文本内容
		spinne2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				setTitle(items.get(position).get("tvApplicationName").toString());
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		
		
		});
		
	}

}
