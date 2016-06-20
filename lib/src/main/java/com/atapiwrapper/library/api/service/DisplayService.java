package com.atapiwrapper.library.api.service;

import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.display.ParkingLocation;
import com.atapiwrapper.library.api.model.display.ScheduledWork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DisplayService {

    //---------------------------------------
    //	Parking Locations
    //---------------------------------------

    /**
     * Returns parking locations in the Auckland region
     *
     * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
     */

    @GET("public/display/parkinglocations")
    Call<ServerResponse<List<ParkingLocation>>> parkingLocations();

    //---------------------------------------
    // Scheduled Works
    //---------------------------------------

    /**
     * Returns scheduled works in the Auckland region. e.g. road works
     *
     * @return {@link com.atapiwrapper.library.api.model.ServerResponse}
     */

    @GET("public/display/scheduledworks")
    Call<ServerResponse<List<ScheduledWork>>> scheduledWorks();

}
