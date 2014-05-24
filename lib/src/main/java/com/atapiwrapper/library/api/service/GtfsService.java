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

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface GtfsService {

	//---------------------------------------
	//	Agencies
	//---------------------------------------

	/**
	 * List of the transit agencies that provide the data in this feed.
	 * 
	 * @return list of agencies
	 */
	@GET("/gtfs/agency") ServerResponse<List<Agency>> agencies();

	/**
	 * List of the transit agencies that provide the data in this feed.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/agency") void agencies(Callback<ServerResponse<List<Agency>>> cb);

	//---------------------------------------
	//	Calendars
	//---------------------------------------
	/**
	 * Dates for service IDs using a weekly schedule. Specify when service starts and ends, as well as days of the week where service is
	 * available.
	 * 
	 * @return list of calendars
	 */
	@GET("/gtfs/calendar") ServerResponse<List<Calendar>> calendars();

	/**
	 * Dates for service IDs using a weekly schedule. Specify when service starts and ends, as well as days of the week where service is
	 * available.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/calendar") void calendars(Callback<ServerResponse<List<Calendar>>> cb);

	//---------------------------------------
	//	Calendars By Service Id
	//---------------------------------------

	/**
	 * Dates for service IDs using a weekly schedule. Specify when service starts and ends, as well as days of the week where service is
	 * available, filtered by service id
	 * 
	 * @return list of calendars
	 */
	@GET("/gtfs/calendar/serviceId/{serviceId}") ServerResponse<List<Calendar>> calendarsByServiceId(@Path("serviceId") String serviceId);

	/**
	 * 
	 * Dates for service IDs using a weekly schedule. Specify when service starts and ends, as well as days of the week where service is
	 * available, filtered by service id
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/calendar/serviceId/{serviceId}") void calendarByServiceId(@Path("serviceId") String serviceId,
			Callback<ServerResponse<List<Calendar>>> cb);

	//---------------------------------------
	//	Calendar Exceptions
	//---------------------------------------

	/**
	 * 
	 * @return list of calendars
	 */
	@GET("/gtfs/calendarDate") ServerResponse<List<CalendarException>> calendarExceptions();

	/**
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/calendarDate") void calendarExceptions(Callback<ServerResponse<List<CalendarException>>> cb);

	//---------------------------------------
	//	Calendar Exceptions By Service Id
	//---------------------------------------

	/**
	 * Exceptions for the service IDs defined in the calendar list
	 * 
	 * @return list of calendars
	 */
	@GET("/gtfs/calendarDate/serviceId/{serviceId}") ServerResponse<List<CalendarException>> calendarExceptionsByServiceId(
			@Path("serviceId") String serviceId);

	/**
	 * 
	 * Exceptions for the service IDs defined in the calendar list
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/calendarDate/serviceId/{serviceId}") void calendarExceptionsByServiceId(@Path("serviceId") String serviceId,
			Callback<ServerResponse<List<CalendarException>>> cb);

	//---------------------------------------
	// Routes
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("/gtfs/routes") ServerResponse<List<Route>> routes();

	/**
	 * 
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/routes") void routes(Callback<ServerResponse<List<Route>>> cb);

	//---------------------------------------
	// Routes filtered by id
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("/gtfs/routes/routeId/{routeId}") ServerResponse<List<Route>> routesById(@Path("routeId") String routeId);

	/**
	 * 
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/routes/routeId/{routeId}") void routesById(@Path("routeId") String routeId, Callback<ServerResponse<List<Route>>> cb);

	//---------------------------------------
	// Routes filtered by long name
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("/gtfs/routes/routeLongName/{routeLongName}") ServerResponse<List<Route>> routesByLongName(
			@Path("routeLongName") String routeLongName);

	/**
	 * 
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/routes/routeLongName/{routeLongName}") void routesByLongName(@Path("routeLongName") String routeLongName,
			Callback<ServerResponse<List<Route>>> cb);

	//---------------------------------------
	// Routes search
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("/gtfs/routes/search/{query}") ServerResponse<List<Route>> routesSearch(@Path("query") String query);

	/**
	 * 
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/routes/search/{query}") void routesSearch(@Path("query") String query, Callback<ServerResponse<List<Route>>> cb);

	//---------------------------------------
	// Routes geo search
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("/gtfs/routes/geosearch") ServerResponse<List<Route>> routesGeoSearch(@Query("lat") Double lat, @Query("lng") Double lng,
			@Query("distance") Double distance);

	/**
	 * 
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/routes/geosearch") void routesGeoSearch(@Query("lat") Double lat, @Query("lng") Double lng,
			@Query("distance") Double distance, Callback<ServerResponse<List<Route>>> cb);

	//---------------------------------------
	// Routes search by stop id
	//---------------------------------------

	/**
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @return list of routes
	 */
	@GET("/gtfs/routes/stopid/{stopId}") ServerResponse<List<Route>> routesSearchByStopId(@Path("stopId") String stopId);

	/**
	 * 
	 * Transit routes. A route is a group of trips that are displayed to riders as a single service.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/routes/stopid/{stopId}") void routesSearchByStopId(@Path("stopId") String stopId, Callback<ServerResponse<List<Route>>> cb);

	//---------------------------------------
	// Stops
	//---------------------------------------

	/**
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @return list of stops
	 */
	@GET("/gtfs/stops") ServerResponse<List<Stop>> stops();

	/**
	 * 
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/stops") void stops(Callback<ServerResponse<List<Stop>>> cb);

	//---------------------------------------
	// Stops by id
	//---------------------------------------

	/**
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @return list of stops
	 */
	@GET("/gtfs/stops/stopId/{stopid}") ServerResponse<List<Stop>> stopsById(@Path("stopid") String stopId);

	/**
	 * 
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/stops/stopId/{stopid}") void stopsById(@Path("stopid") String stopId, Callback<ServerResponse<List<Stop>>> cb);

	//---------------------------------------
	// Stops by stop code
	//---------------------------------------

	/**
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @return list of stops
	 */
	@GET("/gtfs/stops/stopCode/{code}") ServerResponse<List<Stop>> stopsByCode(@Path("code") String stopCode);

	/**
	 * 
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/stops/stopCode/{code}") void stopsByCode(@Path("code") String stopCode, Callback<ServerResponse<List<Stop>>> cb);

	//---------------------------------------
	// Stop search by name
	//---------------------------------------

	/**
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @return list of stops
	 */
	@GET("/gtfs/stops/search/{name}") ServerResponse<List<Stop>> stopSearchByName(@Path("name") String stopName);

	/**
	 * 
	 * List of individual locations where vehicles pick up or drop off passengers.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/stops/search/{name}") void stopSearchByName(@Path("name") String stopName, Callback<ServerResponse<List<Stop>>> cb);

	//---------------------------------------
	// Stop times by stop id
	//---------------------------------------

	/**
	 * List of times that a vehicle arrives at and departs from individual stops for each trip, filtered by stop id
	 * 
	 * @return list of stop times
	 */
	@GET("/gtfs/stopTimes/stopId/{stopid}") ServerResponse<List<StopTime>> stopTimesByStopId(@Path("stopid") String stopId);

	/**
	 * List of times that a vehicle arrives at and departs from individual stops for each trip, filtered by stop id
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/stopTimes/stopId/{stopid}") void stopTimesByStopId(@Path("stopid") String stopId,
			Callback<ServerResponse<List<StopTime>>> cb);

	//---------------------------------------
	// Stop times by trip id
	//---------------------------------------

	/**
	 * List of times that a vehicle arrives at and departs from individual stops for each trip, filtered by trip id
	 * 
	 * @return list of stop times
	 */
	@GET("/gtfs/stopTimes/tripId/{tripid}") ServerResponse<List<StopTime>> stopTimesByTripId(@Path("tripid") String tripid);

	/**
	 * List of times that a vehicle arrives at and departs from individual stops for each trip, filtered by trip id
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/stopTimes/tripId/{tripid}") void stopTimesByTripId(@Path("tripid") String tripid,
			Callback<ServerResponse<List<StopTime>>> cb);

	//---------------------------------------
	// Trips
	//---------------------------------------

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @return list of trips
	 */
	@GET("/gtfs/trips") ServerResponse<List<Trip>> trips();

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/trips") void trips(Callback<ServerResponse<List<Trip>>> cb);

	//---------------------------------------
	// Trips by trip id
	//---------------------------------------

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @return list of trips
	 */
	@GET("/gtfs/trips/tripId/{tripid}") ServerResponse<List<Trip>> tripsByTripId(@Path("tripid") String tripId);

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/trips/tripId/{tripid}") void tripsByTripId(@Path("tripid") String tripId, Callback<ServerResponse<List<Trip>>> cb);

	//---------------------------------------
	// Trips by route id
	//---------------------------------------

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @return list of trips
	 */
	@GET("/gtfs/trips/routeid/{routeid}") ServerResponse<List<Trip>> tripsByRouteid(@Path("routeid") String routeid);

	/**
	 * List of trips for each route. A trip is a sequence of two or more stops that occurs at specific time.
	 * 
	 * @param cb - callback that gets called on request complete
	 */
	@GET("/gtfs/trips/routeid/{routeid}") void tripsByRouteid(@Path("routeid") String routeid, Callback<ServerResponse<List<Trip>>> cb);

    //---------------------------------------
    // Shapes by id
    //---------------------------------------

    /**
     * List of points in the given shape
     *
     * @param shapeId - the tripId of the desired shape
     * @param cb - callback that gets called on request complete
     */
    @GET("/gtfs/shapes/shapeId/{shapeId}") void shapeById(@Path("shapeId") String shapeId, Callback<ServerResponse<List<ShapePoint>>> cb);

    /**
     * List of points in the given shape
     *
     * @param shapeId - the tripId of the desired shape
     */
    @GET("/gtfs/shapes/shapeId/{shapeId}") ServerResponse<List<ShapePoint>> shapeById(@Path("shapeId") String shapeId);

    //---------------------------------------
    // Shapes by trip id
    //---------------------------------------

    /**
     * List of points in the shape for a given tripId
     *
     * @param tripId - the tripId of the desired shape
     * @param cb - callback that gets called on request complete
     */
    @GET("/gtfs/shapes/tripId/{tripId}") void shapeByTripId(@Path("tripId") String tripId, Callback<ServerResponse<List<ShapePoint>>> cb);

    /**
     * List of points in the shape for a given tripId
     *
     * @param tripId - the tripId of the desired shape
     */
    @GET("/gtfs/shapes/tripId/{tripId}") ServerResponse<List<ShapePoint>> shapeByTripId(@Path("tripId") String tripId);


}
