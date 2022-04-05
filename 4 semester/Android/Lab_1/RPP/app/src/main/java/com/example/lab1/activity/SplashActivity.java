package com.example.lab1.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lab1.R;

import java.util.logging.Logger;

public class SplashActivity extends AppCompatActivity {
    public static boolean listStart = false;

    class SplashEvent extends Thread {
        private Context context;

        SplashEvent(Context context) {
            this.context = context;
        }

        @Override
        public void run() {
            try {
                sleep(2000);
            } catch (Exception ex) {
                Logger.getGlobal().info(ex.toString());
            }
            if (!listStart) {
                Intent intent = new Intent(context, ListActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
        setContentView(R.layout.activity_splash);
        new SplashEvent(this).start();

    }
}
