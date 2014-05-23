package com.atapiwrapper.library.api.model.realtime.vehiclelocations;


import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleLocation {
	@JsonProperty("id") private String id;
	@JsonProperty("is_deleted") private Boolean is_deleted;
	@JsonProperty("vehicle") private Vehicle vehicle;

	public String getId() {
		return id;
	}

	public Boolean isDeleted() {
		return is_deleted;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}
