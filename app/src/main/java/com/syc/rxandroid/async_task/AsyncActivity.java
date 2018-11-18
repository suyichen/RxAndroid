package com.syc.rxandroid.async_task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.syc.rxandroid.MainActivity;
import com.syc.rxandroid.R;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by suyichen on 2018/11/14.
 */

public class AsyncActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private String PATH = "http://editerupload.eepw.com.cn/201809/61001537857032.jpg";
    private DownLoadUtils utils;
    private final static String TAG = AsyncActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        button = (Button) this.findViewById(R.id.button);
        imageView = (ImageView) this.findViewById(R.id.imageView);

        utils = new DownLoadUtils();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utils.downloadImage(PATH).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG,"onCompleted");//dismiss
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG,e.getMessage());
                    }

                    @Override
                    public void onNext(byte[] bytes) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }
}
