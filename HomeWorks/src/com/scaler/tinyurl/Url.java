package com.scaler.tinyurl;

public class Url {
    private String url;
    private String suffix;
    public Url(String url) {
        this.url = url;
        this.shortUrl = null;
        this.suffix = null;
    }
    public Url(String url, String suffix) {
        this.url = url;
        this.shortUrl = null;
        this.suffix = suffix;
    }
    private String shortUrl;
    public String getUrl() {
        return this.url;
    }
    public String getSuffix() {
        return this.suffix;
    }

    public String getShortUrl() {
        return this.shortUrl;
    }
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
