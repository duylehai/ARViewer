package com.example.modelviewer;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;

import com.example.modelviewer.AnimalData;
import com.google.gson.Gson;

public class AnimalsListAdapter extends BaseAdapter {
    Context contex;
    AnimalData[] animalData;

    LayoutInflater inflater;

    public AnimalsListAdapter(Context contex, AnimalData[] animalDataSrc) {
        this.contex = contex;
        this.animalData = animalDataSrc;
    }

    @Override
    public int getCount() {
        return animalData.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int id, View convertView, ViewGroup viewGroup) {
        if ( inflater == null) {
            inflater = (LayoutInflater) contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.animal_item, null);
        }
        ImageView imageView = convertView.findViewById(R.id.animal_item_image);
        TextView textView = convertView.findViewById(R.id.animal_item_name);
        TextView intro = convertView.findViewById(R.id.animal_item_intro);

        textView.setText(this.animalData[id].name);
        int resourceId = contex.getApplicationContext().getResources().getIdentifier(this.animalData[id].img, "drawable", contex.getApplicationContext().getPackageName());
        Log.d("lmaooo",Integer.toString(resourceId));
        imageView.setImageResource(resourceId);
        intro.setText(this.animalData[id].intro);

        convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AnimalDetail.class);
                Gson gson = new Gson();
                Log.d("item id",Integer.toString(id));
                String data = gson.toJson(animalData[id]);
                Log.d("data",data);
                intent.putExtra("animalData", data);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contex.startActivity(intent);
            }
        });
        return convertView;
    }
}
