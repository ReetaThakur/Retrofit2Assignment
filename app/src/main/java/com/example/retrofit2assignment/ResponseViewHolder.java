package com.example.retrofit2assignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class ResponseViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView author;
    private TextView content;
    private TextView date;
    private TextView time;
    private TextView title;
    public ResponseViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.image);
        author=itemView.findViewById(R.id.author);
        content=itemView.findViewById(R.id.content);
        date=itemView.findViewById(R.id.date);
        time=itemView.findViewById(R.id.time);
        title=itemView.findViewById(R.id.title);
    }
    public void setData(DataModel model){
        Glide.with(imageView).load(model.getImageUrl()).into(imageView);
        author.setText(model.getAuthor());
        content.setText(model.getContent());
        date.setText(model.getDate());
        time.setText(model.getTime());
        title.setText(model.getTitle());

    }
}
