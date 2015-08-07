package com.example.project.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.ch05project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

/***
 * 利用DatePicker和TimePicker现实日期和时间
 * 
 * */

public class DateTimePickerActivity extends Activity implements
		OnDateChangedListener, OnTimeChangedListener {

	private TextView textView;
	private DatePicker datePicker;
	private TimePicker timePicker;

	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		// 调用onDateChanged事件方法在TextView中显示当前的日期和时间
		onDateChanged(null, 0, 0, 0);

	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(datePicker.getYear(), datePicker.getMonth(),
				datePicker.getDayOfMonth(), timePicker.getCurrentHour(),
				timePicker.getCurrentMinute());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm");
		//在TextView中显示当前的日期和时间
		textView.setText(sdf.format(calendar.getTime()));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datetimepicker);
		datePicker = (DatePicker) findViewById(R.id.datepicker);
		timePicker = (TimePicker) findViewById(R.id.timepicker);
		datePicker.init(2015, 8, 5, this);
		timePicker.setIs24HourView(true);
		timePicker.setOnTimeChangedListener(this);
		textView = (TextView) findViewById(R.id.datetimepicker_textview);
		//在TextView上显示DatePicker及TimePicker上的日期和时间
		onDateChanged(null, 0, 0, 0);
	
	}

}
