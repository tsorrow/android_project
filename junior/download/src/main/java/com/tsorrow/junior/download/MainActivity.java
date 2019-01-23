package com.tsorrow.junior.download;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_download).setOnClickListener(this);
        findViewById(R.id.pause_download).setOnClickListener(this);
        findViewById(R.id.cancel_download).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_download:
                Toast.makeText(MainActivity.this,"start_download",Toast.LENGTH_SHORT).show();
                break;
            case R.id.pause_download:
                Toast.makeText(MainActivity.this,"pause_download",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel_download:
                Toast.makeText(MainActivity.this,"cancel_download",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
