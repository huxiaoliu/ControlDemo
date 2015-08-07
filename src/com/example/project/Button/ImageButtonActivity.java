package com.example.project.Button;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * 图像按钮控件，如果想修改ImageButton的图像，可以使用ImageButton类的setImageResource
 * 或其他类似的方法
 * 
 * 注意：ImageButton并不是TextView的子类，而是ImageView的子类，因此并没有android：text属性
 * 如果要在ImageButton上输出文字，可以自定义一个控件，并在onDraw方法中将文字画在ImageButton上
 * 
 * */

public class ImageButtonActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagebutton);
	
	}
	
}
