package com.example.project.ProgressBar;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/***
 * 拖动条控件
 * */

public class SeekBarActivity extends Activity implements
		OnSeekBarChangeListener {
	private TextView textView1;

	private TextView textView2;

	// 拉动滑竿进行时，触发该事件
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// 第一个seekBar控件
		if (seekBar.getId() == R.id.seekbar_1) {
			textView1.setText("seekBar1 当前的位置 " + progress);
		} else
			textView2.setText("seekBar2当前的位置 " + progress);
	}

	// 按住滑竿后，触发该事件
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

		if (seekBar.getId() == R.id.seekbar_1) {
			textView1.setText("seekBar1 开始拖动 ");
		} else
			textView2.setText("seekBar2开始拖动 ");

	}

	// 松开滑竿后，触发该事件
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		if (seekBar.getId() == R.id.seekbar_1) {
			textView1.setText("seekBar1 停止拖动 ");
		} else
			textView2.setText("seekBar2停止拖动 ");

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbar);
		SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekbar_1);
		seekBar1.setOnSeekBarChangeListener(this);
		SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekbar_2);
		seekBar2.setOnSeekBarChangeListener(this);
		textView1 = (TextView) findViewById(R.id.seekbar_textview1);
		textView2 = (TextView) findViewById(R.id.seekbar_textview2);
	}

}
