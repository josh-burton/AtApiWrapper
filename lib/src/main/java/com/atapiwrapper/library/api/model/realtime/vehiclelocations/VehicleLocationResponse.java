package com.atapiwrapper.library.api.model.realtime.vehiclelocations;

import android.os.Parcel;
import android.os.Parcelable;

import com.atapiwrapper.library.api.model.realtime.RealtimeHeader;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VehicleLocationResponse implements Parcelable, Serializable {
	@JsonProperty("entity") private List<VehicleLocation> entity;
	@JsonProperty("header") private RealtimeHeader header;

	public List<VehicleLocation> getVehicleLocations() {
		return entity;
	}

	public RealtimeHeader getHeader() {
		return header;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(this.entity);
		dest.writeParcelable(this.header, 0);
	}

	public VehicleLocationResponse() {}

	private VehicleLocationResponse(Parcel in) {
		this.entity = new ArrayList<VehicleLocation>();
		in.readList(this.entity, VehicleLocation.class.getClassLoader());
		this.header = in.readParcelable(((Object) header).getClass().getClassLoader());
	}

	public static Parcelable.Creator<VehicleLocationResponse> CREATOR = new Parcelable.Creator<VehicleLocationResponse>() {
		public VehicleLocationResponse createFromParcel(Parcel source) {
			return new VehicleLocationResponse(source);
		}

		public VehicleLocationResponse[] newArray(int size) {
			return new VehicleLocationResponse[size];
		}
	};
}
