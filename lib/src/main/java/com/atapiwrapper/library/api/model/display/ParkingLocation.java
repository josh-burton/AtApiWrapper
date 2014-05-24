package com.atapiwrapper.library.api.model.display;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParkingLocation implements Parcelable {
	@JsonProperty("id") private Integer id;
	@JsonProperty("address") private String address;
	@JsonProperty("mobilitySpaces") private Integer mobilitySpaces;
	@JsonProperty("name") private String name;
	@JsonProperty("longitude") private Double longitude;
	@JsonProperty("latitude") private Double latitude;
	@JsonProperty("type") private String type;

	public Integer getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public Integer getMobilitySpaces() {
		return mobilitySpaces;
	}

	public String getName() {
		return name;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public String getType() {
		return type;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.id);
		dest.writeString(this.address);
		dest.writeValue(this.mobilitySpaces);
		dest.writeString(this.name);
		dest.writeValue(this.longitude);
		dest.writeValue(this.latitude);
		dest.writeString(this.type);
	}

	public ParkingLocation() {}

	private ParkingLocation(Parcel in) {
		this.id = (Integer) in.readValue(Integer.class.getClassLoader());
		this.address = in.readString();
		this.mobilitySpaces = (Integer) in.readValue(Integer.class.getClassLoader());
		this.name = in.readString();
		this.longitude = (Double) in.readValue(Double.class.getClassLoader());
		this.latitude = (Double) in.readValue(Double.class.getClassLoader());
		this.type = in.readString();
	}

	public static Parcelable.Creator<ParkingLocation> CREATOR = new Parcelable.Creator<ParkingLocation>() {
		public ParkingLocation createFromParcel(Parcel source) {
			return new ParkingLocation(source);
		}

		public ParkingLocation[] newArray(int size) {
			return new ParkingLocation[size];
		}
	};
}
