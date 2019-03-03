package com.zielinski.kacper.musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

public class Track implements Parcelable
{
    private String songName;
    private String artistName;

    /**
     * Duration time given in seconds
     */
    private int duration;

    public Track(String songName, String artistName, int duration) {
        this.songName = songName;
        this.artistName = artistName;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(songName);
        parcel.writeString(artistName);
        parcel.writeInt(duration);
    }

    public static final Parcelable.Creator<Track> CREATOR = new Parcelable.Creator<Track>() {
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    private Track(Parcel in) {
        songName = in.readString();
        artistName = in.readString();
        duration = in.readInt();
    }

    public String getDurationString()
    {
        if(duration == 0)
            return "";

        int minutes = duration/60;
        int seconds = duration - minutes*60;
        String songDuration = minutes + ":" + seconds;

        if(seconds < 10)
            songDuration = minutes + ":0" + seconds;

        return songDuration;
    }
}
