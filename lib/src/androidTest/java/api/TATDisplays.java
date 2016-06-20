package api;

import android.test.AndroidTestCase;

import com.atapiwrapper.library.api.AtApi;
import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.display.ParkingLocation;
import com.atapiwrapper.library.api.model.display.ScheduledWork;
import com.atapiwrapper.library.api.service.DisplayService;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import util.Util;

/**
 * Tests the realtime api requests and responses
 */
public class TATDisplays extends AndroidTestCase {

    private Retrofit mRestAdapter;
    private DisplayService mDisplayService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        AtApi api = new AtApi("");
        mRestAdapter = api.getRestAdapter(Util.getClient());
        mDisplayService = mRestAdapter.create(DisplayService.class);
    }

    public void testParkingLocations() {

        Response<ServerResponse<List<ParkingLocation>>> response = null;
        try {
            response = mDisplayService.parkingLocations().execute();

            ServerResponse<List<ParkingLocation>> result = response.body();
            //make sure we have content
            assertNotNull(result);
            assertNotNull(result.getStatus());
            assertEquals(result.getStatus(), ServerResponse.STATUS_OK);
            assertNotNull(result.getResponse());
            assertTrue(result.getResponse().size() > 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testScheduledWorks() {
        try {
            Response<ServerResponse<List<ScheduledWork>>> response = mDisplayService.scheduledWorks().execute();

            ServerResponse<List<ScheduledWork>> result = response.body();

            //make sure we have content
            assertNotNull(result);
            assertNotNull(result.getStatus());
            assertEquals(result.getStatus(), ServerResponse.STATUS_OK);
            assertNotNull(result.getResponse());
            assertTrue(result.getResponse().size() > 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
