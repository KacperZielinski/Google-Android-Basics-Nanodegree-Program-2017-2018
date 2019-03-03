package com.zielinski.kacper.tourguideapp;

public class Location
{
    private static final int NO_IMAGE_PROVIDED = -1;

    private String name;
    private int iconResourceID;
    private int backgroundImageResourceID = NO_IMAGE_PROVIDED;
    private final Class<?> activity;

    public Location(String name, int iconResourceID, Class<?> activity) {
        this.activity = activity;
        this.name = name;
        this.iconResourceID = iconResourceID;
    }

    public Location(String name, int iconResourceID, int backgroundImageResourceID, Class<?> activity) {
        this.activity = activity;
        this.name = name;
        this.iconResourceID = iconResourceID;
        this.backgroundImageResourceID = backgroundImageResourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconResourceID() {
        return iconResourceID;
    }

    public void setIconResourceID(int iconResourceID) {
        this.iconResourceID = iconResourceID;
    }

    public int getBackgroundImageResourceID() {
        return backgroundImageResourceID;
    }

    public boolean hasImage() {
        return backgroundImageResourceID != NO_IMAGE_PROVIDED;
    }

    public Class<?> getActivity() {
        return activity;
    }
}
