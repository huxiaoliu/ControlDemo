package com.example.project.ImageView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.ch05project.R;

/**
 * 缩放和旋转图像
 * 
 * */
public class ResizeRoundImageViewActivity extends Activity implements
		OnSeekBarChangeListener {

	private int minWidth = 80;
	private ImageView imageView;
	private TextView textView1, textView2;
	private Matrix matrix = new Matrix();

	// 在该方法中控制图像的缩放和旋转
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		//处理图像缩放
		if (seekBar.getId() == R.id.resizeRoundSeekBar1) {
			int newWidth = progress + minWidth;	//计算缩放后图像的信宽度
			
			int newHeight = (int)(newWidth * 3/4 ); //计算缩放后图像的新高度
			//设置ImageView的大小
			imageView.setLayoutParams(new LinearLayout.LayoutParams(newWidth,newHeight));
			textView1.setText("图像宽度："+newWidth +"图像高度："+newHeight);
		}
		//处理旋转图像
		else if (seekBar.getId() == R.id.resizeRoundSeekBar2) {
			//装载dog.jpg文件并返回该文件的BitMap对象
			Bitmap bitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.dog)).getBitmap();
			//设置图像的旋转角度
			matrix.setRotate(progress);
			//旋转图像，并生成新的Bitmap对象
			bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),bitmap.getHeight(),matrix,true);
			//重新在ImageView组建中显示旋转后的图像
			imageView.setImageBitmap(bitmap);
			textView2.setText(progress+"度");
		}

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resize_round_image);
		imageView = (ImageView) findViewById(R.id.resizeRoundImageView);
		SeekBar seekBar1 = (SeekBar) findViewById(R.id.resizeRoundSeekBar1);
		SeekBar seekBar2 = (SeekBar) findViewById(R.id.resizeRoundSeekBar2);
		textView1 = (TextView) findViewById(R.id.resizeRoundTextView1);
		textView2 = (TextView) findViewById(R.id.resizeRoundTextView2);
		seekBar1.setOnSeekBarChangeListener(this);
		seekBar2.setOnSeekBarChangeListener(this);
		// 通过下列代码获得屏幕宽度，并将屏幕宽度与最小宽度的差值作为android：max的值
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		seekBar1.setMax(dm.widthPixels - minWidth);
	}

}
