package com.example.ashishbhatia.clickpicture;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private static final int CONTEXT_REQUEST = 123;
    private File output = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

        output = new File(dir,"Image.jpg");

        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));

        startActivityForResult(i,CONTEXT_REQUEST);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CONTEXT_REQUEST){
            if(resultCode == RESULT_OK){
                Intent i = new Intent(Intent.ACTION_VIEW);

                i.setDataAndType(Uri.fromFile(output),"image/jpeg");

                startActivity(i);
                finish();
            }
        }
    }
}
