package com.example.tangyangkai.myview.refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by tangyangkai on 2017/1/4.
 */

public class MyRefreshRecyclerView extends RecyclerView {
    public MyRefreshRecyclerView(Context context) {
        super(context);
    }

    public MyRefreshRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRefreshRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        MyRefreshAdapter myRefreshAdapter = new MyRefreshAdapter(adapter);
        super.setAdapter(myRefreshAdapter);
    }



}
