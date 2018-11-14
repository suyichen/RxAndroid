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


    public void createMethod1(View view) {
        RxUtils.createObserable();
    }

    public void createMethod2(View view) {
        RxUtils.createPrint();
    }

    public void createMethod3(View view) {
        RxUtils.from();
    }

    public void createMethod4(View view) {
        RxUtils.interval();
    }

    public void createMethod5(View view) {
        RxUtils.just();
    }

    public void createMethod6(View view) {
        RxUtils.filter();
    }

    public void createMethod7(View view) {
    }
}
