package com.atapiwrapper.library.api.model.realtime.vehiclelocations;

import android.os.Parcel;
import android.os.Parcelable;

import com.atapiwrapper.library.api.model.Position;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Vehicle implements Parcelable, Serializable {
	@JsonProperty("timestamp") private Integer timestamp;
	@JsonProperty("position") private Position position;
	@JsonProperty("id") private String id;
	@JsonProperty("vehicle") private Vehicle vehicle;
	@JsonProperty("trip") private VehicleTrip trip;

	public Integer getTimestamp() {
		return timestamp;
	}

	public Position getPosition() {
		return position;
	}

	public String getId() {
		return id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public VehicleTrip getTrip() {
		return trip;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.timestamp);
		dest.writeParcelable(this.position, flags);
		dest.writeString(this.id);
		dest.writeParcelable(this.vehicle, flags);
		dest.writeParcelable(this.trip, 0);
	}

	public Vehicle() {}

	private Vehicle(Parcel in) {
		this.timestamp = (Integer) in.readValue(Integer.class.getClassLoader());
		this.position = in.readParcelable(Position.class.getClassLoader());
		this.id = in.readString();
		this.vehicle = in.readParcelable(Vehicle.class.getClassLoader());
		this.trip = in.readParcelable(((Object) trip).getClass().getClassLoader());
	}

	public static Parcelable.Creator<Vehicle> CREATOR = new Parcelable.Creator<Vehicle>() {
		public Vehicle createFromParcel(Parcel source) {
			return new Vehicle(source);
		}

		public Vehicle[] newArray(int size) {
			return new Vehicle[size];
		}
	};
}
