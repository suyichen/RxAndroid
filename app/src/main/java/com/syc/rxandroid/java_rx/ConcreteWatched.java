package com.syc.rxandroid.java_rx;

/**
 * Created by suyichen on 2018/11/7.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Define specific observed objects
 */
public class ConcreteWatched implements Watched {

    private List<Watcher> list = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    //message notification
    @Override
    public void notifyWatchers(String str) {
        for(Watcher watcher:list){
            watcher.update(str );
        }
    }
}
