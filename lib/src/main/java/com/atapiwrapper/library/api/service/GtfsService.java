package com.atapiwrapper.library.api.service;

import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.gtfs.Agency;
import com.atapiwrapper.library.api.model.gtfs.Calendar;
import com.atapiwrapper.library.api.model.gtfs.CalendarException;
import com.atapiwrapper.library.api.model.gtfs.Route;
import com.atapiwrapper.library.api.model.gtfs.ShapePoint;
import com.atapiwrapper.library.api.model.gtfs.Stop;
import com.atapiwrapper.library.api.model.gtfs.StopTime;
import com.atapiwrapper.library.api.model.gtfs.Trip;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GtfsService {

	//---------------------------------------
	//	Agencies
	//---------------------------------------

	/**
	 * List of the transit agencies that provide the data in this feed.
	 */
	@GET("gtfs/agency")
	Call<ServerResponse<List<Agency>>> agencies();

	//---------------------------------------
	//	Calendars
	//---------------------------------------
	/**
	 * Dates for service IDs using a weekly schedule. Specify when service starts and ends, as well as days of the week where service is
	 * available.
	 * 
	 * @return list of calendars
	 */
	@GET("gtfs/calendar") Call<ServerResponse<List<Calendar>>> calendars();

	//---------------------------------------
	//	Calendars By Service Id
	//---------------------------------------

	/**
	 * Dates for service IDs using a weekly schedule. Specify when service starts and ends, as well as days of the week where service is
	 * available, filtered by service id
	 * 
	 * @return list of calendars
	 */
	@GET("gtfs/calendar/serviceId/{serviceId}") Call<ServerResponse<List<Calendar>>> calendarsByServiceId(@Path("serviceId") String serviceId);

	//---------------------------------------
	//	Calendar Exceptions
	//---------------------------------------

	/**
	 * 
	 * @return list of calendars
	 */
	@GET("gtfs/calendarDate") Call<ServerResponse<List<CalendarException>>> calendarExceptions();

	//---------------------------------------
	//	Calendar Exceptions By Service Id
	//---------------------------------------

	/**
	 * Exceptions for the service IDs defined in the calendar list
	 * 
	 * @return list of calendars
	 */
	@GET("gtfs/calendarDate/serviceId/{serviceId}") Call<ServerResponse<List<CalendarException>>> calendarExceptionsByServiceId(
			@Path("serviceId") String serviceId);

	//---------------------------------------
	// Routes
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("gtfs/routes") Call<ServerResponse<List<Route>>> routes();

	//---------------------------------------
	// Routes filtered by id
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("gtfs/routes/routeId/{routeId}") Call<ServerResponse<List<Route>>> routesById(@Path("routeId") String routeId);

	//---------------------------------------
	// Routes filtered by long name
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("gtfs/routes/routeLongName/{routeLongName}") Call<ServerResponse<List<Route>>> routesByLongName(
			@Path("routeLongName") String routeLongName);

	//---------------------------------------
	// Routes search
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("gtfs/routes/search/{query}") Call<ServerResponse<List<Route>>> routesSearch(@Path("query") String query);

	//---------------------------------------
	// Routes geo search
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("gtfs/routes/geosearch") Call<ServerResponse<List<Route>>> routesGeoSearch(@Query("lat") Double lat, @Query("lng") Double lng,
																			   @Query("distance") Double distance);

	//---------------------------------------
	// Routes search by stop id
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("gtfs/routes/stopid/{stopId}") Call<ServerResponse<List<Route>>> routesSearchByStopId(@Path("stopId") String stopId);

	//---------------------------------------
	// Stops
	//---------------------------------------

	/**
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @return list of stops
	 */
	@GET("gtfs/stops") Call<ServerResponse<List<Stop>>> stops();

	//---------------------------------------
	// Stops by id
	//---------------------------------------

	/**
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @return list of stops
	 */
	@GET("gtfs/stops/stopId/{stopid}") Call<ServerResponse<List<Stop>>> stopsById(@Path("stopid") String stopId);

	//---------------------------------------
	// Stops by stop code
	//---------------------------------------

	/**
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @return list of stops
	 */
	@GET("gtfs/stops/stopCode/{code}") Call<ServerResponse<List<Stop>>> stopsByCode(@Path("code") String stopCode);

	//---------------------------------------
	// Stop search by name
	//---------------------------------------

	/**
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @return list of stops
	 */
	@GET("gtfs/stops/search/{name}") Call<ServerResponse<List<Stop>>> stopSearchByName(@Path("name") String stopName);

	//---------------------------------------
	// Stop times by stop id
	//---------------------------------------

	/**
	 * List of times that a vehicle arrives at and departs from individual stops for each trip, filtered by stop id
	 * 
	 * @return list of stop times
	 */
	@GET("gtfs/stopTimes/stopId/{stopid}") Call<ServerResponse<List<StopTime>>> stopTimesByStopId(@Path("stopid") String stopId);

	//---------------------------------------
	// Stop times by trip id
	//---------------------------------------

	/**
	 * List of times that a vehicle arrives at and departs from individual stops for each trip, filtered by trip id
	 * 
	 * @return list of stop times
	 */
	@GET("gtfs/stopTimes/tripId/{tripid}") Call<ServerResponse<List<StopTime>>> stopTimesByTripId(@Path("tripid") String tripid);

	//---------------------------------------
	// Trips
	//---------------------------------------

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @return list of trips
	 */
	@GET("gtfs/trips") Call<ServerResponse<List<Trip>>> trips();

	//---------------------------------------
	// Trips by trip id
	//---------------------------------------

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @return list of trips
	 */
	@GET("gtfs/trips/tripId/{tripid}") Call<ServerResponse<List<Trip>>> tripsByTripId(@Path("tripid") String tripId);

	//---------------------------------------
	// Trips by route id
	//---------------------------------------

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @return list of trips
	 */
	@GET("gtfs/trips/routeid/{routeid}") Call<ServerResponse<List<Trip>>> tripsByRouteid(@Path("routeid") String routeid);

    //---------------------------------------
    // Shapes by id
    //---------------------------------------

    /**
     * List of points in the given shape
     *
     * @param shapeId - the tripId of the desired shape
     */
    @GET("gtfs/shapes/shapeId/{shapeId}") Call<ServerResponse<List<ShapePoint>>> shapeById(@Path("shapeId") String shapeId);

    //---------------------------------------
    // Shapes by trip id
    //---------------------------------------

    /**
     * List of points in the shape for a given tripId
     *
     * @param tripId - the tripId of the desired shape
     */
    @GET("gtfs/shapes/tripId/{tripId}") Call<ServerResponse<List<ShapePoint>>> shapeByTripId(@Path("tripId") String tripId);


}
