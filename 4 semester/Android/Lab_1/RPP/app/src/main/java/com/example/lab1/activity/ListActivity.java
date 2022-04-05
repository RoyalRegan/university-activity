package com.example.lab1.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lab1.utils.NumberParser;
import com.example.lab1.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

public class ListActivity extends AppCompatActivity {

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 1000000;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @TargetApi(Build.VERSION_CODES.M)
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            @SuppressLint("ViewHolder") View view = getLayoutInflater().inflate(R.layout.list_item, null);
            ImageView imageView = view.findViewById(R.id.imageItem);
            TextView textView = view.findViewById(R.id.textItem);
            Picasso.with(view.getContext()).load("http://www.sclance.com/pngs/pepehands-png/pepehands_png_1005855.png").into(imageView);
            textView.setText(NumberParser.valueToString(1000000 - position));
            if (position % 2 == 0) {
                view.setBackgroundColor(Color.WHITE);
            } else {
                view.setBackgroundColor(Color.GRAY);
            }
            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashActivity.listStart = true;
        setContentView(R.layout.activity_list);
        ListView listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        SplashActivity.listStart = false;
    }
}
