package com.example.ashishbhatia.internaldatastorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText f_name,f_content;
    Button save_button,read_button;
    TextView filecontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f_name = (EditText) findViewById(R.id.filename);
        f_content =(EditText) findViewById(R.id.filecontent);
        save_button = (Button) findViewById(R.id.saveButton);
        read_button = (Button) findViewById(R.id.readbutton);
        filecontent = (TextView) findViewById(R.id.tvcontent);

    }

    public void SaveFileandContent(View view) throws IOException {
        String filename = f_name.getText().toString();
        String filecontent = f_content.getText().toString();

        if (TextUtils.isEmpty(filename)  && TextUtils.isEmpty(filecontent)){
            Toast.makeText(this,"Plese Enter Both Values",Toast.LENGTH_SHORT).show();
            return;
        } else {

            FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(filecontent.getBytes());
            fos.close();

        }

    }

    public void ReadFileContent(View view) {

        try {
            FileInputStream fis = openFileInput(f_name.getText().toString());
            StringBuilder stringBuffer = new StringBuilder();
            int readByte;
            while ((readByte = fis.read()) != -1){
                stringBuffer.append((char) readByte);

            }
            fis.close();
            filecontent.setText(stringBuffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
