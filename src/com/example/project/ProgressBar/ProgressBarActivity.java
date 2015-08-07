package com.example.project.ProgressBar;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * 进度条控件的一些用法   cc
 * 
 * */

public class ProgressBarActivity extends Activity implements OnClickListener {

	private ProgressBar progressBarHorizontal;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.progressbarButton1:
			// 处理“增加进度”按钮事件
			progressBarHorizontal.setProgress((int) (progressBarHorizontal
					.getProgress() * 1.2));
			progressBarHorizontal
					.setSecondaryProgress((int) (progressBarHorizontal
							.getSecondaryProgress() * 1.2));
			break;
		// 处理“减少进度”按钮事件
		case R.id.progressbarButton2:
			progressBarHorizontal.setProgress((int) (progressBarHorizontal
					.getProgress() * 0.8));
			progressBarHorizontal
					.setSecondaryProgress((int) (progressBarHorizontal
							.getSecondaryProgress() * 0.8));
			break;
		default:
			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);// 要在setContentView方法之前调用，否则会报错
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.progressbar);
		setProgressBarVisibility(true);	//显示水平进度条
		setProgressBarIndeterminateVisibility(true);	//显示圆形进度条
		setProgress(3500);		//显示水平进度条的当前进度
		progressBarHorizontal = (ProgressBar) findViewById(R.id.progressBarHorizontal);
		Button button1 = (Button) findViewById(R.id.progressbarButton1);
		Button button2 = (Button) findViewById(R.id.progressbarButton2);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

}
