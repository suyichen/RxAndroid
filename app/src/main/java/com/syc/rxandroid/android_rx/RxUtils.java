package com.syc.rxandroid.android_rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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

    /**
     * Second way:
     * <p>
     * Call the create method
     */
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

    /**
     * Third way:
     * <p>
     * The returned object is generally a numeric type
     */
    public static void from() {
        Integer[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Observable observable = Observable.from(items);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG, o.toString());
            }
        });
    }

    /**
     * Timer
     * specifying a certain time to send
     */
    public static void interval() {
        Integer[] items = {1, 2, 3, 4, 5};
        //Send data every second
        Observable observable = Observable.interval(1, 1, TimeUnit.SECONDS);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG, o.toString());
            }
        });
    }

    /**
     * Processing array collection
     */
    public static void just() {
        Integer[] items1 = {0, 1, 2, 3, 4};
        Integer[] items2 = {5, 6, 7, 8, 9};
        Observable observable = Observable.just(items1, items2);
        observable.subscribe(new Subscriber<Integer[]>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onNext(Integer[] integers) {
                for (int i = 0; i < integers.length; i++) {
                    Log.i(TAG, "next : " + integers[i]);
                }
            }
        });
    }

    /**
     * Specify the range of output data
     */
    public static void range() {
        //From 1 to 40
        Observable observable = Observable.range(1, 40);
        observable.subscribe(new Subscriber<Integer>() {
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
                Log.i(TAG, "next : " + integer);
            }
        });
    }

    public static void filter() {
        Observable observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8);
        observable.filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer o) {
                return o < 5;
            }
        }).observeOn(Schedulers.io()).subscribe(new Subscriber<Integer>() {
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
                Log.i(TAG, "next : " + integer.toString());
            }
        });
    }
}
