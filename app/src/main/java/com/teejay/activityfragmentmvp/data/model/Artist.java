package com.teejay.activityfragmentmvp.data.model;

/**
 * Created by tjaved on 1/28/18.
 */

public class Artist {
    String id;
    String name;
    String albumCount;
    String trackCount;

    public Artist(String id, String name, String albumCount, String trackCount) {
        this.id = id;
        this.name = name;
        this.albumCount = albumCount;
        this.trackCount = trackCount;
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

    public String getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(String albumCount) {
        this.albumCount = albumCount;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(String trackCount) {
        this.trackCount = trackCount;
    }
}
