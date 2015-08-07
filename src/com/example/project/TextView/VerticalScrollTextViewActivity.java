package com.example.project.TextView;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;


public class VerticalScrollTextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scroll_text);
		
		TextView textview = (TextView) findViewById(R.id.scroll_textview);
		textview.setMovementMethod(ScrollingMovementMethod.getInstance());
	}
}
