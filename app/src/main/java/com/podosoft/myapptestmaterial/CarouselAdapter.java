package com.podosoft.myapptestmaterial;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselViewHolder>{
    List<Drawable> imageList;
    Context context;

    public CarouselAdapter(List<Drawable> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarouselViewHolder(LayoutInflater.from(context).inflate(R.layout.material_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {

        holder.imageView.setImageDrawable(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}
class CarouselViewHolder extends RecyclerView.ViewHolder{
    MaterialCardView materialCardView;
    ImageView imageView;

    public CarouselViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
    }
}