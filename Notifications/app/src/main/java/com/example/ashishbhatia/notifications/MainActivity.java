package com.example.ashishbhatia.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText title,description;
    private CheckBox actioncheckbox;
    private Button createbtn;

    //Notification

    private NotificationCompat.Builder mNotiBuilder;
    private NotificationManager mNotiManager;

    int NOTIFICATION_ID = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (EditText) findViewById(R.id.ettitle);
        description= (EditText) findViewById(R.id.etdesc);
        actioncheckbox = (CheckBox) findViewById(R.id.chkbox);
        createbtn = (Button) findViewById(R.id.createbutton);

        mNotiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);



    }

    public void createnotification(View view) {
        mNotiBuilder = new NotificationCompat.Builder(this);
        mNotiBuilder.setContentTitle(title.getText().toString());
        mNotiBuilder.setContentText(description.getText().toString());

        if(actioncheckbox.isChecked()){
            mNotiBuilder.addAction(R.mipmap.ic_launcher,"Share",null);
        }
        mNotiBuilder.setSmallIcon(R.mipmap.ic_launcher);
       // Notification n = mNotiBuilder.build();
      //  mNotiBuilder.notify();
        mNotiManager.notify(NOTIFICATION_ID,mNotiBuilder.build());



    }
}
