package com.example.aplikasiantrianklinik;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ListDokterAdapter extends RecyclerView.Adapter<ListDokterAdapter.ListViewHolder> {

    private ArrayList<Dokter> listDokter;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Dokter data);
    }

    //constructor list dokter
    public ListDokterAdapter(ArrayList<Dokter> listDokter) {
        this.listDokter = listDokter;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_dokter, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        //position menunjukan index / posisi item dalam arraylist
        Dokter currentItem = listDokter.get(position);
        holder.tvNama.setText(currentItem.getNama());
        holder.imgFoto.setImageResource(currentItem.getFoto());

        holder.btnKonsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listDokter.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listDokter.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        //inisialisasi view yang ada di dalam layout item_list_dokter
        ImageView imgFoto;
        TextView tvNama;
        MaterialButton btnKonsul;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.item_foto_dokter);
            tvNama = itemView.findViewById(R.id.item_nama_dokter);
            btnKonsul = itemView.findViewById(R.id.btn_daftar_konsul);

        }
    }
}
