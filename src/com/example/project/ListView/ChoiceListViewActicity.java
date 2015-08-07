package com.example.project.ListView;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 为ListView列表项添加复选框和按钮
 * */
public class ChoiceListViewActicity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choicelistview);

		ListView lvCheckedTextView = (ListView) findViewById(R.id.lvCheckedTextView);
		ListView lvRaioButton = (ListView) findViewById(R.id.lvRadioButton);
		ListView lvCheckBox = (ListView) findViewById(R.id.lvCheckBox);

		String[] data = new String[] { "Android", "奋斗", "努力" };

		ArrayAdapter<String> aaCheckedTextViewAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_checked, data);
		lvCheckedTextView.setAdapter(aaCheckedTextViewAdapter);
		// 如果只设置列表项的布局，在单击列表项时，相应的控件并不会选中，因此，在设置列表项的布局后，还要使用ListView的setChoiceMode方法，
		// 设置选择的模式（单选或多选）
		lvCheckedTextView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		ArrayAdapter<String> aaRadioButtonAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_single_choice, data);
		lvRaioButton.setAdapter(aaRadioButtonAdapter);
		lvRaioButton.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		ArrayAdapter<String> aaCheckBoxAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, data);
		lvCheckBox.setAdapter(aaCheckBoxAdapter);
		lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		

	}

}
