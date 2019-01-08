package com.tsorrow.junior.custom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_custom_property).setOnClickListener(this);
        findViewById(R.id.btn_measure_text).setOnClickListener(this);
        findViewById(R.id.btn_measure_layout).setOnClickListener(this);
        findViewById(R.id.btn_on_layout).setOnClickListener(this);
        findViewById(R.id.btn_on_draw).setOnClickListener(this);
        findViewById(R.id.btn_dispatch_draw).setOnClickListener(this);
        findViewById(R.id.btn_runnable).setOnClickListener(this);
        findViewById(R.id.btn_pull_refresh).setOnClickListener(this);
        findViewById(R.id.btn_circle_animation).setOnClickListener(this);
        findViewById(R.id.btn_window).setOnClickListener(this);
        findViewById(R.id.btn_dialog_date).setOnClickListener(this);
        findViewById(R.id.btn_dialog_multi).setOnClickListener(this);
        findViewById(R.id.btn_notify_simple).setOnClickListener(this);
        findViewById(R.id.btn_notify_counter).setOnClickListener(this);
        findViewById(R.id.btn_notify_progress).setOnClickListener(this);
        findViewById(R.id.btn_notify_custom).setOnClickListener(this);
        findViewById(R.id.btn_service_normal).setOnClickListener(this);
        findViewById(R.id.btn_bind_immediate).setOnClickListener(this);
        findViewById(R.id.btn_bind_delay).setOnClickListener(this);
        findViewById(R.id.btn_notify_service).setOnClickListener(this);
        findViewById(R.id.btn_app_info).setOnClickListener(this);
        findViewById(R.id.btn_traffic_info).setOnClickListener(this);
        findViewById(R.id.btn_mobile_assistant).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_custom_property) {
            Intent intent = new Intent(this, CustomPropertyActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_measure_text) {
            Intent intent = new Intent(this, MeasureTextActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_measure_layout) {
            Intent intent = new Intent(this, MeasureLayoutActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_on_layout) {
            Intent intent = new Intent(this, OnLayoutActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_on_draw) {
            Intent intent = new Intent(this, OnDrawActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_dispatch_draw) {
            Intent intent = new Intent(this, DispatchDrawActivity.class);
            startActivity(intent);
        }
    }
}
