package com.example.project.TextView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 编写一个自定义的TextView类的控件 ，并在onDraw方法中绘制边框
 * */
public class BorderTextView extends TextView {

	public BorderTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		// 设置所绘制的边框为黄色
		paint.setColor(android.graphics.Color.YELLOW);
		// 绘制上边框
		canvas.drawLine(0, 0, this.getWidth() - 1, 0, paint);
		// 绘制左边框
		canvas.drawLine(0, 0, 0, this.getHeight() - 1, paint);
		// 绘制右边框
		canvas.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1,
				this.getHeight() - 1, paint);
		// 绘制下边框
		canvas.drawLine(0, this.getHeight() - 1, this.getWidth() - 1,
				this.getHeight() - 1, paint);
	}

}
