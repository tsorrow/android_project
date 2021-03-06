package com.tsorrow.junior.senior;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DatePickerDialog.OnDateSetListener{
    private TextView tv_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_date = (TextView) findViewById(R.id.tv_date);
        findViewById(R.id.btn_date).setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String desc = String.format("您选择的是%d 年%d 月%d 日",year,month+1,dayOfMonth);
        tv_date.setText(desc);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_date){
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog dialog = new DatePickerDialog(this,this,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
            dialog.show();
        }
    }
}
