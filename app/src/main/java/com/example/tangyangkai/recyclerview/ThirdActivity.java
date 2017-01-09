package com.example.tangyangkai.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tangyangkai.recyclerview.refresh.MyCustomRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThirdActivity extends AppCompatActivity {

    private MyCustomRecyclerView recyclerView;
    private List<String> integerList = new ArrayList<>();
    private MyThirdAdapter myThirdAdapter;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        init();
    }

    private void init() {

        recyclerView = (MyCustomRecyclerView) findViewById(R.id.recycler);
        myThirdAdapter = new MyThirdAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getData();
        recyclerView.setAdapter(myThirdAdapter);
        myThirdAdapter.notifyDataSetChanged();


        recyclerView.setMyCustomListener(new MyCustomRecyclerView.MyCustomListener() {
            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (integerList.size() > 14) {
                            recyclerView.setLoadMore(true);
                        } else {
                            int randomInt = new Random().nextInt(100);
                            integerList.add("上拉加载添加数字:" + randomInt);
                            myThirdAdapter.notifyDataSetChanged();
                            recyclerView.setLoadMore(false);
                        }

                    }
                }, 1000);
            }
        });
    }


    private void getData() {
        integerList.clear();
        Random random = new Random();
        while (integerList.size() < 12) {
            int randomInt = random.nextInt(100);
            integerList.add(String.valueOf(randomInt));
        }
    }

    public class MyThirdAdapter extends RecyclerView.Adapter<MyThirdViewHolder> {


        @Override
        public MyThirdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_refresh_recycler, parent, false);

            return new MyThirdViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(MyThirdViewHolder holder, int position) {
            holder.txt.setText(integerList.get(position));
        }

        @Override
        public int getItemCount() {
            return integerList.size();
        }
    }

    public class MyThirdViewHolder extends RecyclerView.ViewHolder {
        TextView txt;

        public MyThirdViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.item_txt);
        }
    }
}
