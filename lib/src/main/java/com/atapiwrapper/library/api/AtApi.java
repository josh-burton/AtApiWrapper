package com.atapiwrapper.library.api;

import com.atapiwrapper.library.api.model.geometry.Geometry;
import com.atapiwrapper.library.api.model.geometry.GeometryDeserializer;
import com.atapiwrapper.library.api.service.DisplayService;
import com.atapiwrapper.library.api.service.GtfsService;
import com.atapiwrapper.library.api.service.RealtimeService;
import com.atapiwrapper.library.core.ATConstants;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jakewharton.retrofit.Ok3Client;

import okhttp3.OkHttpClient;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

/**
 * Main entry point to interact with the AT Api
 */
public class AtApi {

	private final String mApiKey;
	private RestAdapter mRestAdapter;

	/**
	 * 
	 * @param apiKey
	 */
	public AtApi(String apiKey) {
		mApiKey = apiKey;
	}

	/**
	 * Get the rest adapter to make requests to the api
	 **/

	public RestAdapter getRestAdapter() {
		return getRestAdapter(null);
	}

	/**
	 * Get the rest adapter to make requests to the api
	 * 
	 * @param client an ok http client to use for the requests (optional)
	 * 
	 * @return
	 */
	public RestAdapter getRestAdapter(OkHttpClient client) {
		//setup mapper which uses custom deserializer
		final ObjectMapper mapper = new ObjectMapper();

		//setup custom deserializer module to handle geometry
		SimpleModule module = new SimpleModule("GeometryDeserializerModule", new Version(1, 0, 0, null));
		module.addDeserializer(Geometry.class, new GeometryDeserializer());
		mapper.registerModule(module);

		JacksonConverter converter = new JacksonConverter(mapper);

		//request interceptor that will add an api key to every request
		RequestInterceptor requestInterceptor = new RequestInterceptor() {
			@Override public void intercept(RequestFacade request) {
				request.addQueryParam("api_key", mApiKey);
			}
		};

		RestAdapter.Builder restAdapter = new RestAdapter.Builder().setEndpoint(ATConstants.ENDPOINT).setConverter(converter)
				.setRequestInterceptor(requestInterceptor);

		//set custom client
		if (null != client) restAdapter.setClient(new Ok3Client(client));
		return restAdapter.build();
	}

	public RealtimeService getRealtimeService() {
		if (null == mRestAdapter) mRestAdapter = getRestAdapter();
		return mRestAdapter.create(RealtimeService.class);
	}

	public GtfsService getGtfsService() {
		if (null == mRestAdapter) mRestAdapter = getRestAdapter();
		return mRestAdapter.create(GtfsService.class);
	}

	public DisplayService getDisplaysService() {
		if (null == mRestAdapter) mRestAdapter = getRestAdapter();
		return mRestAdapter.create(DisplayService.class);
	}

}
