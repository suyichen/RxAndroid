package com.syc.rxandroid.java_rx;

/**
 * Created by suyichen on 2018/11/7.
 */

public class ConcreteWatcher implements Watcher {
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
