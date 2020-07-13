package com.dd.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.duobeiyun.crash.sample.R;

public class TestCrashActivity extends AppCompatActivity {
    private int testNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_crash);
        findViewById(R.id.btn_crash_no_dby).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testNo = 1 / 0;
            }
        });
    }
}