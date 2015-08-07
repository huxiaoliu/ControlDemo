package com.example.project.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ch05project.R;

/**
 * 对列表项进行增，删，改操作
 * 
 * */

public class DynamicListViewActivity extends Activity implements
		OnClickListener, OnItemClickListener {

	private String[] data = new String[] {
			"天地逃生",
			"保持通话",
			"乱世佳人(飘)",
			"怪侠一枝梅",
			"第五空间",
			"孔雀翎",
			"变形金刚3（真人版）",
			"星际传奇",
			"《大笑江湖》剧中，小鞋匠是小沈阳，他常强出头，由不懂武功的菜鸟变成武林第一高手；赵本山则是个武功高强的大盗，被不会武功的小沈阳打败；程野扮演赵本山的手下皮丘，经常拖累赵本山。 其余角色都围绕小沈阳设置。" };

	private ListView lvDynamic;
	private ViewAdapter viewAdapter;
	private int selsectedIndex = 1;

	private class ViewAdapter extends BaseAdapter {
		private Context context;

		private List textIdlist = new ArrayList();

		public ViewAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {

			return textIdlist.size();
		}

		@Override
		public Object getItem(int position) {

			return position;
		}

		@Override
		public long getItemId(int position) {

			return position;
		}

		public void addText(String text) {
			textIdlist.add(text);
			notifyDataSetChanged();
		}

		public void addImage(int resId) {
			textIdlist.add(resId);
			notifyDataSetChanged();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater layoutInflater = (LayoutInflater) context
					.getSystemService(inflater);
			LinearLayout linearLayout = null;

			// 处理文本列表项
			if (textIdlist.get(position) instanceof String) {
				// 装载text.xml文件
				linearLayout = (LinearLayout) layoutInflater.inflate(
						R.layout.dynamiclistview_text, null);
				TextView textView = (TextView) linearLayout
						.findViewById(R.id.DynaminListView_TextView);
				textView.setText(String.valueOf(textIdlist.get(position)));
			}// 处理图像列表项
			else if (textIdlist.get(position) instanceof Integer) {
				linearLayout = (LinearLayout) layoutInflater.inflate(
						R.layout.dynamiclistview_image, null);
				ImageView imageView = (ImageView) linearLayout
						.findViewById(R.id.DynamicListView_ImageView);
				imageView.setImageResource(Integer.parseInt(String
						.valueOf(textIdlist.get(position))));
			}

			return linearLayout;
		}

		// 删除指定的列表项
		public void remove(int index) {
			if (index < 0) {
				return;
			}
			textIdlist.remove(index);
			notifyDataSetChanged();
		}

		// 删除所有的列表项
		public void removeAll() {
			textIdlist.clear();
			notifyDataSetChanged();

		}

		// 修改指定的列表项
		public void modify(int index, String text) {
			if (index < 0) {
				return;
			}
			// 只修改文本列表项
			if (textIdlist.get(index) instanceof String) {
				textIdlist.set(index, text);
				notifyDataSetChanged();
			}

		}

	}

	private int getImageResourceId() {
		int[] resourceIds = new int[] { R.drawable.item1, R.drawable.item2,
				R.drawable.item3, R.drawable.item4, R.drawable.item5 };
		return resourceIds[new Random().nextInt(resourceIds.length)];
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 添加文本列表项
		case R.id.dynamiclistview_btnaddText:
			int randomNum = new Random().nextInt(data.length);
			viewAdapter.addText(data[randomNum]);
			break;

		// 添加图像列表项
		case R.id.dynamiclistview_btnaddImage:
			viewAdapter.addImage(getImageResourceId());
			break;
		// 删除当前列表项
		case R.id.dynamiclistview_btnRemove:
			viewAdapter.remove(selsectedIndex);
			selsectedIndex = -1;
			break;
		// 删除所有的列表项
		case R.id.dynamiclistview_btnRemoveAll:
			viewAdapter.removeAll();
			selsectedIndex = -1;
			break;
		// 修改当前的列表项
		case R.id.dynamiclistview_btnModify:
			viewAdapter.modify(selsectedIndex,
					data[new Random().nextInt(data.length)]);
			selsectedIndex = -1;
			break;

		default:
			break;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		selsectedIndex = position;

	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dynamiclistview_main);
		lvDynamic = (ListView) findViewById(R.id.lvDynamic);
		Button btnAddText = (Button) findViewById(R.id.dynamiclistview_btnaddText);
		Button btnAddImage = (Button) findViewById(R.id.dynamiclistview_btnaddImage);
		Button btnRemove = (Button) findViewById(R.id.dynamiclistview_btnRemove);
		Button btnRemoveAll = (Button) findViewById(R.id.dynamiclistview_btnRemoveAll);
		Button btnModify = (Button) findViewById(R.id.dynamiclistview_btnModify);
		btnAddText.setOnClickListener(this);
		btnAddImage.setOnClickListener(this);
		btnRemove.setOnClickListener(this);
		btnModify.setOnClickListener(this);
		btnRemoveAll.setOnClickListener(this);

		viewAdapter = new ViewAdapter(this);
		lvDynamic.setAdapter(viewAdapter);
		lvDynamic.setOnItemClickListener(this);
	}

}
