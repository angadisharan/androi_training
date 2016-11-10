package com.mathrusoft.teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 09/11/16.
 */


/**
 * Created by sharanangadi on 09/11/16.
 */

public class ActivityRecyclerView extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_demo);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        List<String> strings = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            strings.add(" Name " + i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(strings));


    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

        List<String> strings;

        public MyAdapter(List<String> strings) {
            this.strings = strings;
        }

        @Override
        public MyAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

            Log.d("MASS", "=========== inside onCreate View Holder" );

            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demo, parent, false));
        }

        @Override
        public void onBindViewHolder(MyAdapter.Holder holder, int position) {
            Log.d("TAG", " holder " + holder);
            Log.d("TAG", " holder " + holder.textView);



            holder.textView.setText(strings.get(holder.getAdapterPosition()));
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }

        class Holder extends RecyclerView.ViewHolder {

            public TextView textView;

            public Holder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.text);
            }

        }
    }


}
