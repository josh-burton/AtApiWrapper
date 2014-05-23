package com.atapiwrapper.library.api.model.realtime.vehiclelocations;


import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class VehicleTrip implements Parcelable,Serializable {
	@JsonProperty("trip_id") private String tripId;
	@JsonProperty("schedule_relationship") private Integer scheduleRelationship;
	@JsonProperty("route_id") private String routeId;

	public String getTripId() {
		return tripId;
	}

	public Integer getScheduleRelationship() {
		return scheduleRelationship;
	}

	public String getRouteId() {
		return routeId;
	}


	@Override public int describeContents() { return 0; }

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.tripId);
		dest.writeValue(this.scheduleRelationship);
		dest.writeString(this.routeId);
	}

	public VehicleTrip() {}

	private VehicleTrip(Parcel in) {
		this.tripId = in.readString();
		this.scheduleRelationship = (Integer) in.readValue(Integer.class.getClassLoader());
		this.routeId = in.readString();
	}

	public static Parcelable.Creator<VehicleTrip> CREATOR = new Parcelable.Creator<VehicleTrip>() {
		public VehicleTrip createFromParcel(Parcel source) {return new VehicleTrip(source);}

		public VehicleTrip[] newArray(int size) {return new VehicleTrip[size];}
	};
}
