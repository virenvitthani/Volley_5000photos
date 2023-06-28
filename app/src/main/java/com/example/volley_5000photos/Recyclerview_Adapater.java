package com.example.volley_5000photos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recyclerview_Adapater extends RecyclerView.Adapter<Recyclerview_Adapater.RecyclerviewHolder> {

    MainActivity mainActivity;
    ArrayList<DataModel> list;

    public Recyclerview_Adapater(MainActivity mainActivity, ArrayList<DataModel> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public Recyclerview_Adapater.RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview_item,parent,false);
        RecyclerviewHolder holder = new RecyclerviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.id.setText(""+list.get(position).getId());
        holder.titel.setText(list.get(position).getTitel());
        holder.albumID.setText(""+list.get(position).getAlbumId());

        Picasso.get().load(list.get(position).getUrl())
                .placeholder(R.drawable.animation)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView id,titel,albumID;
        ImageView imageView;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            titel = itemView.findViewById(R.id.title);
            albumID = itemView.findViewById(R.id.albumId);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
