package com.example.retrofit2assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ResponseAdaptor extends RecyclerView.Adapter<ResponseViewHolder> {
    private List<DataModel> modelList;
    public ResponseAdaptor(List<DataModel> modelList){
        this.modelList=modelList;
    }

    @NonNull
    @NotNull
    @Override
    public ResponseViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ResponseViewHolder holder, int position) {
        DataModel model=modelList.get(position);
        holder.setData(model);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
