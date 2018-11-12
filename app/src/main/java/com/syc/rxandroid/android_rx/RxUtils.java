package com.syc.rxandroid.android_rx;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by suyichen on 2018/11/8.
 */

public class RxUtils {

    //Get the name of the current class
    private static final String TAG = RxUtils.class.getSimpleName();

    /**
     * Use create mode
     */
    public static void createObserable() {
        //Define an observer
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //If the observer and the observable have a subscription relationship
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("hello");
                    subscriber.onNext(downLoadJson());
                    subscriber.onNext("world");
                    subscriber.onCompleted();
                }
            }
        });


        Subscriber<String> subscriber = new Subscriber<String>() {

            //carry out
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            //send data
            @Override
            public void onNext(String s) {
                Log.i(TAG, "result --> " + s);
            }
        };
        //association
        observable.subscribe(subscriber);
    }

    /**
     * Analog download method
     *
     * @return
     */
    public static String downLoadJson() {
        return "Json Data";
    }

    public static void createPrint() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 1; i <= 10; i++) {
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG, "result --> " + integer);
            }
        });
    }
}
