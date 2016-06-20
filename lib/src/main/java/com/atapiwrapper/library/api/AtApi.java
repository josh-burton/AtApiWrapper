package com.atapiwrapper.library.api;

import com.atapiwrapper.library.api.model.geometry.Geometry;
import com.atapiwrapper.library.api.model.geometry.GeometryDeserializer;
import com.atapiwrapper.library.api.service.DisplayService;
import com.atapiwrapper.library.api.service.GtfsService;
import com.atapiwrapper.library.api.service.RealtimeService;
import com.atapiwrapper.library.core.ATConstants;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Main entry point to interact with the AT Api
 */
public class AtApi {

    private final String mApiKey;
    private Retrofit retrofit;

    /**
     * @param apiKey
     */
    public AtApi(String apiKey) {
        mApiKey = apiKey;
    }

    /**
     * Get the rest adapter to make requests to the api
     **/

    public Retrofit getRestAdapter() {
        return getRestAdapter(null);
    }

    /**
     * Get the rest adapter to make requests to the api
     *
     * @param client an ok http client to use for the requests (optional)
     * @return
     */
    public Retrofit getRestAdapter(OkHttpClient client) {
        //set custom client
        if (null == client) {
            client = new OkHttpClient();
        }

        //setup mapper which uses custom deserializer
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //setup custom deserializer module to handle geometry
        SimpleModule module = new SimpleModule("GeometryDeserializerModule", new Version(1, 0, 0, null));
        module.addDeserializer(Geometry.class, new GeometryDeserializer());
        mapper.registerModule(module);

        JacksonConverterFactory converter = JacksonConverterFactory.create(mapper);

        OkHttpClient.Builder clientBuilder = client.newBuilder();
        clientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", mApiKey)
                        .build();
                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        Retrofit.Builder restAdapter = new Retrofit.Builder()
                .baseUrl(ATConstants.ENDPOINT)
                .addConverterFactory(converter)
                .client(clientBuilder.build());

        return restAdapter.build();
    }

    public RealtimeService getRealtimeService() {
        if (null == retrofit) retrofit = getRestAdapter();
        return retrofit.create(RealtimeService.class);
    }

    public GtfsService getGtfsService() {
        if (null == retrofit) retrofit = getRestAdapter();
        return retrofit.create(GtfsService.class);
    }

    public DisplayService getDisplaysService() {
        if (null == retrofit) retrofit = getRestAdapter();
        return retrofit.create(DisplayService.class);
    }

}
