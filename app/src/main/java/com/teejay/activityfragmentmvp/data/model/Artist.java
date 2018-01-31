package com.teejay.activityfragmentmvp.data.model;

/**
 * Created by tjaved on 1/28/18.
 */

public class Artist {
    String id;
    String name;
    int albumCount;
    int trackCount;

    public Artist(String id, String name, int albumCount, int trackCount) {
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

    public int getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(int albumCount) {
        this.albumCount = albumCount;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }
}
