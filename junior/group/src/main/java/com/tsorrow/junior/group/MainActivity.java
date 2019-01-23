package com.tsorrow.junior.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_tab_button).setOnClickListener(this);
        findViewById(R.id.btn_tab_host).setOnClickListener(this);
        findViewById(R.id.btn_tab_group).setOnClickListener(this);
        findViewById(R.id.btn_tab_fragment).setOnClickListener(this);
        findViewById(R.id.btn_toolbar).setOnClickListener(this);
        findViewById(R.id.btn_overflow_menu).setOnClickListener(this);
        findViewById(R.id.btn_search_view).setOnClickListener(this);
        findViewById(R.id.btn_toolbar_custom).setOnClickListener(this);
        findViewById(R.id.btn_tab_layout).setOnClickListener(this);
        findViewById(R.id.btn_tab_custom).setOnClickListener(this);
        findViewById(R.id.btn_banner_indicator).setOnClickListener(this);
        findViewById(R.id.btn_banner_pager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_tab_button) {
            Intent intent = new Intent(this, TabButtonActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_tab_host) {
            Intent intent = new Intent(this, TabHostActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_tab_group) {
            Intent intent = new Intent(this, TabGroupActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_tab_fragment) {
            Intent intent = new Intent(this, TabFragmentActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_toolbar){
            Intent intent = new Intent(this, ToolbarActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_overflow_menu){
            Intent intent = new Intent(this, OverflowMenuActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_search_view){
            Intent intent = new Intent(this, SearchViewActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_toolbar_custom){
            Intent intent = new Intent(this, ToolbarCustomActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_tab_layout){
            Intent intent = new Intent(this, TabLayoutActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_tab_custom){
            Intent intent = new Intent(this, TabCustomActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_banner_indicator){
            Intent intent = new Intent(this, BannerIndicatorActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_banner_pager){
            Intent intent = new Intent(this, BannerPagerActivity.class);
            startActivity(intent);
        }
    }
}
