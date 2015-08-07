package com.example.project.Button;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.widget.Button;

import com.example.ch05project.R;

public class ImageTextButtonActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_text_button);
		Button button = (Button) findViewById(R.id.imagetext_button);
		//处理文字左侧的图像
		SpannableString spannableStringLeft = new SpannableString("left");
		Bitmap bitmapLeft = BitmapFactory.decodeResource(getResources(), R.drawable.image_left);
		ImageSpan imageSpanLeft = new ImageSpan(bitmapLeft,DynamicDrawableSpan.ALIGN_BOTTOM);
		//将left替换成左侧图像
		spannableStringLeft.setSpan(imageSpanLeft, 0, 4,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//处理文字右侧的图像
		SpannableString spannableStringRight = new SpannableString("right");
		Bitmap bitmapRight = BitmapFactory.decodeResource(getResources(),
				R.drawable.image_right);
		ImageSpan imageSpanRight = new ImageSpan(bitmapRight);
		//将right替换成ImageSpan对象
		spannableStringRight.setSpan(imageSpanRight, 0, 5,
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//插入文字左侧的图像
		button.append(spannableStringLeft);
		//插入文字
		button.append("我的按钮");
		//插入文字右侧的图像
		button.append(spannableStringRight);
	}
	
}
