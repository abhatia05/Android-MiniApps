package com.example.ashishbhatia.emailfromapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sndbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sndbtn = (Button) findViewById(R.id.sendEmail);
    }

    public void SendEmail(View view) {

        Intent sendEmailIntent = new Intent(Intent.ACTION_SEND);
        sendEmailIntent.setType("text/html");
        sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"inspiremeashish@gmail.com"});
        sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        sendEmailIntent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
        startActivity(Intent.createChooser(sendEmailIntent,"Choose an email client: "));
    }
}
