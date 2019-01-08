package com.tsorrow.junior.storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_show1 = (TextView) findViewById(R.id.tv_show1);
        String show1 = SystemUtil.getSystemModel();
        tv_show1.setText("设备型号：" + show1);

        TextView tv_show2 = (TextView) findViewById(R.id.tv_show2);
        String show2 = SystemUtil.getSystemVersion();
        tv_show2.setText("设备版本号：" + show2);

        TextView tv_show3 = (TextView) findViewById(R.id.tv_show3);
        String show3 = android.os.Build.VERSION.SDK;
        tv_show3.setText("SDK：" + show3);

        TextView tv_show4 = (TextView) findViewById(R.id.tv_show4);
        String show4 = SystemUtil.getDeviceBrand();
        tv_show4.setText("设备厂家：" + show4);
    }
}
