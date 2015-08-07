package com.example.project.EditText;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

/**
 * 利用AutoCompleteTextView控件，自动完成输入内容
 * */
public class AutoCompLeteTextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autocompletetextview);

		String[] autoString = new String[] { "联合国", "联合国安理会", "联合国五个常任理事国",
				"bb", "bcd", "bcdf", "Google", "Google Map", "Google Android" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, autoString);

		AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
		autoCompleteTextView.setAdapter(adapter);

		MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
		multiAutoCompleteTextView.setAdapter(adapter);
		multiAutoCompleteTextView
				.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}

}
