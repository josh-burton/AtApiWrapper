package api;

import retrofit.RestAdapter;
import util.Util;
import android.test.AndroidTestCase;

import com.atapiwrapper.library.BuildConfig;
import com.atapiwrapper.library.api.AtApi;
import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.realtime.vehiclelocations.VehicleLocationResponse;
import com.atapiwrapper.library.api.service.RealtimeService;

/**
 * Tests the realtime api requests and responses
 */
public class TATDisplays extends AndroidTestCase {

	private RestAdapter mRestAdapter;
	private RealtimeService mRealtimeService;

	@Override protected void setUp() throws Exception {
		super.setUp();

		AtApi api = new AtApi(BuildConfig.API_KEY);
		mRestAdapter = api.getRestAdapter(Util.getClient());
		mRealtimeService = mRestAdapter.create(RealtimeService.class);
	}

	public void testVehicleLocations() {

		ServerResponse<VehicleLocationResponse> result = mRealtimeService.vehiclelocations();

		//make sure we have content
		assertNotNull(result);
		assertNotNull(result.getStatus());
		assertEquals(result.getStatus(), ServerResponse.STATUS_OK);
		assertNotNull(result.getResponse());
		assertNotNull(result.getResponse().getVehicleLocations());
		assertTrue(result.getResponse().getVehicleLocations().size() > 0);
	}
	public void testVehicleLocationsByTripId() {

		ServerResponse<VehicleLocationResponse> result = mRealtimeService.vehiclelocationsByTripId("2212GW582020451266647");

		//make sure we have content
		assertNotNull(result);
		assertNotNull(result.getStatus());
		assertEquals(result.getStatus(), ServerResponse.STATUS_OK);
		assertNotNull(result.getResponse());
		assertNotNull(result.getResponse().getVehicleLocations());
		assertTrue(result.getResponse().getVehicleLocations().size() == 1);
	}

	public void testVehicleLocationsByVehicleId() {

		ServerResponse<VehicleLocationResponse> result = mRealtimeService.vehiclelocationsByTripId(
				"4f9abf121ddd83f8eeed3a42ac2e159615fe5b3800333d0b9ca51f38700d1678");

		//make sure we have content
		assertNotNull(result);
		assertNotNull(result.getStatus());
		assertEquals(result.getStatus(), ServerResponse.STATUS_OK);
		assertNotNull(result.getResponse());
		assertNotNull(result.getResponse().getVehicleLocations());
		assertTrue(result.getResponse().getVehicleLocations().size() == 1);
	}

}
