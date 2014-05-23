package com.atapiwrapper.library.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Position implements Parcelable, Serializable {
	@JsonProperty("longitude") private Double longitude;
	@JsonProperty("latitude") private Double latitude;

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.longitude);
		dest.writeValue(this.latitude);
	}

	public Position() {}

	private Position(Parcel in) {
		this.longitude = (Double) in.readValue(Double.class.getClassLoader());
		this.latitude = (Double) in.readValue(Double.class.getClassLoader());
	}

	public static Parcelable.Creator<Position> CREATOR = new Parcelable.Creator<Position>() {
		public Position createFromParcel(Parcel source) {
			return new Position(source);
		}

		public Position[] newArray(int size) {
			return new Position[size];
		}
	};
}
