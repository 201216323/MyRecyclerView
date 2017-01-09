package com.example.tangyangkai.recyclerview.refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tangyangkai on 2017/1/4.
 */

public class MyCustomRecyclerView extends RecyclerView {

    private MyCustomAdapter myCustomAdapter;
    private View headerView, footerView;
    private MyCustomListener myCustomListener;
    private boolean isLoadMore;
    private TextView refreshTxt, loadTxt;
    private CircleProgressView progressView, circleProgressView;


    public void setMyCustomListener(MyCustomListener myCustomListener) {
        this.myCustomListener = myCustomListener;
    }

    public MyCustomRecyclerView(Context context) {
        super(context);
        init();
    }

    public MyCustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCustomRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    private void init() {
        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //停止滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示Item的Position
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();
                    // 判断是否滚动到底部，并且不在加载状态
                    if (lastVisibleItem == (totalItemCount - 1) && !isLoadMore) {
                        isLoadMore = true;
                        loadTxt.setText("正在加载...");
                        circleProgressView.setVisibility(VISIBLE);
                        footerView.setVisibility(VISIBLE);
                        myCustomListener.onLoadMore();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void setAdapter(Adapter adapter) {
        LinearLayout headerLayout = new LinearLayout(getContext());
        headerLayout.setGravity(Gravity.CENTER);
        headerLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dip2px(getContext(), 60)));

        progressView = new CircleProgressView(getContext());
        progressView.setLayoutParams(new LinearLayout.LayoutParams(80, 80));
        progressView.startAnimation();
        headerLayout.addView(progressView);
        refreshTxt = new TextView(getContext());
        refreshTxt.setText("正在刷新");
        headerLayout.addView(refreshTxt);
        headerView = headerLayout;

        LinearLayout footerLayout = new LinearLayout(getContext());
        footerLayout.setGravity(Gravity.CENTER);
        footerLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 160));

        circleProgressView = new CircleProgressView(getContext());
        circleProgressView.setLayoutParams(new LinearLayout.LayoutParams(80, 80));
        circleProgressView.startAnimation();
        footerLayout.addView(circleProgressView);
        loadTxt = new TextView(getContext());
        footerLayout.addView(loadTxt);
        footerView = footerLayout;
        footerView.setVisibility(GONE);


        myCustomAdapter = new MyCustomAdapter(adapter, footerView, headerView);
        super.setAdapter(myCustomAdapter);
    }

    public interface MyCustomListener {
        void onLoadMore();
    }

    public void setLoadMore(boolean complete) {
        if (complete) {
            loadTxt.setText("已经全部加载完啦!");
            circleProgressView.setVisibility(GONE);
        } else {
            footerView.setVisibility(GONE);
        }
        isLoadMore = false;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
