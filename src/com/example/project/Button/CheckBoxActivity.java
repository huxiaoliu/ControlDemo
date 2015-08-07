package com.example.project.Button;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.ch05project.R;

/**
 * 动态创建CheckBox的实例
 * 1:定义一个String类型的数组，数组元素定义了CheckBox的文本
 * 2:根据String数组的元素个数来动态创建CheckBox对象,如下：
 * 		1：使用getLayoutInflater().inflate(...)方法来加载checkbox_main.xml布局文件，并返回一个LinearLayout对象
 * 		2：使用getLayoutInflater().inflate(...)方法来加载checkbox.xml布局文件，并返回一个CheckBox对象
 * 		3：根据String数组的值设置CheckBox文本
 * 		4：调用linearLayout.addView方法将checkBox添加到linearLayout中
 * 		5：根据String数组的元素重复执行第2,3,4步，知道处理完String数组中的最后一个元素为止。
 * */

public class CheckBoxActivity extends Activity implements OnClickListener {

	private List<CheckBox> checkboxs = new ArrayList<CheckBox>();

	@Override
	public void onClick(View view) {
		String s = "";
		// 扫描所有的CheckBox对象，以便获得被选中的复选框的文本
		for (CheckBox checkbox : checkboxs) {
			if (checkbox.isChecked())
				s += checkbox.getText() + "\n";
		}
		if ("".equals(s))
			s = "您还没选呢！";
		new AlertDialog.Builder(this).setMessage(s)
				.setPositiveButton("关闭", null).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		String[] checkboxTest = new String[] { "是学生吗？", "喜欢Android吗？", "买车了吗？",
				"打算出国吗？" };
		
		super.onCreate(savedInstanceState);
		
		// 1：使用getLayoutInflater().inflate(...)方法来加载checkbox_main.xml布局文件，并返回一个LinearLayout对象
		LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(
				R.layout.checkbox_main, null);

		for (int i = 0; i < checkboxTest.length; i++) {

			// 2:使用getLayoutInflater().inflate(...)方法来加载checkbox.xml布局文件，并返回一个CheckBox对象
			CheckBox checkBox = (CheckBox) getLayoutInflater().inflate(
					R.layout.checkbox, null);

			// 将CheckBox对象添加到checkbox数组中，用于对CheckBox对象的检索
			checkboxs.add(checkBox);

			// 设置checkboxs数组中CheckBox对象的文本
			checkboxs.get(i).setText(checkboxTest[i]);

			// 将CheckBox对象添加到界面的主布局中，在按钮前面显示复选框
			linearLayout.addView(checkBox, i);
		}

		setContentView(linearLayout);
		Button button = (Button) findViewById(R.id.checkbox_main_Button);
		button.setOnClickListener(this);
	}

}
