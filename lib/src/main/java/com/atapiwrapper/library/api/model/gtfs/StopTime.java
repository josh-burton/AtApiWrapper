package com.atapiwrapper.library.api.model.gtfs;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class StopTime implements Parcelable, Serializable {
	@JsonProperty("trip_id") private String tripId;
	@JsonProperty("stop_id") private Integer stopId;
	@JsonProperty("arrival_time") private String arrivalTime;
	@JsonProperty("departure_time") private String departureTime;
	@JsonProperty("pickup_type") private Integer pickupType;
	@JsonProperty("arrival_time_seconds") private Integer arrivalTimeSeconds;
	@JsonProperty("drop_off_type") private Integer dropOffType;
	@JsonProperty("stop_sequence") private Integer stopSequence;
	@JsonProperty("shape_dist_traveled") private String shapeDistTraveled;
	@JsonProperty("stop_headsign") private String stopHeadsign;
	@JsonProperty("timepoint") private String timepoint;
	@JsonProperty("departure_time_seconds") private Integer departureTimeSeconds;

	public String getTripId() {
		return tripId;
	}

	public Integer getStopId() {
		return stopId;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public Integer getPickupType() {
		return pickupType;
	}

	public Integer getArrivalTimeSeconds() {
		return arrivalTimeSeconds;
	}

	public Integer getDropOffType() {
		return dropOffType;
	}

	public Integer getStopSequence() {
		return stopSequence;
	}

	public String getShapeDistTraveled() {
		return shapeDistTraveled;
	}

	public String getStopHeadsign() {
		return stopHeadsign;
	}

	public String getTimepoint() {
		return timepoint;
	}

	public Integer getDepartureTimeSeconds() {
		return departureTimeSeconds;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.tripId);
		dest.writeValue(this.stopId);
		dest.writeString(this.arrivalTime);
		dest.writeString(this.departureTime);
		dest.writeValue(this.pickupType);
		dest.writeValue(this.arrivalTimeSeconds);
		dest.writeValue(this.dropOffType);
		dest.writeValue(this.stopSequence);
		dest.writeString(this.shapeDistTraveled);
		dest.writeString(this.stopHeadsign);
		dest.writeString(this.timepoint);
		dest.writeValue(this.departureTimeSeconds);
	}

	public StopTime() {}

	private StopTime(Parcel in) {
		this.tripId = in.readString();
		this.stopId = (Integer) in.readValue(Integer.class.getClassLoader());
		this.arrivalTime = in.readString();
		this.departureTime = in.readString();
		this.pickupType = (Integer) in.readValue(Integer.class.getClassLoader());
		this.arrivalTimeSeconds = (Integer) in.readValue(Integer.class.getClassLoader());
		this.dropOffType = (Integer) in.readValue(Integer.class.getClassLoader());
		this.stopSequence = (Integer) in.readValue(Integer.class.getClassLoader());
		this.shapeDistTraveled = in.readString();
		this.stopHeadsign = in.readString();
		this.timepoint = in.readString();
		this.departureTimeSeconds = (Integer) in.readValue(Integer.class.getClassLoader());
	}

	public static Parcelable.Creator<StopTime> CREATOR = new Parcelable.Creator<StopTime>() {
		public StopTime createFromParcel(Parcel source) {
			return new StopTime(source);
		}

		public StopTime[] newArray(int size) {
			return new StopTime[size];
		}
	};
}
