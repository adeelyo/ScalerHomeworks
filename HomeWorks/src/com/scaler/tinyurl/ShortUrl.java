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
        List<Url> urlList = new ArrayList<>();
        urlList.add(urlOne);
        urlList.add(urlTwo);
        urlList.add(urlThree);
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
