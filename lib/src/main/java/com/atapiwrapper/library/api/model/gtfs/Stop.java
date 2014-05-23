package com.atapiwrapper.library.api.model.gtfs;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Stop implements Parcelable, Serializable {
	@JsonProperty("position") private String position;
	@JsonProperty("stop_lon") private Double stopLon;
	@JsonProperty("stop_street") private String stopStreet;
	@JsonProperty("stop_city") private String stopCity;
	@JsonProperty("stop_timezone") private String stopTimezone;
	@JsonProperty("parent_station") private String parentStation;
	@JsonProperty("location_type") private String locationType;
	@JsonProperty("stop_country") private String stopCountry;
	@JsonProperty("zone_id") private String zoneId;
	@JsonProperty("direction") private String direction;
	@JsonProperty("the_geom") private String theGeom;
	@JsonProperty("stop_name") private String stopName;
	@JsonProperty("stop_id") private Integer stopId;
	@JsonProperty("stop_code") private Integer stopCode;
	@JsonProperty("stop_postcode") private String stopPostcode;
	@JsonProperty("stop_lat") private Double stopLat;
	@JsonProperty("stop_region") private String stopRegion;
	@JsonProperty("stop_url") private String stopUrl;
	@JsonProperty("wheelchair_boarding") private boolean wheelchairBoarding;
	@JsonProperty("stop_desc") private String stopDesc;

	public String getPosition() {
		return position;
	}

	public Double getStopLon() {
		return stopLon;
	}

	public String getStopStreet() {
		return stopStreet;
	}

	public String getStopCity() {
		return stopCity;
	}

	public String getStopTimezone() {
		return stopTimezone;
	}

	public String getParentStation() {
		return parentStation;
	}

	public String getLocationType() {
		return locationType;
	}

	public String getStopCountry() {
		return stopCountry;
	}

	public String getZoneId() {
		return zoneId;
	}

	public String getDirection() {
		return direction;
	}

	public String getTheGeom() {
		return theGeom;
	}

	public String getStopName() {
		return stopName;
	}

	public Integer getStopId() {
		return stopId;
	}

	public Integer getStopCode() {
		return stopCode;
	}

	public String getStopPostcode() {
		return stopPostcode;
	}

	public Double getStopLat() {
		return stopLat;
	}

	public String getStopUrl() {
		return stopUrl;
	}

	public boolean isWheelchairBoarding() {
		return wheelchairBoarding;
	}

	public String getStopDesc() {
		return stopDesc;
	}

	public String getStopRegion() {
		return stopRegion;
	}


	@Override public int describeContents() { return 0; }

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.position);
		dest.writeValue(this.stopLon);
		dest.writeString(this.stopStreet);
		dest.writeString(this.stopCity);
		dest.writeString(this.stopTimezone);
		dest.writeString(this.parentStation);
		dest.writeString(this.locationType);
		dest.writeString(this.stopCountry);
		dest.writeString(this.zoneId);
		dest.writeString(this.direction);
		dest.writeString(this.theGeom);
		dest.writeString(this.stopName);
		dest.writeValue(this.stopId);
		dest.writeValue(this.stopCode);
		dest.writeString(this.stopPostcode);
		dest.writeValue(this.stopLat);
		dest.writeString(this.stopRegion);
		dest.writeString(this.stopUrl);
		dest.writeByte(wheelchairBoarding ? (byte) 1 : (byte) 0);
		dest.writeString(this.stopDesc);
	}

	public Stop() {}

	private Stop(Parcel in) {
		this.position = in.readString();
		this.stopLon = (Double) in.readValue(Double.class.getClassLoader());
		this.stopStreet = in.readString();
		this.stopCity = in.readString();
		this.stopTimezone = in.readString();
		this.parentStation = in.readString();
		this.locationType = in.readString();
		this.stopCountry = in.readString();
		this.zoneId = in.readString();
		this.direction = in.readString();
		this.theGeom = in.readString();
		this.stopName = in.readString();
		this.stopId = (Integer) in.readValue(Integer.class.getClassLoader());
		this.stopCode = (Integer) in.readValue(Integer.class.getClassLoader());
		this.stopPostcode = in.readString();
		this.stopLat = (Double) in.readValue(Double.class.getClassLoader());
		this.stopRegion = in.readString();
		this.stopUrl = in.readString();
		this.wheelchairBoarding = in.readByte() != 0;
		this.stopDesc = in.readString();
	}

	public static Creator<Stop> CREATOR = new Creator<Stop>() {
		public Stop createFromParcel(Parcel source) {return new Stop(source);}

		public Stop[] newArray(int size) {return new Stop[size];}
	};
}
