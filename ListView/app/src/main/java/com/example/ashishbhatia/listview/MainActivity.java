package com.example.ashishbhatia.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define ListView
        final ListView lv = (ListView) findViewById(R.id.simpleListView);

        // String array to populate the values in the list.

        String[] values = new String[]{"Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };
        // Array adapter use to map values to the List View, simple_list_item_1,text 1 are internal representation of List.
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Set array adapter for the listView.
        lv.setAdapter(ad);

        // The below code will work on each item list.

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int itemPosition = i+ 1;
                String itemValue = (String) lv.getItemAtPosition(itemPosition);
               Toast.makeText(getApplicationContext(),"Position :"+itemPosition+ " List Item "+itemValue,Toast.LENGTH_SHORT).show();

            }

        });
    }
}
