package com.boteteam.yper.yyxy.Teacher.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boteteam.yper.yyxy.R;
import com.boteteam.yper.yyxy.SchoolModule.Assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feng Jiang on 2017/10/7.
 */

public class TeaMainListAssignmentAdapter extends RecyclerView.Adapter {
    List<Assignment> assignments=new ArrayList<>();
    Context mycontext;
    LayoutInflater inflater;

    public TeaMainListAssignmentAdapter(List<Assignment> assignments, Context mycontext) {
        this.assignments = assignments;
        this.mycontext = mycontext;
        inflater=LayoutInflater.from(mycontext);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem_main_assignbz,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).txt_tea_main_item_bj.setText(assignments.get(position).getBjname());


    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_tea_main_item_bj;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_tea_main_item_bj=itemView.findViewById(R.id.tea_main_item_bj);
        }
    }
}
