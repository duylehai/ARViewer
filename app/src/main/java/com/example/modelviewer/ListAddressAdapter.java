package com.example.modelviewer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAddressAdapter extends RecyclerView.Adapter<ListAddressAdapter.ParkViewHolder> {
    Context context;
    ArrayList<ListAddress> listAddresses;

    public ListAddressAdapter(Context context, ArrayList<ListAddress> listAddresses) {
        this.context = context;
        this.listAddresses = listAddresses;
    }

    @NonNull
    @Override
    public ListAddressAdapter.ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listofparks, parent, false);
        return new ListAddressAdapter.ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAddressAdapter.ParkViewHolder holder, int position) {
        holder.ParkName.setText(listAddresses.get(position).getName());
        holder.ParkAddress.setText(listAddresses.get(position).getAddress());

        holder.longtitude = listAddresses.get(position).getLongtitude();
        holder.latitude = listAddresses.get(position).getLatitude();
        Log.d("longtitude", holder.longtitude.toString());
        Glide.with(context).load(listAddresses.get(position).getImageResource()).into(holder.ParkImg);


    }

    @Override
    public int getItemCount() {
        return listAddresses.size();
    }

    public class ParkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView ParkName;
        TextView ParkAddress;

        ImageView ParkImg;
        Float longtitude;
        Float latitude;
        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);
            ParkImg = itemView.findViewById(R.id.ParkImage);
            ParkName = itemView.findViewById(R.id.Title);
            ParkAddress = itemView.findViewById(R.id.Address);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle extras = new Bundle();
            extras.putFloat("Longtitude", longtitude);
            extras.putFloat("Latitude", latitude);
            Log.d("longtitude", longtitude.toString());

            Intent intent = new Intent(view.getContext(), MapsActivity.class);
            intent.putExtras(extras);

            view.getContext().startActivity(intent);
        }
    }
}
