package com.syc.rxandroid.api_rx;

/**
 * Created by suyichen on 2018/11/8.
 */

public class Test2 {

    public static void main(String[] args) throws Exception {
        SimpleObservable observable = new SimpleObservable();
        SimpleObserver observer = new SimpleObserver(observable);

        observable.setData(1);
        observable.setData(2);
        observable.setData(2);
        observable.setData(3);
    }
}
