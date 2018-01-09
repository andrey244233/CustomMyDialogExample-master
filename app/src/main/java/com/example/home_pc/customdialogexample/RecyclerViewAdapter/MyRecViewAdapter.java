package com.example.home_pc.customdialogexample.RecyclerViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.home_pc.customdialogexample.Cat;
import com.example.home_pc.customdialogexample.R;

import java.util.ArrayList;

public class MyRecViewAdapter extends RecyclerView.Adapter<MyRecViewAdapter.CatViewHolder > {

    private Context mContext;
    private ArrayList<Cat> cats;
    private TextView tvText;

    public MyRecViewAdapter(Context context, ArrayList<Cat> cats) {
        mContext = context;
        this.cats = cats;
    }


    @Override
    public CatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_icon, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CatViewHolder holder, int position) {
        Cat currentCat = cats.get(position);
        tvText.setText(currentCat.getName());
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {



        public CatViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.rec_text);
        }
    }


}
