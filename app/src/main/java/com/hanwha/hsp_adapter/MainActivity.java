package com.hanwha.hsp_adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hanwha.hsp_adapter.view.MainFrgmt;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (savedInstanceState == null) {
            ViewController.get(this).add(R.id.main_layout, MainFrgmt.class);
        }
    }
}
