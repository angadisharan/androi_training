package com.mathrusoft.teacher.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mathrusoft.teacher.R;
import com.mathrusoft.teacher.model.Status;

import java.util.List;

/**
 * Created by sharanangadi on 09/11/16.
 */

public class AdapterDemo extends ArrayAdapter<Status> {

    List<Status> mStatuses;
    Context mContext;

    public AdapterDemo(Context context, int resource, List<Status> objects) {
        super(context, resource, objects);
        mStatuses = objects;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mStatuses.size();
    }

    @Nullable
    @Override
    public Status getItem(int position) {
        return mStatuses.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_status, null);
        }
        Status status = mStatuses.get(position);

        ((TextView) convertView.findViewById(R.id.name)).setText(status.getName());
        ((TextView) convertView.findViewById(R.id.status)).setText(status.getStatus());
        ((TextView) convertView.findViewById(R.id.last_seen)).setText(status.getLastSeen());

        return convertView;
    }


}
