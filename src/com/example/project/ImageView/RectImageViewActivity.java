package com.example.project.ImageView;

import com.example.ch05project.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 
 * 利用ImageView显示指定区域的图像
 * */
public class RectImageViewActivity extends Activity implements OnTouchListener {

	private ImageView imageView1;
	private ImageView imageView2;

	// 将ImageView按等比例缩小的核心代码在ImgeView类的onTouch方法中，要不做onTouch事件，必须事先OnTouchListener接口
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		try {
			// 计算转换比例，500为图片的宽度，320位ImageView也就是模拟器的分辨率,显示的指定区域大小为100*100
			float scale = (float) (500.0 /
					
					320.0);
			int x = (int) (event.getX() * scale);
			int y = (int) (event.getY() * scale);
			int width = (int) (100 * scale);
			int height = (int) (100 * scale);
			// 从原图像上截取指定区域的图像，并将生成的BitmapDrawable对象显示在第二个ImageView控件中
			BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView1
					.getDrawable();
			imageView2.setImageBitmap(Bitmap.createBitmap(
					bitmapDrawable.getBitmap(), x, y, width, height));
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}

		return false;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rectimageview);
		imageView1 = (ImageView) findViewById(R.id.imageview1);
		imageView2 = (ImageView) findViewById(R.id.imageview2);
		imageView1.setOnTouchListener(this);
	}

}
