package com.example.retrofitpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userHolder> {
    MainActivity mainActivity;
    List<userModel> alluserList;
    public userAdapter(MainActivity mainActivity, List<userModel> alluserList) {
        this.mainActivity=mainActivity;
        this.alluserList=alluserList;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.row_item,parent,false));
    }

    @Override




    public void onBindViewHolder(@NonNull userHolder holder, int position) {
        holder.textView.setText(alluserList.get(position).title);
        Picasso.get().load("https://picsum.photos/200/300").error(R.drawable.adventures_finn).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return alluserList.size();
    }

    class userHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView img;
        public userHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}
