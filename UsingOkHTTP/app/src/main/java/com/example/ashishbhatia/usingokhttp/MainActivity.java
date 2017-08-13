package com.example.ashishbhatia.usingokhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    Button sbmbtn;
    TextView result;

    String rs;

    private OkHttpClient okHttpClient;

    private Request request;

    private String url = "http://www.mocky.io/v2/59903440120000110094634a";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbmbtn = (Button) findViewById(R.id.submitrequest);
        result = (TextView) findViewById(R.id.tvresult);

    }

    public void submitrequest(View view) {
        // Initialize the http client
        okHttpClient = new OkHttpClient();

        // Initialize the request
        request = new Request.Builder().url(url).build();

        // Execute the request.

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.i(TAG,e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                 rs = (response.body().string());



            }
        });

        result.setText(rs);


    }
}
