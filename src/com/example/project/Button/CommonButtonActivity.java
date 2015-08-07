package com.example.project.Button;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class CommonButtonActivity extends Activity implements OnClickListener,
		OnTouchListener, OnFocusChangeListener, OnKeyListener {

	private int value = 1;

	private Button imageButton;

	private Button commonButton;

	private View lastFocusview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ch05_button);
		commonButton = (Button) findViewById(R.id.btnCommonButton);
		imageButton = (Button) findViewById(R.id.btnImageButton);

		commonButton.setOnClickListener(this); // 绑定按钮点击事件
		imageButton.setOnClickListener(this);
		imageButton.setOnTouchListener(this); // 绑定按钮触摸事件
		imageButton.setOnFocusChangeListener(this); // 绑定按钮焦点变化事件
		imageButton.setOnKeyListener(this); // 绑定键盘事件（当一个按钮获得焦点后，按下手机或模拟器上的“确认”按钮，当前按钮应该被置成被按下的状态）
	}

	// 当按手机或者模拟器上的“确认”键时，需要将当前获得焦点的异形按钮设为按键的被按下状态，当松开“确认”键时，又恢复到获得焦点的状态。这个功能需要在键盘事件的onKey（）中处理
	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
//		if (KeyEvent.ACTION_DOWN == event.getAction()) {
//			// 设置异形按钮被按下时的背景图
//			v.setBackgroundResource(R.drawable.button3);
//		} else if (KeyEvent.ACTION_UP == event.getAction()) {
//			// 设置异形按钮被抬起时的背景图（焦点状态的）
//			v.setBackgroundResource(R.drawable.button3);
//		}
		return false;
	}

	// 当控件焦点变化时调用该事件方法，当控件获得焦点时，hasFocus参数值为true，候着为false
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
//		if (hasFocus) {
//			// 设置异形按钮获得焦点时的背景图
//			imageButton.setBackgroundResource(R.drawable.button2);
//		} else {
//			// 设置异形按钮失去焦点时的背景图
//			imageButton.setBackgroundResource(R.drawable.button1);
//		}
//
	}

	// 触摸事件，当触摸按钮时，应该显示的屏幕状态
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP) {
			// 当手指或者鼠标抬起时恢复按钮的默认状态
			view.setBackgroundResource(R.drawable.button1);
		} else if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// 当手指或鼠标按下时将按钮设置为按下状态
			view.setBackgroundResource(R.drawable.button2);
		}

		return false;
	}

	@Override
	public void onClick(View view) {
		Button button = (Button) view;
		// 如果按钮宽度等于屏幕宽度，按钮开始缩小
		if (value == 1
				&& button.getWidth() == getWindowManager().getDefaultDisplay()
						.getWidth()) {
			value = -1;
		}
		// 如果按钮宽度小于100，按钮开始放大
		else if (value == -1 && button.getWidth() < 100) {
			value = 1;
		}

		// 以按钮宽度和高度的10%放大或缩小按钮
		button.setWidth(button.getWidth() + (int) (button.getWidth() * 0.1)
				* value);
		button.setHeight(button.getHeight() + (int) (button.getHeight() * 0.1)
				* value);

	}

}
