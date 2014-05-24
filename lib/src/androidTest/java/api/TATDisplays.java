package api;

import android.test.AndroidTestCase;

import com.atapiwrapper.library.BuildConfig;
import com.atapiwrapper.library.api.AtApi;
import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.display.ParkingLocation;
import com.atapiwrapper.library.api.model.display.ScheduledWork;
import com.atapiwrapper.library.api.service.DisplayService;

import java.util.List;

import retrofit.RestAdapter;
import util.Util;

/**
 * Tests the realtime api requests and responses
 */
public class TATDisplays extends AndroidTestCase {

	private RestAdapter mRestAdapter;
	private DisplayService mDisplayService;

	@Override protected void setUp() throws Exception {
		super.setUp();

		AtApi api = new AtApi(BuildConfig.API_KEY);
		mRestAdapter = api.getRestAdapter(Util.getClient());
		mDisplayService = mRestAdapter.create(DisplayService.class);
	}

	public void testParkingLocations() {

		ServerResponse<List<ParkingLocation>> result = mDisplayService.parkingLocations();

		//make sure we have content
		assertNotNull(result);
		assertNotNull(result.getStatus());
		assertEquals(result.getStatus(), ServerResponse.STATUS_OK);
		assertNotNull(result.getResponse());
		assertTrue(result.getResponse().size() > 0);
	}

	public void testScheduledWorks() {
		ServerResponse<List<ScheduledWork>> result = mDisplayService.scheduledWorks();

		//make sure we have content
		assertNotNull(result);
		assertNotNull(result.getStatus());
		assertEquals(result.getStatus(), ServerResponse.STATUS_OK);
		assertNotNull(result.getResponse());
		assertTrue(result.getResponse().size() > 0);
	}

}
