package com.atapiwrapper.library.api.model.gtfs;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Calendar implements Parcelable, Serializable {
	@JsonProperty("service_id") private String serviceId;
	@JsonProperty("end_date") private String endDate;
	@JsonProperty("wednesday") private Integer wednesday;
	@JsonProperty("monday") private Integer monday;
	@JsonProperty("thursday") private Integer thursday;
	@JsonProperty("sunday") private Integer sunday;
	@JsonProperty("saturday") private Integer saturday;
	@JsonProperty("tuesday") private Integer tuesday;
	@JsonProperty("friday") private Integer friday;
	@JsonProperty("start_date") private String startDate;

	public String getServiceId() {
		return serviceId;
	}

	public String getEndDate() {
		return endDate;
	}

	public Integer getWednesday() {
		return wednesday;
	}

	public Integer getMonday() {
		return monday;
	}

	public Integer getThursday() {
		return thursday;
	}

	public Integer getSunday() {
		return sunday;
	}

	public Integer getSaturday() {
		return saturday;
	}

	public Integer getTuesday() {
		return tuesday;
	}

	public Integer getFriday() {
		return friday;
	}

	public String getStartDate() {
		return startDate;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.serviceId);
		dest.writeString(this.endDate);
		dest.writeValue(this.wednesday);
		dest.writeValue(this.monday);
		dest.writeValue(this.thursday);
		dest.writeValue(this.sunday);
		dest.writeValue(this.saturday);
		dest.writeValue(this.tuesday);
		dest.writeValue(this.friday);
		dest.writeString(this.startDate);
	}

	public Calendar() {}

	private Calendar(Parcel in) {
		this.serviceId = in.readString();
		this.endDate = in.readString();
		this.wednesday = (Integer) in.readValue(Integer.class.getClassLoader());
		this.monday = (Integer) in.readValue(Integer.class.getClassLoader());
		this.thursday = (Integer) in.readValue(Integer.class.getClassLoader());
		this.sunday = (Integer) in.readValue(Integer.class.getClassLoader());
		this.saturday = (Integer) in.readValue(Integer.class.getClassLoader());
		this.tuesday = (Integer) in.readValue(Integer.class.getClassLoader());
		this.friday = (Integer) in.readValue(Integer.class.getClassLoader());
		this.startDate = in.readString();
	}

	public static Parcelable.Creator<Calendar> CREATOR = new Parcelable.Creator<Calendar>() {
		public Calendar createFromParcel(Parcel source) {
			return new Calendar(source);
		}

		public Calendar[] newArray(int size) {
			return new Calendar[size];
		}
	};
}
