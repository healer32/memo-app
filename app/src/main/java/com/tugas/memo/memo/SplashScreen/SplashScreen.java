package com.tugas.memo.memo.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tugas.memo.memo.MemoList;
import com.tugas.memo.memo.R;

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MemoList.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}