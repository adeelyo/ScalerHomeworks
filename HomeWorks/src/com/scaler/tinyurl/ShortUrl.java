package com.scaler.tinyurl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ShortUrl {
    public static Map<String, String> tinyUrlMap;
    public static void main(String[] args) {
        //Scanner will be used in case of getting input from keyboard
        Scanner in = new Scanner(System.in);
        tinyUrlMap = new HashMap<>();
        Url urlOne = new Url("https://www.scaler.com/aademy/mentee-dashboard/mentor_info/#session-timeline-tab");
        Url urlTwo = new Url("https://www.scaler.com/academy/mentee-dashboard/classroom/#homework");
        Url urlThree = new Url("https://www.scaler.com/academy/mentee-dashboard/classroom/high-level-design-basics-943a5207-48f1-4798-bee6-da41d2a2476f/#lecture");
        Url urlFour = new Url("https://www.google.com/search?q=Suffix+meaning&oq=Suffix+meaning&aqs=chrome..69i57j0i457j0j0i20i263j0l4.3087j1j7&sourceid=chrome&ie=UTF-8", "googleSearch");
        Url urlFive = new Url("https://discussions.apple.com/thread/251660112","AppleLink");
        List<Url> urlList = new ArrayList<>();
        urlList.add(urlOne);
        urlList.add(urlTwo);
        urlList.add(urlThree);
        urlList.add(urlFour);
        urlList.add(urlFive);
        UrlMaker.createShortUrl(urlList);
        displayShortUrls();
    }
    public static void displayShortUrls() {
        tinyUrlMap.forEach((url, shortUrl) -> {
            System.out.println("URL :");
            System.out.println(url);
            System.out.println("Shortened URL:");
            System.out.println(shortUrl);
        });
    }

}
