package com.example.tangyangkai.recyclerview.refresh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tangyangkai on 2017/1/4.
 */

public class MyCustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private View headerView, footerView;
    public static final int HEADER_VIEW_TYPE = 1;
    public static final int FOOTER_VIEW_TYPE = 2;

    public MyCustomAdapter(RecyclerView.Adapter adapter, View footerView, View headerView) {
        this.adapter = adapter;
        this.footerView = footerView;
        this.headerView = headerView;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return FOOTER_VIEW_TYPE;
        } else if (position == 0) {
            return HEADER_VIEW_TYPE;
        } else {
            return adapter.getItemViewType(position);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FOOTER_VIEW_TYPE) {
            return new RecyclerView.ViewHolder(footerView) {
            };
        } else if (viewType == HEADER_VIEW_TYPE) {
            return new RecyclerView.ViewHolder(headerView) {
            };
        } else {
            return adapter.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            return;
        }
        int p = position - 1;
        if (p < adapter.getItemCount()) {
            adapter.onBindViewHolder(holder, p);
        }
    }

    @Override
    public int getItemCount() {
        return adapter.getItemCount() + 2;
    }
}
