package com.syc.rxandroid.java_rx;

/**
 * Created by suyichen on 2018/11/7.
 */

/**
 * Watched
 */
public interface Watched {

    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers(String str); //Remind all Watcher
}
