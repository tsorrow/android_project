package com.tsorrow.junior.device;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_turn_view).setOnClickListener(this);
        findViewById(R.id.btn_turn_surface).setOnClickListener(this);
        findViewById(R.id.btn_camera_info).setOnClickListener(this);
        findViewById(R.id.btn_photograph).setOnClickListener(this);
        findViewById(R.id.btn_trun_texture).setOnClickListener(this);
        findViewById(R.id.btn_shooting).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_turn_view){
            Intent intent = new Intent(this,TurnViewActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_turn_surface){

        }else if(v.getId() == R.id.btn_camera_info){
            Intent intent = new Intent(this,CameraInfoActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_photograph){

        }else if(v.getId() == R.id.btn_trun_texture){

        }else if(v.getId() == R.id.btn_shooting){

        }

    }
}
