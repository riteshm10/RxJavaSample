package com.example.rxjavasample;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myApp";
    private String greeting = "Hello from Rx ";
    private Observable<String> myObservable;
    private Observer<String> myObserver;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_greeting);
        myObservable = Observable.just(greeting);

        myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG,"onSubscribe Invoked");

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.i(TAG,"onNext Invoked");
                textView.setText(s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG,"onError Invoked");

            }

            @Override
            public void onComplete() {
                Log.i(TAG,"onComplete Invoked");

            }
        };
        myObservable.subscribe(myObserver);
    }
}
