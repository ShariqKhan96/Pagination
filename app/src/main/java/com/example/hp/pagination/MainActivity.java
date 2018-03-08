package com.example.hp.pagination;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> arrayList = new ArrayList<>();
    boolean isScrolling = false;
    LinearLayoutManager layoutManager;
    int currentitem, scrolloutItem, totalItem;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateList();
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        //   recyclerView.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(arrayList);

        recyclerView.setAdapter(adapter);


        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    isScrolling = true;

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentitem = recyclerView.getLayoutManager().getChildCount();
                scrolloutItem = layoutManager.findFirstVisibleItemPosition();
                totalItem = layoutManager.getItemCount();

                if (isScrolling && (currentitem + scrolloutItem >= totalItem)) {
                    isScrolling = false;
                    loadMore();


                }

            }
        });

    }

    private void loadMore() {

        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {

                    arrayList.add(String.valueOf(Math.random()));
                    adapter.notifyDataSetChanged();
                }
                progressBar.setVisibility(View.GONE);
            }
        }, 3000);


    }

    private void generateList() {
        for (int i = 0; i < 15; i++) {
            arrayList.add(String.valueOf(Math.random()));

        }
    }
}
