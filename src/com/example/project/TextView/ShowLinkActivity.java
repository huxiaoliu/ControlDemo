package com.example.project.TextView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.example.ch05project.R;


/**
 * 	单击链接弹出Activity
 * */

public class ShowLinkActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_link_activity);
		
		TextView textView1 = (TextView) findViewById(R.id.textView1);
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		
		String text1 = "显示Activity1";
		String text2 = "显示Activity2";
		
		//将文本转换为SpannableString 对象
		SpannableString spannableString1 = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);
		
		//将text1中的所有文本设置成ClickableSpan对象，并实现Click方法
		spannableString1.setSpan(new ClickableSpan() {
			
			@Override
			public void onClick(View widget) {
				Intent intent = new  Intent(ShowLinkActivity.this,Activity1.class);
				//显示Activity1
				startActivity(intent);
			}
		}, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//将text2中的所有文本设置成ClickableSpan对象，并实现Click方法
		spannableString2.setSpan(new ClickableSpan() {
			//在onClick方法中可以编写单击链接时要执行的操作
			@Override
			public void onClick(View widget) {
				Intent intent = new Intent(ShowLinkActivity.this,Activity2.class);
				startActivity(intent);
			}
		}, 0, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//使用SpannableString对象设置两个TextView对象
		textView1.setText(spannableString1);
		textView2.setText(spannableString2);
		
		//在单击链接时凡是有要执行的方法，都必须设置MovementMethod对象
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
		textView2.setMovementMethod(LinkMovementMethod.getInstance());
		
		
	}
	
	
}
