package com.atapiwrapper.library.api.model.gtfs;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Route implements Parcelable, Serializable {
	@JsonProperty("agency_id") private String agencyId;
	@JsonProperty("route_color") private String routeColor;
	@JsonProperty("route_desc") private String routeDesc;
	@JsonProperty("route_type") private Integer routeType;
	@JsonProperty("route_id") private String routeId;
	@JsonProperty("route_short_name") private String routeShortName;
	@JsonProperty("route_url") private String routeUrl;
	@JsonProperty("route_text_color") private String routeTextColor;
	@JsonProperty("route_long_name") private String routeLongName;
	@JsonProperty("st_distance_sphere") private String stDistanceSphere;

	public String getAgencyId() {
		return agencyId;
	}

	public String getRouteColor() {
		return routeColor;
	}

	public String getRouteDesc() {
		return routeDesc;
	}

	public Integer getRouteType() {
		return routeType;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getRouteShortName() {
		return routeShortName;
	}

	public String getRouteUrl() {
		return routeUrl;
	}

	public String getRouteTextColor() {
		return routeTextColor;
	}

	public String getRouteLongName() {
		return routeLongName;
	}

	public String getStDistanceSphere() {
		return stDistanceSphere;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.agencyId);
		dest.writeString(this.routeColor);
		dest.writeString(this.routeDesc);
		dest.writeValue(this.routeType);
		dest.writeString(this.routeId);
		dest.writeString(this.routeShortName);
		dest.writeString(this.routeUrl);
		dest.writeString(this.routeTextColor);
		dest.writeString(this.routeLongName);
		dest.writeString(this.stDistanceSphere);
	}

	public Route() {}

	private Route(Parcel in) {
		this.agencyId = in.readString();
		this.routeColor = in.readString();
		this.routeDesc = in.readString();
		this.routeType = (Integer) in.readValue(Integer.class.getClassLoader());
		this.routeId = in.readString();
		this.routeShortName = in.readString();
		this.routeUrl = in.readString();
		this.routeTextColor = in.readString();
		this.routeLongName = in.readString();
		this.stDistanceSphere = in.readString();
	}

	public static Creator<Route> CREATOR = new Creator<Route>() {
		public Route createFromParcel(Parcel source) {
			return new Route(source);
		}

		public Route[] newArray(int size) {
			return new Route[size];
		}
	};
}
