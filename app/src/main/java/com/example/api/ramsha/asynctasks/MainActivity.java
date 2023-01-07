package com.example.api.ramsha.asynctasks;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handlerObject = new Handler();
                //time here is in miliseconds 1sec = 1000ms
                handlerObject.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "This toast was delayed for 2 seconds", Toast.LENGTH_SHORT).show();
                    }
                },2000 );
                String querry = "hi";
                new MyAsyncTasks().execute(querry);
            }
        });
    }


    class MyAsyncTasks extends AsyncTask<String, Void, String> {
        int i = 1;

        @Override
        protected String doInBackground(String... strings) {
            String value = strings[0];

            Log.d(TAG, "doInBackground: " + strings[0]);

            return value;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(TAG, "onPostExecute: " + s);
            Toast.makeText(MainActivity.this, "s", Toast.LENGTH_SHORT).show();
            super.onPostExecute(s);
        }
    }
}