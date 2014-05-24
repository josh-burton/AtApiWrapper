package com.atapiwrapper.library.api.model.gtfs;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class ShapePoint implements Serializable, Parcelable {
    @JsonProperty("shape_id") private String id;
    @JsonProperty("shape_pt_lat") private double lat;
    @JsonProperty("shape_pt_lon") private double lon;
    @JsonProperty("shape_pt_sequence") private int sequence;
    @JsonProperty("shape_dist_traveled") private double distTraveled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public double getDistTraveled() {
        return distTraveled;
    }

    public void setDistTraveled(double distTraveled) {
        this.distTraveled = distTraveled;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeDouble(this.lat);
        dest.writeDouble(this.lon);
        dest.writeInt(this.sequence);
        dest.writeDouble(this.distTraveled);
    }

    public ShapePoint() {
    }

    private ShapePoint(Parcel in) {
        this.id = in.readString();
        this.lat = in.readDouble();
        this.lon = in.readDouble();
        this.sequence = in.readInt();
        this.distTraveled = in.readDouble();
    }

    public static Creator<ShapePoint> CREATOR = new Creator<ShapePoint>() {
        public ShapePoint createFromParcel(Parcel source) {
            return new ShapePoint(source);
        }

        public ShapePoint[] newArray(int size) {
            return new ShapePoint[size];
        }
    };
}

