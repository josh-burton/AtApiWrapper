package com.atapiwrapper.library.api.model.display;

import android.os.Parcel;
import android.os.Parcelable;

import com.atapiwrapper.library.api.model.geometry.Geometry;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduledWork implements Parcelable {
	@JsonProperty("region") private String region;
	@JsonProperty("startDate") private String startDate;
	@JsonProperty("lastUpdated") private String lastUpdated;
	@JsonProperty("endDate") private String endDate;
	@JsonProperty("code") private String code;
	@JsonProperty("type") private String type;
	@JsonProperty("geometry") private Geometry geometry;
	@JsonProperty("id") private Integer id;
	@JsonProperty("contractorCompany") private String contractorCompany;
	@JsonProperty("suburb") private String suburb;
	@JsonProperty("address") private String address;
	@JsonProperty("description") private String description;
	@JsonProperty("name") private String name;
	@JsonProperty("longitude") private Double longitude;
	@JsonProperty("latitude") private Double latitude;

	public String getRegion() {
		return region;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public Integer getId() {
		return id;
	}

	public String getContractorCompany() {
		return contractorCompany;
	}

	public String getSuburb() {
		return suburb;
	}

	public String getAddress() {
		return address;
	}

	public String getDescription() {
		return description;
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


	@Override public int describeContents() { return 0; }

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.region);
		dest.writeString(this.startDate);
		dest.writeString(this.lastUpdated);
		dest.writeString(this.endDate);
		dest.writeString(this.code);
		dest.writeString(this.type);
//		dest.writeParcelable(this.geometry, flags);
		dest.writeValue(this.id);
		dest.writeString(this.contractorCompany);
		dest.writeString(this.suburb);
		dest.writeString(this.address);
		dest.writeString(this.description);
		dest.writeString(this.name);
		dest.writeValue(this.longitude);
		dest.writeValue(this.latitude);
	}

	public ScheduledWork() {}

	private ScheduledWork(Parcel in) {
		this.region = in.readString();
		this.startDate = in.readString();
		this.lastUpdated = in.readString();
		this.endDate = in.readString();
		this.code = in.readString();
		this.type = in.readString();
//		this.geometry = in.readParcelable(Geometry.class.getClassLoader());
		this.id = (Integer) in.readValue(Integer.class.getClassLoader());
		this.contractorCompany = in.readString();
		this.suburb = in.readString();
		this.address = in.readString();
		this.description = in.readString();
		this.name = in.readString();
		this.longitude = (Double) in.readValue(Double.class.getClassLoader());
		this.latitude = (Double) in.readValue(Double.class.getClassLoader());
	}

	public static Parcelable.Creator<ScheduledWork> CREATOR = new Parcelable.Creator<ScheduledWork>() {
		public ScheduledWork createFromParcel(Parcel source) {return new ScheduledWork(source);}

		public ScheduledWork[] newArray(int size) {return new ScheduledWork[size];}
	};
}
