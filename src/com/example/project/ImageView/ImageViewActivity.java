package com.example.project.ImageView;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * ImageView控件的基本用法
 * 
 * */

public class ImageViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageview);
		ImageView imageView = (ImageView) findViewById(R.id.imageview_1);
		//设置ImageView控件的宽度和高度,并将获得的值显示在Activity的标题栏上
		imageView.setLayoutParams(new LinearLayout.LayoutParams(200,100));
		setTitle("width" + imageView.getLayoutParams().width +
				"height" + imageView.getLayoutParams().height);
		
		
	}
	
}
