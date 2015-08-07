package com.example.project.ProgressBar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

import com.example.ch05project.R;

public class RatingBarActivity extends Activity implements
		OnRatingBarChangeListener {

	private RatingBar smallRatingBar;

	private RatingBar indicatorRatingBar;

	private TextView textView;

	// 当RatingBar的分数变化后，系统会调用OnRatingBarChangeListener接口的该方法,该接口可以监听RatingBar控件的动作
	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
		smallRatingBar.setRating(rating); // 更新小五角星风格的RatingBar控件的当前分数
		indicatorRatingBar.setRating(rating);// 更新五角星风格的RatingBar控件的当前分数
		if (ratingBar.getId() == R.id.ratingbar_1) {
			textView.setText("ratingbar1的分数：" + rating);
		} else
			textView.setText("ratingbar2的分数：" + rating);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ratingbar);

		RatingBar ratingBar1 = (RatingBar) findViewById(R.id.ratingbar_1);
		RatingBar ratingBar2 = (RatingBar) findViewById(R.id.ratingbar_2);
		textView = (TextView) findViewById(R.id.ratingbar_textview);

		ratingBar1.setOnRatingBarChangeListener(this);
		ratingBar2.setOnRatingBarChangeListener(this);

		smallRatingBar = (RatingBar) findViewById(R.id.smallRatingBar);
		indicatorRatingBar = (RatingBar) findViewById(R.id.indicatorRatingbar);
	}
}
