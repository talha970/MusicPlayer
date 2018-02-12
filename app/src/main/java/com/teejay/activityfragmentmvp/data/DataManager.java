package com.teejay.activityfragmentmvp.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.teejay.activityfragmentmvp.data.local.MediaStoreAccessHelper;
import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.data.model.Artist;
import com.teejay.activityfragmentmvp.data.model.Song;

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

    public List<Song> mSongs;


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
    public List<Song> getSongsByAlbum(String id){
        mSongs=new ArrayList<>();
        String[] columns={
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.MIME_TYPE,
                MediaStore.Audio.Media.TRACK,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ARTIST_ID,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.ALBUM_ID,
                MediaStore.Audio.Media.YEAR,
        };

        String where= MediaStore.Audio.Media.ALBUM_ID+"=?";

        audioCursor = MediaStoreAccessHelper.getAllSongsWithSelection(context,columns,where, new String[] { id },"ASC");
        if (audioCursor != null) {
            if (audioCursor.moveToFirst()) {
                do {
                    Song song;
                    int songIDColumn = audioCursor.getColumnIndexOrThrow( MediaStore.Audio.Media._ID);
                    int songTitleColumn = audioCursor.getColumnIndexOrThrow( MediaStore.Audio.Media.TITLE);
                    int songFileNameColumn = audioCursor.getColumnIndexOrThrow( MediaStore.Audio.Media.DISPLAY_NAME);
                    int songMIMEColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE);
                    int songTracknoColumn = audioCursor.getColumnIndexOrThrow( MediaStore.Audio.Media.TRACK);
                    int songDurationColumn = audioCursor.getColumnIndexOrThrow( MediaStore.Audio.Media.DURATION);
                    int songPathColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
                    int songArtistColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST);
                    int songArtistIDColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST_ID);
                    int songAlbumIDColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID);
                    int songAlbumColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM);
                    int songYearColumn = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.YEAR);

                    String songID=audioCursor.getString(songIDColumn);
                    String songTitle=audioCursor.getString(songTitleColumn);
                    String songFileName=audioCursor.getString(songFileNameColumn);
                    String songMime=audioCursor.getString(songMIMEColumn);
                    int songTrackNo=audioCursor.getInt(songTracknoColumn);
                    int songDuration=audioCursor.getInt(songDurationColumn);
                    String songPath=audioCursor.getString(songPathColumn);
                    String songArtist=audioCursor.getString(songArtistColumn);
                    String songYear=audioCursor.getString(songYearColumn);
                    String songAlbum=audioCursor.getString(songAlbumColumn);
                    String songAlbumID=audioCursor.getString(songAlbumIDColumn);
                    String songArtistID=audioCursor.getString(songArtistIDColumn);



                    song=new Song(songID,songAlbumID,songAlbum,songArtistID,songArtist,songDuration,songTitle,songTrackNo,songPath);
                    if(!mSongs.contains(song)) {
                        mSongs.add(song);
                    }
                } while (audioCursor.moveToNext());
            }
        }
        audioCursor.close();

        return mSongs;
    }
}
