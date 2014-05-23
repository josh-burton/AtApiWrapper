package com.atapiwrapper.library.api.model.gtfs;


import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Agency implements Parcelable,Serializable {
	@JsonProperty("agency_phone") private String agencyPhone;
	@JsonProperty("agency_id") private String agencyId;
	@JsonProperty("agency_lang") private String agencyLang;
	@JsonProperty("agency_url") private String agencyUrl;
	@JsonProperty("agency_fare_url") private String agencyFareUrl;
	@JsonProperty("agency_timezone") private String agencyTimezone;
	@JsonProperty("agency_name") private String agencyName;


	public String getAgencyPhone() {
		return agencyPhone;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public String getAgencyLang() {
		return agencyLang;
	}

	public String getAgencyUrl() {
		return agencyUrl;
	}

	public String getAgencyFareUrl() {
		return agencyFareUrl;
	}

	public String getAgencyTimezone() {
		return agencyTimezone;
	}

	public String getAgencyName() {
		return agencyName;
	}

	@Override public int describeContents() { return 0; }

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.agencyPhone);
		dest.writeString(this.agencyId);
		dest.writeString(this.agencyLang);
		dest.writeString(this.agencyUrl);
		dest.writeString(this.agencyFareUrl);
		dest.writeString(this.agencyTimezone);
		dest.writeString(this.agencyName);
	}

	public Agency() {}

	private Agency(Parcel in) {
		this.agencyPhone = in.readString();
		this.agencyId = in.readString();
		this.agencyLang = in.readString();
		this.agencyUrl = in.readString();
		this.agencyFareUrl = in.readString();
		this.agencyTimezone = in.readString();
		this.agencyName = in.readString();
	}

	public static Parcelable.Creator<Agency> CREATOR = new Parcelable.Creator<Agency>() {
		public Agency createFromParcel(Parcel source) {return new Agency(source);}

		public Agency[] newArray(int size) {return new Agency[size];}
	};
}
