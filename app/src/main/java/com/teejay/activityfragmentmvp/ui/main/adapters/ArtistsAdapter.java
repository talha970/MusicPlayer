package com.teejay.activityfragmentmvp.ui.main.adapters;

/**
 * Created by tjaved on 1/28/18.
 */
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Artist;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.BaseViewHolder;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.GenericRecycleAdapter;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.OnRecycleObjectClickListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistsAdapter extends GenericRecycleAdapter<Artist,
        OnRecycleObjectClickListener<Artist>,ArtistsAdapter.ArtistsViewHolder> {

    @Inject
    public ArtistsAdapter(Context context) {
        super(context);
    }

    @Override
    public ArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);
        return new ArtistsViewHolder(itemView);
    }


    class ArtistsViewHolder extends BaseViewHolder<Artist, OnRecycleObjectClickListener<Artist>> {
        @BindView(R.id.artist_title) TextView tvTitle;
        @BindView(R.id.album_count)TextView tvAlbumCount;
        @BindView(R.id.artist_thumbnail)ImageView ivThumb;



    public ArtistsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
        @Override
        public void onBind(Artist item, @Nullable final OnRecycleObjectClickListener<Artist> listener) {
            final Artist artist = item;
            tvTitle.setText(artist.getName());
            tvAlbumCount.setText(String.valueOf(artist.getAlbumCount()));
            Context context=ivThumb.getContext();
            Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(ivThumb);
            if(listener!=null){
                itemView.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        listener.OnItemClick(artist);
                    }
                });
            }
        }
}
}
