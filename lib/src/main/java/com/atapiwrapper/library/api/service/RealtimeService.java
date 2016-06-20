package com.atapiwrapper.library.api.service;

import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.realtime.vehiclelocations.VehicleLocationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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

    @GET("public/realtime/vehiclelocations")
    Call<ServerResponse<VehicleLocationResponse>> vehicleLocations();

    //---------------------------------------
    //	Vehicle Locations - Trip id filter
    //---------------------------------------

    /**
     * Returns real-time GTFS vehicle locations in the Auckland region. Results for vehicle location based on trip id filter.
     *
     * @param tripId a comma separated list of trip ids
     * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
     */
    @GET("public/realtime/vehiclelocations")
    Call<ServerResponse<VehicleLocationResponse>> vehicleLocationsByTripId(
            @Query("tripid") String tripId);

    //---------------------------------------
    //	Vehicle Locations - Vehicle id filter
    //---------------------------------------

    /**
     * Returns real-time GTFS vehicle locations in the Auckland region. Results for vehicle location based on vehicle id filter.
     *
     * @param vehicleId a comma separated list of vehicle ids
     * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
     */
    @GET("public/realtime/vehiclelocations")
    Call<ServerResponse<VehicleLocationResponse>> vehicleLocationsByVehicleId(
            @Query("vehicleid") String vehicleId);

}
