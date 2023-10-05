package com.example.quoteoftheday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private Context context;
    private ArrayList quote;

    public CustomAdapter(Context context, ArrayList quotes) {
        this.context = context;
        this.quote = quotes;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.quotes,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.quotess.setText(String.valueOf(quote.get(position)));
    }

    @Override
    public int getItemCount() {
        return quote.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView quotess;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quotess = itemView.findViewById(R.id.textView3);
        }
    }
}
