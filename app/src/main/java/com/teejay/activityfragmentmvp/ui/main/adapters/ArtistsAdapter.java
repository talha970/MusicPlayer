package com.teejay.activityfragmentmvp.ui.main.adapters;

/**
 * Created by tjaved on 1/28/18.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Artist;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder> {

    List<Artist> mArtists;

    @Inject
    public ArtistsAdapter() {
        this.mArtists = new ArrayList<>();
    }

    public void setmArtists(List<Artist> mArtists) {
        this.mArtists = mArtists;
    }

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
        holder.tvAlbumCount.setText(String.valueOf(artist.getAlbumCount()));
        Context context=holder.ivThumb.getContext();
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(holder.ivThumb);

    }

    @Override
    public int getItemCount() {
        return mArtists.size();
    }

    class ArtistsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.artist_title) TextView tvTitle;
        @BindView(R.id.album_count)TextView tvAlbumCount;
        @BindView(R.id.artist_thumbnail)ImageView ivThumb;



    public ArtistsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        

    }
}
}
