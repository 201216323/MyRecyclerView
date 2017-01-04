package com.example.tangyangkai.myview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private List<Integer> integerList = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }

    private void init() {
        getData();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void getData() {
        integerList.clear();
        Random random = new Random();
        while (integerList.size() < 12) {
            int randomInt = random.nextInt(100);
            integerList.add(randomInt);
        }
    }


    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_refresh_recycler, parent, false);

            return new MyViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.txt.setText(String.valueOf(integerList.get(position)));
        }

        @Override
        public int getItemCount() {
            return integerList.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.item_txt);
        }
    }

}
