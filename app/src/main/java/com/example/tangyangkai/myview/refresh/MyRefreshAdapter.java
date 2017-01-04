package com.example.tangyangkai.myview.refresh;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by tangyangkai on 2017/1/4.
 */

public class MyRefreshAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private RecyclerView.Adapter adapter;


    public MyRefreshAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return adapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        adapter.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return adapter.getItemCount();
    }
}
