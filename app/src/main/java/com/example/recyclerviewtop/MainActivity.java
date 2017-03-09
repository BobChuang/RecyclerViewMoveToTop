package com.example.recyclerviewtop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            dataList.add(i + "******" + i);
        }
        RecyclerAdapter adp = new RecyclerAdapter(this, dataList);
        adp.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                smoothMoveToPosition(position);
            }
        });
        recyclerView.setAdapter(adp);
    }

    /**
     * 滚动方法
     */
    private void smoothMoveToPosition(int position) {
        int firstPosition = layoutManager.findFirstVisibleItemPosition();
        int lastPosition = layoutManager.findLastVisibleItemPosition();
        if (position <= lastPosition) {
            int top = recyclerView.getChildAt(position - firstPosition).getTop();
            recyclerView.smoothScrollBy(0, top);
        }
    }
}
