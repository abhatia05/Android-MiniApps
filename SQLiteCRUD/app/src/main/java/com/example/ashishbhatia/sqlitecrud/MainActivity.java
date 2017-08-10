package com.example.ashishbhatia.sqlitecrud;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,number;
    Button save,read,update;

    DBHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.etname);
        number = (EditText) findViewById(R.id.etnum);

        save = (Button) findViewById(R.id.savebtn);
        read = (Button) findViewById(R.id.findbtn);
        update = (Button) findViewById(R.id.updbtn);

        myHelper = new DBHelper(this);


    }

    public void findbtn(View view) {
        String num = myHelper.findNumberFromName(name.getText().toString());
        Toast.makeText(this,"NUmber is " + num, Toast.LENGTH_SHORT).show();

    }

    public void savebutton(View view) {
        myHelper.addnameandnumber(name.getText().toString(),number.getText().toString());
        Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show();
    }

    public void updatebutton(View view){

        //Toast.makeText(this,"New Number is" + number.getText().toString(),Toast.LENGTH_SHORT).show();
        String num= myHelper.findNumberFromName(name.getText().toString());
        if (num != null){
            myHelper.updatenumber(name.getText().toString(),number.getText().toString());

            Toast.makeText(this,name.getText().toString() +" is successfully updated in db",Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"New Number is" + number.getText().toString(),Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,name.getText().toString() +" is not avilable in db",Toast.LENGTH_SHORT).show();
        }

    }

    public void deletebutton(View view) {

 //       String num= myHelper.findNumberFromName(name.getText().toString());
 //       if (num != null){
            myHelper.deleteentry(name.getText().toString(),number.getText().toString());
            Toast.makeText(this,name.getText().toString() +" is successfully deleted in db",Toast.LENGTH_SHORT).show();

  //      } else {
  //          Toast.makeText(this,name.getText().toString() +" is not available in db",Toast.LENGTH_SHORT).show();
 //       }

    }
}
