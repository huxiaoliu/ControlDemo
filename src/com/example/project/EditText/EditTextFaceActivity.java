package com.example.project.EditText;

import java.lang.reflect.Field;
import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;

import com.example.ch05project.R;

/***
 * 
 * 在EditText中实现图文混排，像QQ一样输入表情
 * */

public class EditTextFaceActivity extends Activity {
	
	private EditText edittext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edittext_face);
		
		edittext = (EditText) findViewById(R.id.face_edittext);
	}
	
	public void onClick_RandomFace(View view){
		int randomId = 1 + new Random().nextInt(9);
		
		try {
			//根据随机产生的1至9的整数从R.drawable类中获取相应资源ID（静态变量）的Field对象
			Field field =R.drawable.class.getDeclaredField("face" + randomId);
			//获得资源的ID，也就是静态变量的值
			int resourceId = Integer.parseInt(field.get(null).toString());
			//根据资源ID获取资源图像的Bitmap对象
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
			//根据Bitmap对象创建ImageSpan对象
			ImageSpan imageSpan = new ImageSpan(this,bitmap);
			//创建一个SpannableString对象，以便插入用ImageSpan对象封装的图像
			SpannableString spannableString = new SpannableString("face");
			//用ImageSpan对象替换face
			spannableString.setSpan(imageSpan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			//将随机获取后得到的图像追加到EditText控件的最后
			edittext.append(spannableString);
			
		} catch (Exception e) {
			
		}
	}
	
	
}
