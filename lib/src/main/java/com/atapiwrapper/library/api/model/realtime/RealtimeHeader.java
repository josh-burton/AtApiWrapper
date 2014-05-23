package com.atapiwrapper.library.api.model.realtime;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class RealtimeHeader implements Parcelable, Serializable {
	@JsonProperty("timestamp") private Double timestamp;
	@JsonProperty("incrementality") private Integer incrementality;
	@JsonProperty("gtfs_realtime_version") private Float gtfsRealtimeVersion;

	public Double getTimestamp() {
		return timestamp;
	}

	public Integer getIncrementality() {
		return incrementality;
	}

	public Float getGtfsRealtimeVersion() {
		return gtfsRealtimeVersion;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.timestamp);
		dest.writeValue(this.incrementality);
		dest.writeValue(this.gtfsRealtimeVersion);
	}

	public RealtimeHeader() {}

	private RealtimeHeader(Parcel in) {
		this.timestamp = (Double) in.readValue(Double.class.getClassLoader());
		this.incrementality = (Integer) in.readValue(Integer.class.getClassLoader());
		this.gtfsRealtimeVersion = (Float) in.readValue(Float.class.getClassLoader());
	}

	public static Parcelable.Creator<RealtimeHeader> CREATOR = new Parcelable.Creator<RealtimeHeader>() {
		public RealtimeHeader createFromParcel(Parcel source) {
			return new RealtimeHeader(source);
		}

		public RealtimeHeader[] newArray(int size) {
			return new RealtimeHeader[size];
		}
	};
}
