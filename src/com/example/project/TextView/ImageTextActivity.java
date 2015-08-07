package com.example.project.TextView;

import java.lang.reflect.Field;

import com.example.ch05project.R;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * 在TextView中显示表情图像和文字
 * */

public class ImageTextActivity extends Activity {

	// name 参数表示res/drawable中的图像文字名
	public int getResourceId(String name) {
		try {
			// 根据资源ID的变量名（也就是图像资源的文件名）获得Field对象
			Field field = R.drawable.class.getField(name);
			// 取得并返回资源ID字段（静态变量）的值
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_image);

		TextView textView = (TextView) findViewById(R.id.textview);
		// 设置TextView的文字颜色
		textView.setTextColor(Color.BLACK);
		// 设置TextView的背景颜色
		textView.setBackgroundColor(Color.WHITE);
		// 设置TextView的字体大小
		textView.setTextSize(20);

		String html = "图像1<img src='image1'/>图像2<img src='image2'/>图像3<img src='image3'/><p>";
		html += "图像4<a href='https://www.baidu.com'><img src='image4'/></a>图像5<img src='image5'/>";

		// 使用Html.fromHtml方法转换包含Html标签的文本，需要指定fromHtml方法的第二个参数
		CharSequence charSequence = Html.fromHtml(html, new ImageGetter() {

			@Override
			public Drawable getDrawable(String source) {
				//转载路线资源
				Drawable drawable = getResources().getDrawable(getResourceId(source));
				//第三个图像文件按50%等比压缩显示（24*24）	
				if (source.equals("image3")) {
					drawable.setBounds(0, 0, drawable.getIntrinsicWidth()/2, drawable.getIntrinsicHeight()/2);
				}else {	//	其它的图像文件按原大小显示
					drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
				}
				
				return drawable;
			}
		}, null);
		textView.setText(charSequence);
		//	只要使用了 <a>标签，就必须设置MovementMethod对象，否则<a>除了标签效果外，并不起任何作用
		textView.setMovementMethod(LinkMovementMethod.getInstance());
	}

}
