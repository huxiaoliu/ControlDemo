package com.example.project.TextView;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 四种有关TextView设置行间距的方式
 * 
 * */


public class LineSpaceTextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linespace_textview);
		
		TextView textView = (TextView) findViewById(R.id.textview_linespace);
		//textView.setLineSpacing(50,1.2f);第一个参数是精确值，后一个是倍数。
		textView.setLineSpacing(50, 1.2f);
	}
	
}
