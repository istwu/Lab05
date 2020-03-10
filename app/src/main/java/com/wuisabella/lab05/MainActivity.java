package com.wuisabella.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Dictionary;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView create1, start1, restart1, resume1, pause1, stop1, destroy1;   //1 = temp
    TextView create2, start2, restart2, resume2, pause2, stop2, destroy2;   //2 = pref
    Button reset_temp, reset_pref;
    Counter counter;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create1 = findViewById(R.id.create1);
        start1 = findViewById(R.id.start1);
        restart1 = findViewById(R.id.restart1);
        resume1 = findViewById(R.id.resume1);
        pause1 = findViewById(R.id.pause1);
        stop1 = findViewById(R.id.stop1);
        destroy1 = findViewById(R.id.destroy1);

        create2 = findViewById(R.id.create2);
        start2 = findViewById(R.id.start2);
        restart2 = findViewById(R.id.restart2);
        resume2 = findViewById(R.id.resume2);
        pause2 = findViewById(R.id.pause2);
        stop2 = findViewById(R.id.stop2);
        destroy2 = findViewById(R.id.destroy2);

        reset_temp = findViewById(R.id.reset_temp);
        reset_pref = findViewById(R.id.reset_pref);

        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        counter = new Counter();

        reset_temp.setOnClickListener(resettemp);
        reset_pref.setOnClickListener(resetpref);

        counter.add("onCreate");

        int num = sharedPreferences.getInt("onCreate", 0) + 1;
        editor.putInt("onCreate", num);
        editor.apply();

        create1.setText("onCreate: " + counter.get("onCreate"));
        create2.setText("onCreate: " + sharedPreferences.getInt("onCreate", 0));

        start1.setText("onStart: " + counter.get("onStart"));
        restart1.setText("onRestart: " + counter.get("onRestart"));
        resume1.setText("onResume: " + counter.get("onResume"));
        pause1.setText("onPause: " + counter.get("onPause"));
        stop1.setText("onStop: " + counter.get("onStop"));
        destroy1.setText("onDestroy: " + counter.get("onDestroy"));

        start2.setText("onStart: " + sharedPreferences.getInt("onStart", 0));
        restart2.setText("onRestart: " + sharedPreferences.getInt("onRestart", 0));
        resume2.setText("onResume: " + sharedPreferences.getInt("onResume", 0));
        pause2.setText("onPause: " + sharedPreferences.getInt("onPause", 0));
        stop2.setText("onStop: " + sharedPreferences.getInt("onStop", 0));
        destroy2.setText("onDestroy: " + sharedPreferences.getInt("onDestroy", 0));
    }

    @Override
    protected void onStart() {
        super.onStart();
        counter.add("onStart");

        int num = sharedPreferences.getInt("onStart", 0) + 1;
        editor.putInt("onStart", num);
        editor.apply();

        start1.setText("onStart: " + counter.get("onStart"));
        start2.setText("onStart: " + num);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        counter.add("onRestart");

        int num = sharedPreferences.getInt("onRestart", 0) + 1;
        editor.putInt("onRestart", num);
        editor.apply();

        restart1.setText("onRestart: " + counter.get("onRestart"));
        restart2.setText("onRestart: " + num);
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter.add("onResume");

        int num = sharedPreferences.getInt("onResume", 0) + 1;
        editor.putInt("onResume", num);
        editor.apply();

        resume1.setText("onResume: " + counter.get("onResume"));
        resume2.setText("onResume: " + num);
    }

    @Override
    protected void onPause() {
        super.onPause();
        counter.add("onPause");

        int num = sharedPreferences.getInt("onPause", 0) + 1;
        editor.putInt("onPause", num);
        editor.apply();

        pause1.setText("onPause: " + counter.get("onPause"));
        pause2.setText("onPause: " + num);
    }

    @Override
    protected void onStop() {
        super.onStop();
        counter.add("onStop");
        int num = sharedPreferences.getInt("onStop", 0) + 1;
        editor.putInt("onStop", num);
        editor.apply();

        stop1.setText("onStop: " + counter.get("onStop"));
        stop2.setText("onStop: " + num);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        counter.add("onDestroy");

        int num = sharedPreferences.getInt("onDestroy", 0) + 1;
        editor.putInt("onDestroy", num);
        editor.apply();

        destroy1.setText("onDestroy: " + counter.get("onDestroy"));
        destroy2.setText("onDestroy: " + num);
    }

    View.OnClickListener resettemp = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            counter.reset();
            create1.setText("onCreate: " + 0);
            start1.setText("onStart: " + 0);
            restart1.setText("onRestart: " + 0);
            resume1.setText("onResume: " + 0);
            pause1.setText("onPause: " + 0);
            stop1.setText("onStop: " + 0);
            destroy1.setText("onDestroy: " + 0);
        }
    };

    View.OnClickListener resetpref = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Map<String, ?> entries = sharedPreferences.getAll();
            for (String key : entries.keySet()) {
                editor.putInt(key, 0);
            }
            editor.apply();

            create2.setText("onCreate: " + 0);
            start2.setText("onStart: " + 0);
            restart2.setText("onRestart: " + 0);
            resume2.setText("onResume: " + 0);
            pause2.setText("onPause: " + 0);
            stop2.setText("onStop: " + 0);
            destroy2.setText("onDestroy: " + 0);
        }
    };
}

