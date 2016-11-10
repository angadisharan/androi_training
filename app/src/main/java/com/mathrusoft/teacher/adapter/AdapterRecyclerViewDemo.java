package com.mathrusoft.teacher.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mathrusoft.teacher.R;
import com.mathrusoft.teacher.model.Status;

import java.util.List;

/**
 * Created by sharanangadi on 10/11/16.
 */

public class AdapterRecyclerViewDemo extends RecyclerView.Adapter<AdapterRecyclerViewDemo.Holder> {


    List<Status> mStatuses;

    public AdapterRecyclerViewDemo(List<Status> statuses) {
        mStatuses = statuses;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_status, parent, false);
        Holder holder = new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Log.d("MYAPP", " holder.getAdapterPosition() " + holder.getAdapterPosition());

        Status status = mStatuses.get(holder.getAdapterPosition());

        holder.name.setText(status.getName());
        holder.status.setText(status.getStatus());
        holder.lastSeen.setText(status.getLastSeen());
    }

    @Override
    public int getItemCount() {
        return mStatuses.size();
    }


    class Holder extends RecyclerView.ViewHolder {

        TextView name;
        TextView status;
        TextView lastSeen;


        public Holder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            status = (TextView) itemView.findViewById(R.id.status);
            lastSeen = (TextView) itemView.findViewById(R.id.last_seen);
        }
    }
}
