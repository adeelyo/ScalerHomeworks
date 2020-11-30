package com.scaler.tinyurl;

import java.util.List;

import static com.scaler.tinyurl.ShortUrl.tinyUrlMap;

public class UrlMaker {
    public static final String urlHead = "https://www.";
    public static final int urlHeadSize = urlHead.length();
    public static final String shortUrlHead = "https://www.short.com/";
    public static final int modValue = Integer.MAX_VALUE;

    public static int getHash(String url) {
        int hashValue = 0;
        int hashFactor = 1;
        int size = url.length();
        int startingIndex =0;
        if(url.contains(urlHead)) {
            startingIndex+=urlHeadSize;
        }
        //staring calculating the hash value after www. part
        for(int i=startingIndex;i<size;i++) {
            char currentCharacter = url.charAt(i);
            hashValue+= ((int)currentCharacter*hashFactor)%modValue;
            hashFactor*=10;
            hashFactor=hashFactor%modValue;
        }

        return hashValue;
    }

    public static String makeShortUrl(String shortHash) {
        return shortUrlHead + shortHash;
    }

    public static String makeShortUrl(String shortHash, String suffix) {
        return shortUrlHead + shortHash + "?" + suffix;
    }

    public static void createShortUrl(List<Url> urlList) {
        for(Url url: urlList) {
            int hashValue = getHash(url.getUrl());
            String hashString;
            if(hashValue<0) {
                //if negative hashValue just adding a character
                hashString = "A"+Math.abs(hashValue);
            }else {
                hashString = String.valueOf(hashValue);
            }
            if(url.getSuffix()!=null) {
                url.setShortUrl(makeShortUrl(hashString, url.getSuffix()));
            }else {
                url.setShortUrl(makeShortUrl(hashString));
            }
            //values of this map could either be shortened url
            //or just the hash value part
            tinyUrlMap.put(url.getShortUrl(), url.getUrl());
        }
    }
}
