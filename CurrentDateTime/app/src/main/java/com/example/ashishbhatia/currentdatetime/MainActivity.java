package com.example.ashishbhatia.currentdatetime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the TextView using ID -- Label.
        dateDisplay = (TextView) findViewById(R.id.Label);
        // Change text of label using setText Method.
        dateDisplay.setText("Hello Today's Date is");
        // Get a new Date.
            Date d = new Date();
        // Log as the debug message.
            Log.d("Date is", String.valueOf(d));
        // Change text with the String value of Date.
            dateDisplay.setText(String.valueOf(d));

    }

    public void onClick(View view) {
        // Click to refresh. It will update the Label Text.
        Date d = new Date();
        dateDisplay.setText(String.valueOf(d));
    }
}
