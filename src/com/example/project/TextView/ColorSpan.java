package com.example.project.TextView;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/**
 * BackgroundColorSpan只能设置背景文字的颜色，为了更加通用， 我设置了一个ColorSpan类，使其可以同时可以设置文字颜色和背景色
 * */

public class ColorSpan extends CharacterStyle {

	private int mTextColor;

	private int mBackgroundColor;

	public ColorSpan(int textColor, int backgroundColor) {
		mTextColor = textColor;
		mBackgroundColor = backgroundColor;

	}

	// 覆盖了CharacterStyle类中的updateDrawState方法，并在该方法中设置了文字和背景颜色
	@Override
	public void updateDrawState(TextPaint tp) {
		tp.bgColor = mBackgroundColor;
		tp.setColor(mTextColor);

	}

}
