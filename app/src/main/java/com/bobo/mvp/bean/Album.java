package com.bobo.mvp.bean;

/**
 * Created by bobo on 2018/3/10.
 */

public class Album {
    private String albumId;
    private String coverUrl;
    private String name;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
