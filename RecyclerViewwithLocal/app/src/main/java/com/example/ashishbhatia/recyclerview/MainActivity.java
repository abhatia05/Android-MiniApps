package com.example.ashishbhatia.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter rva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.recyclerview);

        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));


        String[] newListItems = getResources().getStringArray(R.array.ItemNames);

        rva = new MyAdapter(this,newListItems);

        rv.setAdapter(rva);

    }
}
