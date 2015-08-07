package com.example.project.Button;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * 选项按钮控件 选项按钮可用于多选1的应用中，如果想在选中某一个按钮后，其它的选项按钮处于未选中状态
 * 需要将<RadioButton>标签放置在<RadioGroup>中
 * */

public class RadioButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radiobutton);
	}

}
