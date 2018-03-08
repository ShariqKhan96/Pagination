package com.example.hp.pagination;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 3/8/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyAdapter> {

    private ArrayList<String> arrayList = new ArrayList<>();

    public Adapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Adapter.MyAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyAdapter holder, int position) {
        String string = arrayList.get(position);
        holder.textview.setText(string);

    }

    @Override
    public int getItemCount() {
        Log.e("size", String.valueOf(arrayList.size()));
        return arrayList.size();

    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView textview;

        public MyAdapter(View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.textView);
        }
    }
}
