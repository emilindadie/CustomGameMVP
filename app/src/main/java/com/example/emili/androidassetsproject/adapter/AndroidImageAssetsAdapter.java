package com.example.emili.androidassetsproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.emili.androidassetsproject.R;

import java.util.List;

/**
 * Created by emili on 08/09/2017.
 */


public class AndroidImageAssetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    LayoutInflater layoutInflater;
    List<Integer> assets;
    int taille;

    RecyclerItemClickListener recyclerItemClickListener;


    public AndroidImageAssetsAdapter(Context context, List<Integer> assets, RecyclerItemClickListener recyclerItemClickListener){
        this.context = context;
        this.assets = assets;
        this.recyclerItemClickListener = recyclerItemClickListener;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.single_list, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Integer integer = assets.get(position);
        MyHolder myHolder = (MyHolder) holder;
        myHolder.imageView.setImageResource(integer);
        ((MyHolder) holder).bind(integer, recyclerItemClickListener);
    }

    @Override
    public int getItemCount() {
        taille = assets.size();
        return taille;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewBodyPart);
        }
        private void bind(final Integer integer, final RecyclerItemClickListener recyclerItemClickListener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerItemClickListener.OnClickListener(integer, getLayoutPosition());
                }
            });
        }
    }

    public void setData(List<Integer> assets){
        this.assets = assets;
    }


    public interface RecyclerItemClickListener{
        void OnClickListener(Integer integer, int position);
    }
}
