package com.atapiwrapper.library.api.service;

import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.display.ParkingLocation;
import com.atapiwrapper.library.api.model.display.ScheduledWork;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface DisplayService {

	//---------------------------------------
	//	Parking Locations
	//---------------------------------------

	/**
	 * 
	 * Returns parking locations in the Auckland region
	 * 
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 */

	@GET("/public/display/parkinglocations") ServerResponse<List<ParkingLocation>> parkingLocations();

	/**
	 * 
	 * Returns parking locations in the Auckland region
	 * 
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 * @param cb The callback that will be called when the request completes
	 */
	@GET("/public/display/parkinglocations") void parkingLocations(Callback<ServerResponse<List<ParkingLocation>>> cb);

	//---------------------------------------
	// Scheduled Works
	//---------------------------------------

	/**
	 *
	 * Returns scheduled works in the Auckland region. e.g. road works
	 *
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 */

	@GET("/public/display/scheduledworks") ServerResponse<List<ScheduledWork>> scheduledWorks();

	/**
	 *
	 * Returns scheduled works in the Auckland region. e.g. road works
	 *
	 * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
	 * @param cb The callback that will be called when the request completes
	 */
	@GET("/public/display/scheduledworks") void scheduledWorks(Callback<ServerResponse<List<ScheduledWork>>> cb);

}
