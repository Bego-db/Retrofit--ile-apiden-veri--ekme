package com.example.mobilfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.RowHolder> {


     private ArrayList<Calisanlar> calisanliste;

    public rvAdapter(ArrayList<Calisanlar> calisanliste) {
        this.calisanliste = calisanliste;
    }

    @NonNull
    @Override
    public rvAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater lytinfluter = LayoutInflater.from(parent.getContext());
        View viev = lytinfluter.inflate(R.layout.rctasarim,parent,false);

        return new RowHolder(viev);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapter.RowHolder holder, int position) {
     holder.bind(calisanliste.get(position),position);
    }

    @Override
    public int getItemCount() {
        return calisanliste.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView title,description,link,date_time;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind( Calisanlar calisanlar, int position) {
            title=itemView.findViewById(R.id.txt_baslik);
            description=itemView.findViewById(R.id.txt_tanim);

            date_time=itemView.findViewById(R.id.txt_tarih);
            title.setText(calisanlar.calisan_ID);
            description.setText(calisanlar.calisan_Ad);

            date_time.setText(calisanlar.calisan_Yas);
        }
    }
}
