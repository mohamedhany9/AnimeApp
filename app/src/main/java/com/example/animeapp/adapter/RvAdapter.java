package com.example.animeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.animeapp.R;
import com.example.animeapp.activities.AnimeActivity;
import com.example.animeapp.model.Anime;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    RequestOptions options ;
    private Context mContext ;
    private List<Anime> mData ;


    public RvAdapter(Context mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.anime_item_row,parent,false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);

        myViewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, AnimeActivity.class);
                i.putExtra("anime_name", mData.get(myViewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description", mData.get(myViewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio", mData.get(myViewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category", mData.get(myViewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode", mData.get(myViewHolder.getAdapterPosition()).getEpisode());
                i.putExtra("anime_rating", mData.get(myViewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_img", mData.get(myViewHolder.getAdapterPosition()).getImg());

                mContext.startActivity(i);

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tvname.setText(mData.get(position).getName());
        holder.tv_rate.setText(mData.get(position).getRating());
        holder.tvstudio.setText(mData.get(position).getStudio());
        holder.tvcat.setText(mData.get(position).getCategorie());

        // load image from the internet using Glide
        Glide.with(mContext)
                .load(mData.get(position).getImg())
                .apply(options)
                .into(holder.AnimeThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvname,tv_rate,tvstudio,tvcat;
        ImageView AnimeThumbnail;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            tvname = itemView.findViewById(R.id.rowname);
            tvstudio = itemView.findViewById(R.id.studio);
            tv_rate = itemView.findViewById(R.id.rating);
            tvcat = itemView.findViewById(R.id.categorie);
            AnimeThumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }


}