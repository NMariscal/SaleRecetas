package com.example.salerecetas;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


import com.example.salerecetas.databinding.FragmentItemBinding;

import java.util.List;


public class MyRecetaRecyclerViewAdapter extends RecyclerView.Adapter<MyRecetaRecyclerViewAdapter.ViewHolder> {
    Context context;
    List<Receta> mValues;

    public MyRecetaRecyclerViewAdapter(List<Receta> mValues) {
        this.mValues = mValues;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNombreView.setText(mValues.get(position).getNombre());
        holder.mDuracionView.setText(mValues.get(position).getDuracion());

        Glide.with(context)
                .load(holder.mItem.getUrlFoto().toString())
                .centerCrop()
                .into(holder.imageViewPhotoReceta);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNombreView;
        public final TextView mDuracionView;
        public final ImageView imageViewPhotoReceta;
        public Receta mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNombreView = view.findViewById(R.id.item_nombre);
            mDuracionView = view.findViewById(R.id.duracion);
            imageViewPhotoReceta = view.findViewById(R.id.imageViewPhotoReceta);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Ver.class);
                    intent.putExtra("ID", mValues.get(getLayoutPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }



        @Override
        public String toString() {
            return super.toString() + " '" + mNombreView.getText() + "'";
        }
    }
}