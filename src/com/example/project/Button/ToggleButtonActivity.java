package com.example.project.Button;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ToggleButton;

/**
 * 开关状态按钮控件
 * 
 * */

public class ToggleButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.togglebutton);
		
		ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
		toggleButton.setChecked(true);
	}
	
}
