package com.example.project.ViewStub;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.example.ch05project.R;

/**
 * 惰性转载控件
 * */

public class ViewStubActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewstub_main);
	
	}
	
	public void onClick_Button(View v){
		//ViewStub控件只能获得一次，第二次再使用findViewById获得该ViewStub对象，则返回null
		View view = findViewById(R.id.viewstub);
		if (view != null) {
			//或调用ViewStub.inflate方法
			//view =view = ((ViewStub) view).inflate();
			//转载ViewStub引用的viewstub_custom.xml文件中的控件
			((ViewStub)view).setVisibility(View.VISIBLE);
		}else
		{
			setTitle("view is null");
		}
	}
}
