package com.teejay.activityfragmentmvp.data.model;

/**
 * Created by tjaved on 1/28/18.
 */

public class Album {
    Song[] songs;
    String id;
    String name;
    String noOfTracks;
    String thumbnail;
    String artistName;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Album(String id, String name, String noOfTracks, String thumbnail, String artistName) {
        this.id = id;
        this.name = name;
        this.noOfTracks = noOfTracks;
        this.thumbnail = thumbnail;
        this.artistName = artistName;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(String noOfTracks) {
        this.noOfTracks = noOfTracks;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
