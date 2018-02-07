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
import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.BaseViewHolder;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.GenericRecycleAdapter;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.OnRecycleObjectClickListener;

import java.io.File;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumsAdapter extends GenericRecycleAdapter<Album,
        OnRecycleObjectClickListener<Album>,AlbumsAdapter.AlbumsViewHolder> {

    @Inject
    public AlbumsAdapter(Context context) {
        super(context);
    }

    @Override
    public AlbumsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_album, parent, false);
        return new AlbumsViewHolder(itemView);
    }


    class AlbumsViewHolder extends BaseViewHolder<Album, OnRecycleObjectClickListener<Album>> {
        @BindView(R.id.album_title) TextView tvTitle;
        @BindView(R.id.artist_title) TextView tvArtistTitle;
        @BindView(R.id.track_count)TextView tvTrackCount;
        @BindView(R.id.album_thumbnail)ImageView ivThumb;



        public AlbumsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @Override
        public void onBind(Album item, @Nullable final OnRecycleObjectClickListener<Album> listener) {
            final Album album = item;
            tvTitle.setText(album.getName());
            tvArtistTitle.setText(String.valueOf(album.getNoOfTracks()));
            tvArtistTitle.setText(String.valueOf(album.getArtistName()));
            Context context=ivThumb.getContext();
            //File f = new File(item.getThumbnail());
            String imgPath=item.getThumbnail();
            Picasso.with(context).load(imgPath!=null?"file://"+imgPath:"http://i.imgur.com/DvpvklR.png").into(ivThumb);
            if(listener!=null){
                itemView.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        listener.OnItemClick(album);
                    }
                });
            }
        }
    }
}
