package com.atapiwrapper.library.api.service;

import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.realtime.vehiclelocations.VehicleLocationResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RealtimeService {

	//---------------------------------------
	//	Vehicle Locations
	//---------------------------------------

	/**
	 * Returns real-time GTFS vehicle locations in the Auckland region. Returns a 30 second window of results otherwise returns results for
	 * vehicle location based on filter.
	 * 
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 */

	@GET("/public/realtime/vehiclelocations") ServerResponse<VehicleLocationResponse> vehicleLocations();

	/**
	 * Returns real-time GTFS vehicle locations in the Auckland region. Returns a 30 second window of results otherwise returns results for
	 * vehicle location based on filter.
	 * 
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 * @param cb The callback that will be called when the request completes
	 */
	@GET("/public/realtime/vehiclelocations") void vehicleLocations(Callback<ServerResponse<VehicleLocationResponse>> cb);

	//---------------------------------------
	//	Vehicle Locations - Trip id filter
	//---------------------------------------

	/**
	 * Returns real-time GTFS vehicle locations in the Auckland region. Results for vehicle location based on trip id filter.
	 * 
	 * @param tripId a comma separated list of trip ids
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 */
	@GET("/public/realtime/vehiclelocations") ServerResponse<VehicleLocationResponse> vehicleLocationsByTripId(
			@Query("tripid") String tripId);

	/**
	 * Returns real-time GTFS vehicle locations in the Auckland region. Results for vehicle location based on trip id filter.
	 * 
	 * @param tripId a comma separated list of trip ids
	 * @param cb The callback that will be called when the request completes
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 */
	@GET("/public/realtime/vehiclelocations") void vehicleLocationsByTripId(@Query("tripid") String tripId,
			Callback<ServerResponse<VehicleLocationResponse>> cb);

	//---------------------------------------
	//	Vehicle Locations - Vehicle id filter
	//---------------------------------------

	/**
	 * Returns real-time GTFS vehicle locations in the Auckland region. Results for vehicle location based on vehicle id filter.
	 * 
	 * @param vehicleId a comma separated list of vehicle ids
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 */
	@GET("/public/realtime/vehiclelocations") ServerResponse<VehicleLocationResponse> vehicleLocationsByVehicleId(
			@Query("vehicleid") String vehicleId);

	/**
	 * Returns real-time GTFS vehicle locations in the Auckland region. Results for vehicle location based on vehicle id filter.
	 * 
	 * @param vehicleId a comma separated list of vehicle ids
	 * @param cb The callback that will be called when the request completes
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 */
	@GET("/public/realtime/vehiclelocations") void vehicleLocationsByVehicleId(@Query("vehicleid") String vehicleId,
			Callback<ServerResponse<VehicleLocationResponse>> cb);

}
