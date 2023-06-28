package com.example.volley_5000photos;

public class DataModel {

    int id;
    String titel;
    int albumId;
    String url;

    public DataModel(int id, String titel, int albumId, String url) {
        this.id = id;
        this.titel = titel;
        this.albumId = albumId;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    @Override
    public String toString() {
        return "DataModel{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", albumId=" + albumId +
                ", url='" + url + '\'' +
                '}';
    }
}
