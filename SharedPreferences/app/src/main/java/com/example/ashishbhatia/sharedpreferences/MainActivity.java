package com.example.ashishbhatia.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "Last Word";
    private static final String KEY_WORD = "KEY_WORD";
    SharedPreferences spref;
    EditText valueprefered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spref = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        valueprefered = (EditText) findViewById(R.id.etedittext);
    }

    public void ReadSharedPreference(View view) {

        Toast.makeText(this,spref.getString(KEY_WORD,"No word Jet"),Toast.LENGTH_SHORT).show();
    }

    public void savesharedpreference(View view) {

        SharedPreferences.Editor editor = spref.edit();
        editor.putString(KEY_WORD,valueprefered.getText().toString());
        editor.commit();

    }
}
