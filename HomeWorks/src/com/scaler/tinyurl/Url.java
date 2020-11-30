package com.scaler.tinyurl;

public class Url {
    private String url;
    public Url(String url) {
        this.url = url;
        this.shortUrl = "";
    }
    private String shortUrl;
    public String getUrl() {
        return this.url;
    }
    public String getShortUrl() {
        return this.shortUrl;
    }
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
