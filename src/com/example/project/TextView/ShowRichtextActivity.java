package com.example.project.TextView;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;


/**
 * 显示富文本（URL,不同大小，字体，颜色，文字的文本）
 * */
public class ShowRichtextActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_richtext);
		
		//从布局文件中转载并创建两个TextView文件
		TextView textView1 = (TextView) findViewById(R.id.textview1);
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		
		//设置第一个TextView要显示的文本(带预定义标签的字符串)
		String html = "<font color='red'>I love Android<'/font'><br>";
		html+="<font color='#0000ff'><big><i>I love Android</i></big><'/font'><p>";
		html+="<font color='#@"+ android.R.color.white +"'><tt><b><big><u>I love" +
				" Android</u></big><b></tt></font><p>";
		html +="<big><a href='https://www.baidu.com'>我的网站:baidu.com</a></big>";
		
		//将预定义标签的字符串显示成CharSequence形式
		CharSequence charSequence = Html.fromHtml(html);
		
		//为第一个TextView设置要显示的文本
		textView1.setText(charSequence);
		
		//下面的语句非常重要，如果没有该语句，无法单击链接调用浏览器显示网页
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
		
		//设置第二个TextView要显示的文本
		
		String text = "我的URL：://51happyblog.com\n";
		text += "我的Email:abcd@126.com\n";
		text +="我的电话： +86 024-12345678";
		textView2.setText(text);
		textView2.setMovementMethod(LinkMovementMethod.getInstance());
	}

}
