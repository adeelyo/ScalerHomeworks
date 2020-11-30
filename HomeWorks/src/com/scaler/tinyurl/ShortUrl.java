package com.scaler.tinyurl;

import java.awt.*;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ShortUrl {
    /**
     * Map of short Urls to Urls
     */
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
        openBrowser("https://www.short.com/515262546");
    }

    /**
     * displays all the map of short urls to urls
     */
    public static void displayShortUrls() {
        tinyUrlMap.forEach((shortUrl, url) -> {
            System.out.println("URL :");
            System.out.println(url);
            System.out.println("Shortened URL:");
            System.out.println(shortUrl);
        });
    }

    /**
     * Opens default browser with the URL provided
     * @param shortUrl the url that you want to open
     */
    public static void openBrowser(String shortUrl) {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(tinyUrlMap.get(shortUrl));
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
