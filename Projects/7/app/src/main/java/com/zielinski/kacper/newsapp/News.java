package com.zielinski.kacper.newsapp;

public class News
{
    private String title;
    private String sectionName;
    private String author;
    private String date;
    private String time;
    private String URL;

    public News(String title, String sectionName, String date, String time, String URL) {
        this.title = title;
        this.sectionName = sectionName;
        this.date = date;
        this.time = time;
        this.URL = URL;
    }

    public News(String title, String sectionName, String author, String date, String time, String URL) {
        this.title = title;
        this.sectionName = sectionName;
        this.date = date;
        this.time = time;
        this.URL = URL;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getURL() {
        return URL;
    }
}
