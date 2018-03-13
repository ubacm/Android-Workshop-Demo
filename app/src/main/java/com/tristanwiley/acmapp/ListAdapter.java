package com.tristanwiley.acmapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<String> items;

    // When you create a new ListAdapter and pass in a List, set it to this ListAdapter
    ListAdapter(ArrayList<String> brands) {
        this.items = brands;
    }

    // Here we're going to inflate the layout list_item into this RecyclerView's items
    // We return a new ViewHolder passing in this inflated view.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    // When the ViewHolder is bound, pass in the item at position
    // to holder's bind method
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView companyName;
        View v;

        ViewHolder(View view) {
            super(view);

            // Set the view here so we can use it in bind
            v = view;

            // Get the TextView from the passed in view
            companyName = view.findViewById(R.id.brand_name);

            // Want to have something happen when you click on the view?
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // You can do things when you click on the view here!

                    // A toast is a kind of text notification that can show in your view
                    // We use getAdapterPosition to get the current item that was clicked
                    Toast.makeText(v.getContext(), items.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                }
            });
        }

        // We'll take the String from onBindViewHolder here,
        // This can also be an Object or any other type
        void bind(String text) {
            // Set the text to the companyName TextView
            companyName.setText(text);
        }
    }
}
