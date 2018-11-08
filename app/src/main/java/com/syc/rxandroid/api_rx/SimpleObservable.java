package com.syc.rxandroid.api_rx;

import java.util.Observable;

/**
 * Created by suyichen on 2018/11/8.
 * <p>
 * Create a watched
 */

public class SimpleObservable extends Observable {
    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int i){
        if (this.data != i){
            this.data = i;
            //changes happened
            setChanged();
            //Notify the watcher,Indicates that the status has changed
            notifyObservers();
        }
    }
}
