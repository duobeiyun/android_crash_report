package com.duobeiyun.crash.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dd.test.TestCrashActivity;
import com.duobeiyun.crashreport.XCrash;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_crash_native).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XCrash.testNativeCrash();
            }
        });
        findViewById(R.id.btn_crash_java).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 1 / 0;
            }
        });
        findViewById(R.id.btn_crash_business).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TestCrashActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}