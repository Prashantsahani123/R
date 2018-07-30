package com.SampleApp.row.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.SampleApp.row.Data.RotaryLibraryData;
import com.SampleApp.row.R;
import com.SampleApp.row.RotaryLibraryDescription;
import com.SampleApp.row.holders.EmptyViewHolder;
import com.SampleApp.row.holders.RotaryLibraryListHolder;

import java.util.ArrayList;

/**
 * Created by admin on 22-05-2017.
 */

public class RotaryLibraryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<RotaryLibraryData> list;
    private static final int View_TYPE_EMPTYLIST = 1 ;
    private static final int View_TYPE_ROTARY_LIBRARY_LIST = 2 ;


    public RotaryLibraryListAdapter(Context context, ArrayList<RotaryLibraryData> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType== View_TYPE_EMPTYLIST){
            View v = LayoutInflater.from(context).inflate(R.layout.empty_calendar_recyclerview,parent,false);
            Log.d("♦♦♦♦ ","Inside View_TYPE_EMPTYLIST ");
            return new EmptyViewHolder(v);
        }else if(viewType== View_TYPE_ROTARY_LIBRARY_LIST){
            View  v = LayoutInflater.from(context).inflate(R.layout.holder_rotary_librarylist,parent,false);
            RotaryLibraryListHolder holder = new RotaryLibraryListHolder(v);
            Log.d("♦♦♦♦ ","Inside View_TYPE_ROTARY_LIBRARY_LIST ");
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == View_TYPE_EMPTYLIST) {
            bindEmptyView(holder, position);
        } else {
            bindNonEmptyView(holder, position);
        }
    }

    public void bindEmptyView(RecyclerView.ViewHolder holder, final int position) {
        ((EmptyViewHolder) holder).getEmptyView().setText("No records found");
    }

    public void bindNonEmptyView(RecyclerView.ViewHolder holder, final int position) {

        RotaryLibraryListHolder hol = (RotaryLibraryListHolder) holder;
        hol.tv_title.setText(list.get(position).getTitle());

        hol.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, RotaryLibraryDescription.class);
                i.putExtra("title", list.get(position).getTitle());
                i.putExtra("description", list.get(position).getDescription());
                i.putExtra("modulename", list.get(position).getModuleName());

                context.startActivity(i);
            }
        });


    }


    @Override
    public int getItemViewType(int position) {
        if(list.size()==0){
            return View_TYPE_EMPTYLIST;
        }else{
            return View_TYPE_ROTARY_LIBRARY_LIST;
        }
    }

    @Override
    public int getItemCount() {

        if(list.size()==0){
            return  View_TYPE_EMPTYLIST;
        }
        return list.size();
    }
}
