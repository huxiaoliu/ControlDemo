package com.example.project.TextView;

import com.example.ch05project.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

/**
 * 为指定文本添加背景
 * */
public class TextBackgroungActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_background);
		
		TextView textView = (TextView) findViewById(R.id.textView);
		String text = "<没有背景><黄色背景>\n\n<蓝色背景，红色文字>";
		
		// 1:将字符串转换为SnnableString对象或者是SpannableStringBuilder 对象
		SpannableString spannableString = new SpannableString(text);
		
		// 2：确定要设置的子字符串的start和end
		int start = 6;
		int end = 12;
		
		// 3:创建backgroundColorSpan对象
		BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(
				Color.YELLOW);
		// 4:使用setSpan方法将指定子字符串转换成BackgroundColorSpan对象
		spannableString.setSpan(backgroundColorSpan, start, end,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		start = 14;
		ColorSpan colorSpan = new ColorSpan(Color.RED, Color.BLUE);
		spannableString.setSpan(colorSpan, start, text.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		// 5:使用SpannableString对象设置TextView控件
		textView.setText(spannableString);
	}
}
