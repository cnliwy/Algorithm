package com.liwy.algorithm.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.liwy.algorithm.R;

import java.util.List;

/**
 * Created by liwy on 2017/8/30.
 */

public class MenuAdapter extends RecyclerView.Adapter {
    List<String> list;
    Context context;
    private OnItemClickListener onItemClickListener;

    public MenuAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);
        MyHolder myHolder = new MyHolder(itemView);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder = (MyHolder)holder;
        Button btn = (Button)myHolder.getView(R.id.btn_menu);
        btn.setText(list.get(position));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        if (list == null)return 0;
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(View itemView) {
            super(itemView);
        }

        public View getView(int rid){
            return itemView.findViewById(rid);
        }
    }
    public interface OnItemClickListener{
        public void onItemClick(int position);
    }
}
