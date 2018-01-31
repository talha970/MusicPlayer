package com.teejay.activityfragmentmvp.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.teejay.activityfragmentmvp.data.model.Artist;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tjaved on 1/28/18.
 */

public class DataManager {

    Context context;

    @Inject
    public DataManager(Context context) {
        this.context = context;
    }

    public List<Artist> mArtists;

    String[] ARTIST_PROJECTION = {MediaStore.Audio.Media.ARTIST_ID, MediaStore.Audio.Media.ARTIST,MediaStore.Audio.Media.ARTIST_KEY};// Can include more data for more details and check it.

    public List<Artist> getAlbumsfromDevice() {
        mArtists=new ArrayList<>();
        Cursor audioCursor = context.getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, ARTIST_PROJECTION, null, null, null);

        if (audioCursor != null) {
            if (audioCursor.moveToFirst()) {
                do {
                    Artist artist;
                    int artistColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST);
                    int artistKeyColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST_KEY);
                    int artistIDColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST_ID);


                    String artistName=audioCursor.getString(artistColumn);
                    String artistID=audioCursor.getString(artistIDColumn);
                    String artistKey=audioCursor.getString(artistKeyColumn);

                    artist=new Artist(artistID,artistName+" "+artistKey,0,0);
                    mArtists.add(artist);

                } while (audioCursor.moveToNext());
            }
        }
        audioCursor.close();
        return mArtists;
    }

}
