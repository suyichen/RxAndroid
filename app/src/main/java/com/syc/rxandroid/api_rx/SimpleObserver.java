package com.syc.rxandroid.api_rx;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by suyichen on 2018/11/8.
 */

public class SimpleObserver implements Observer {

    public SimpleObserver(SimpleObservable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("data is changed : " + ((SimpleObservable)observable).getData()) ;
    }
}
