package com.SampleApp.row.holders;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.SampleApp.row.R;

/**
 * Created by admin on 25-04-2017.
 */

public class RotarianListHolder extends RecyclerView.ViewHolder {
     public TextView tv_name,tv_designation,tv_clubname;
     public ImageView iv_image;
     public LinearLayout linear;
    public RotarianListHolder(View v){
        super(v);

        tv_name = (TextView)v.findViewById(R.id.tv_name);
        tv_designation = (TextView)v.findViewById(R.id.tv_designation);
        tv_clubname = (TextView)v.findViewById(R.id.tv_clubname);
        iv_image = (ImageView)v.findViewById(R.id.imageView);
        linear = (LinearLayout)v.findViewById(R.id.linear);
    }
}
