package com.example.ashishbhatia.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ashishbhatia on 08/08/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {



    private Context ctx;
    //private List<ListItem> listitems;
    private String[] listitems;

    public MyAdapter(Context ctx, String[] listitems) {
        this.ctx = ctx;
        this.listitems = listitems;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
     }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String listItem = listitems[position];

        holder.heading.setText(listItem);
        holder.description.setText(listItem);

    }

    @Override
    public int getItemCount() {
        return listitems.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView heading,description;


        public ViewHolder(View itemView) {
            super(itemView);

            heading = (TextView) itemView.findViewById(R.id.head);
            description = (TextView) itemView.findViewById(R.id.desc);

        }
    }
}
