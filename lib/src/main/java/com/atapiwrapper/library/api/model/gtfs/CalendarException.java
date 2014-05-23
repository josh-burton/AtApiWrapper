package com.atapiwrapper.library.api.model.gtfs;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CalendarException implements Parcelable, Serializable {
	@JsonProperty("service_id") private String serviceId;
	@JsonProperty("exception_type") private Integer exceptionType;
	@JsonProperty("date") private String date;

	public String getServiceId() {
		return serviceId;
	}

	public Integer getExceptionType() {
		return exceptionType;
	}

	public String getDate() {
		return date;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.serviceId);
		dest.writeValue(this.exceptionType);
		dest.writeString(this.date);
	}

	public CalendarException() {}

	private CalendarException(Parcel in) {
		this.serviceId = in.readString();
		this.exceptionType = (Integer) in.readValue(Integer.class.getClassLoader());
		this.date = in.readString();
	}

	public static Parcelable.Creator<CalendarException> CREATOR = new Parcelable.Creator<CalendarException>() {
		public CalendarException createFromParcel(Parcel source) {
			return new CalendarException(source);
		}

		public CalendarException[] newArray(int size) {
			return new CalendarException[size];
		}
	};
}
