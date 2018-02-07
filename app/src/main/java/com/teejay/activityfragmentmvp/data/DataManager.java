package com.teejay.activityfragmentmvp.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.teejay.activityfragmentmvp.data.local.MediaStoreAccessHelper;
import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.data.model.Artist;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tjaved on 1/28/18.
 */

public class DataManager {

    Context context;
    Cursor audioCursor;

    @Inject
    public DataManager(Context context) {
        this.context = context;
    }

    public List<Artist> mArtists;

    public List<Album> mAlbums;


    public List<Artist> getArtistsfromDevice() {
        mArtists=new ArrayList<>();
        audioCursor = MediaStoreAccessHelper.getAllUniqueArtists(context);

        if (audioCursor != null) {
            if (audioCursor.moveToFirst()) {
                do {
                    Artist artist;
                    int artistColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Artists._ID);
                    int artistNoTracksColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Artists.ARTIST);
                    int artistIDColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Artists.NUMBER_OF_ALBUMS);
                    int artistNoAlbumsColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Artists.NUMBER_OF_TRACKS);

                    String artistName=audioCursor.getString(artistColumn);
                    String artistID=audioCursor.getString(artistIDColumn);
                    String artistNoTracks=audioCursor.getString(artistNoTracksColumn);
                    String artistNoAlbums=audioCursor.getString(artistNoAlbumsColumn);

                    artist=new Artist(artistID,artistName,artistNoAlbums,artistNoTracks);
                    if(!mArtists.contains(artist)) {
                        mArtists.add(artist);
                    }
                } while (audioCursor.moveToNext());
            }
        }
        audioCursor.close();
        return mArtists;
    }
    public List<Album> getAlbumsfromDevice() {
        mAlbums=new ArrayList<>();
        audioCursor = MediaStoreAccessHelper.getAllUniqueAlbums(context);

        if (audioCursor != null) {
            if (audioCursor.moveToFirst()) {
                do {
                    Album album;
                    int albumIDColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Albums._ID);
                    int albumColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Albums.ALBUM);
                    int albumNoTracksColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Albums.NUMBER_OF_SONGS);
                    int albumArtColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Albums.ALBUM_ART);
                    int albumArtistColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Albums.ARTIST);

                    String albumName=audioCursor.getString(albumColumn);
                    String albumID=audioCursor.getString(albumIDColumn);
                    String albumNoTracks=audioCursor.getString(albumNoTracksColumn);
                    String albumArt=audioCursor.getString(albumArtColumn);
                    String albumArtist=audioCursor.getString(albumArtistColumn);

                    album=new Album(albumID,albumName,albumNoTracks,albumArt,albumArtist);
                    if(!mAlbums.contains(album)) {
                        mAlbums.add(album);
                    }
                } while (audioCursor.moveToNext());
            }
        }
        audioCursor.close();
        return mAlbums;
    }
}
