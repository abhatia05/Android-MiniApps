package com.example.ashishbhatia.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter rva;

    private List<ListItem> listitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.recyclerview);

        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        listitems = new ArrayList<>();

        int i;
        for  (i = 0;i <10; i++){
            ListItem listitem = new ListItem(
                "Heading" + i ,
                "DUmmy text"
                        );

            listitems.add(listitem);

        }
        rva = new MyAdapter(this,listitems);

        rv.setAdapter(rva);

    }
}
