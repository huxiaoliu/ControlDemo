package com.example.project.tabhost;

import com.example.ch05project.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

public class TabhostMainActivity extends TabActivity implements OnClickListener {

	@Override
	public void onClick(View v) {
		getTabHost().setCurrentTabByTag("tab3");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost tabHost = getTabHost();

		LayoutInflater.from(this).inflate(R.layout.tabhost_main,
				tabHost.getTabContentView(), true);
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("切换标签")
				.setContent(R.id.tabhost_main_button));
		tabHost.addTab(tabHost
				.newTabSpec("tab2")
				.setIndicator("相册",
						getResources().getDrawable(R.drawable.icon1))
				.setContent(new Intent(this, GalleryActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("评分")
				.setContent(new Intent(this, RatingListViewActivity.class)));

		Button button = (Button) findViewById(R.id.tabhost_main_button);
		button.setOnClickListener(this);
	}
}
