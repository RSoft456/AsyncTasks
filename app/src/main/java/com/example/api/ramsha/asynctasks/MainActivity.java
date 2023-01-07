package com.example.api.ramsha.asynctasks;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
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
                String querry="hi";
                new MyAsyncTasks().execute(querry);
            }
        });
    }

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
        super.onPostExecute(s);
    }
}