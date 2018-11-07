package com.syc.rxandroid.java_rx;

/**
 * Created by suyichen on 2018/11/7.
 */

public class Test {

    public static void main(String[] args) throws Exception {

        Watched xiaoming = new ConcreteWatched();

        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();

        xiaoming.addWatcher(watcher1);
        xiaoming.addWatcher(watcher2);
        xiaoming.addWatcher(watcher3);

        xiaoming.notifyWatchers("I have to steal something...");
    }
}
