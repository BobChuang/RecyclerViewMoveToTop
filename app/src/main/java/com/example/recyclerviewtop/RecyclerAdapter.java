package com.example.recyclerviewtop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bob on 2017/3/9.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.IViewHolder> {
    private OnRecyclerItemClickListener mItemClickListener;
    private Context mContext;
    private ArrayList<String> mList;

    public RecyclerAdapter(Context context, ArrayList<String> datalist) {
        this.mContext = context;
        this.mList = datalist;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {
        holder.tv.setText(mList.get(position));
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_m, parent, false), mItemClickListener);
    }

    /**
     * 定义一个方法传入点击监听
     */
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public class IViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnRecyclerItemClickListener mListener;
        TextView tv;

        public IViewHolder(View itemView, OnRecyclerItemClickListener listener) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.itemtv);
            this.mListener = listener;
            tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null)
                mListener.onItemClick(v, getLayoutPosition());
        }
    }
}