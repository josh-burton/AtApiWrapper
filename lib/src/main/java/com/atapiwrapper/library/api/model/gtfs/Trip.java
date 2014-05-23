package com.atapiwrapper.library.api.model.gtfs;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trip implements Parcelable {
	@JsonProperty("service_id") private String serviceId;
	@JsonProperty("trip_id") private String tripId;
	@JsonProperty("direction_id") private Integer directionId;
	@JsonProperty("route_id") private String routeId;
	@JsonProperty("trip_type") private String tripType;
	@JsonProperty("trip_headsign") private String tripHeadsign;
	@JsonProperty("shape_id") private Integer shapeId;
	@JsonProperty("trip_short_name") private String tripShortName;
	@JsonProperty("block_id") private String blockId;

	public String getServiceId() {
		return serviceId;
	}

	public String getTripId() {
		return tripId;
	}

	public Integer getDirectionId() {
		return directionId;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getTripType() {
		return tripType;
	}

	public String getTripHeadsign() {
		return tripHeadsign;
	}

	public Integer getShapeId() {
		return shapeId;
	}

	public String getTripShortName() {
		return tripShortName;
	}

	public String getBlockId() {
		return blockId;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.serviceId);
		dest.writeString(this.tripId);
		dest.writeValue(this.directionId);
		dest.writeString(this.routeId);
		dest.writeString(this.tripType);
		dest.writeString(this.tripHeadsign);
		dest.writeValue(this.shapeId);
		dest.writeString(this.tripShortName);
		dest.writeString(this.blockId);
	}

	public Trip() {}

	private Trip(Parcel in) {
		this.serviceId = in.readString();
		this.tripId = in.readString();
		this.directionId = (Integer) in.readValue(Integer.class.getClassLoader());
		this.routeId = in.readString();
		this.tripType = in.readString();
		this.tripHeadsign = in.readString();
		this.shapeId = (Integer) in.readValue(Integer.class.getClassLoader());
		this.tripShortName = in.readString();
		this.blockId = in.readString();
	}

	public static Parcelable.Creator<Trip> CREATOR = new Parcelable.Creator<Trip>() {
		public Trip createFromParcel(Parcel source) {
			return new Trip(source);
		}

		public Trip[] newArray(int size) {
			return new Trip[size];
		}
	};
}
