package com.example.project.imageswitcher;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

/**
 * 图像切换控件
 * */
public class ImageSwitcherActivity extends Activity implements ViewFactory,
		OnClickListener {

	private ImageSwitcher imageSwitcher;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageswitcherButton1:
			imageSwitcher.setImageResource(R.drawable.item1);
			break;
		case R.id.imageswitcherButton2:
			imageSwitcher.setImageResource(R.drawable.item2);
			break;
		case R.id.imageswitcherButton3:
			imageSwitcher.setImageResource(R.drawable.item3);
			break;

		default:
			break;
		}

	}

	// ViewFactory接口有一个makeView方法，该方法与BaseAdapter类的getView方法类似
	// 都是在控件显示时创建内容的视图对象
	@Override
	public View makeView() {
		ImageView imageView = new ImageView(this);
		imageView.setBackgroundColor(0xFF000000);
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		return imageView;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageswitcher1);
		Button button1 = (Button) findViewById(R.id.imageswitcherButton1);
		Button button2 = (Button) findViewById(R.id.imageswitcherButton2);
		Button button3 = (Button) findViewById(R.id.imageswitcherButton3);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		// 设置工厂视图，也就是实现ViewFactroy接口的类的对象实例
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
		// 设置图形的淡入效果
		imageSwitcher.setFactory(this);
		imageSwitcher.setInAnimation(this, android.R.anim.fade_in);
		// 设置图形的淡出效果
		imageSwitcher.setOutAnimation(this, android.R.anim.fade_out);

	}

}
