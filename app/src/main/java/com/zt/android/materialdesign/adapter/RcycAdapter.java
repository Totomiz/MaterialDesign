package com.zt.android.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zt.android.materialdesign.R;

import java.util.List;

/**
 * Created by Tony on 16/10/27.
 */

public class RcycAdapter extends RecyclerView.Adapter<RcycAdapter.Holder> {
    private List<String> mData;
    private LayoutInflater inflater;

    public RcycAdapter(Context context, List<String> data){

       inflater=LayoutInflater.from(context);
        this.mData=data;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rcyc_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.textView.setText(mData.get(position));
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        private TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textView);

        }
    }
}
