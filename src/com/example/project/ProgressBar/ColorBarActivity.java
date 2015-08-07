package com.example.project.ProgressBar;

import android.app.Activity;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;

import com.example.ch05project.R;

/**
 * 设置ProgressBar和SeekBar的颜色以及背景按钮
 * */
public class ColorBarActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colorbar);
		LayerDrawable layerDrawable = (LayerDrawable) getResources()
				.getDrawable(R.drawable.barcolor1);
		Log.d("layerDrawable_child_count",
				String.valueOf(layerDrawable.getNumberOfLayers()));
		Log.d("background_id", String.valueOf(layerDrawable.getId(0)));
		Log.d("background",
				String.valueOf(layerDrawable.getDrawable(0).getClass()));
		Log.d("secondaryProgress",
				String.valueOf(layerDrawable.getDrawable(1).getClass()));
		Log.d("progress",
				String.valueOf(layerDrawable.getDrawable(2).getClass()));

	}
	
}

