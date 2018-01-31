package com.teejay.activityfragmentmvp.ui.main.adapters;

/**
 * Created by tjaved on 1/28/18.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Artist;

import java.util.ArrayList;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder> {

    ArrayList<Artist> mArtists;

    @Override
    public ArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);
        return new ArtistsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArtistsViewHolder holder, int position) {
        Artist artist = mArtists.get(position);
        holder.tvTitle.setText(artist.getName());
        holder.tvAlbumCount.setText(artist.getAlbumCount());
        holder.ivThumb.setBackgroundResource(R.drawable.default_album);
    }

    @Override
    public int getItemCount() {
        return mArtists.size();
    }

    class ArtistsViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    TextView tvAlbumCount;
    ImageView ivThumb;



    public ArtistsViewHolder(View itemView) {
        super(itemView);
        tvTitle=(TextView) itemView.findViewById(R.id.artist_title);
        tvAlbumCount =(TextView) itemView.findViewById(R.id.artist_count);
        

    }
}
}
