package com.syc.rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.syc.rxandroid.android_rx.RxUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * First way:
     * Call the create method
     * @param view
     */
    public void createMethod(View view) {
        RxUtils.createObserable();
    }
}
