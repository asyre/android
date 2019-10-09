package ru.ifmo.lab3_derbenyova;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ImageHolder> {

    private final List<Image> images;

    public ListAdapter(List<Image> images) {
        this.images = images;
    }

    static class ImageHolder extends RecyclerView.ViewHolder {

        final ImageView image;

        ImageHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.im);
        }
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.image, parent, false);
        final MediaPlayer mp = MediaPlayer.create(inflater.getContext(), R.raw.sound);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mp.start();

            }

        });
        return new ImageHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        Picasso.get().load(images.get(position).getImageUrl()).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return images.size();
    }
}
