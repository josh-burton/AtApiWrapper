package com.atapiwrapper.sample.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.atapiwrapper.library.api.AtApi;
import com.atapiwrapper.library.api.model.ServerResponse;
import com.atapiwrapper.library.api.model.realtime.vehiclelocations.VehicleLocation;
import com.atapiwrapper.library.api.model.realtime.vehiclelocations.VehicleLocationResponse;
import com.atapiwrapper.library.api.service.RealtimeService;
import com.atapiwrapper.sample.R;

import java.util.ArrayList;
import java.util.List;

public class VehicleLocationListFragment extends ListFragment {

	private List<VehicleLocation> mVehicleLocations=new ArrayList<>();

	private VehicleLocationAdapter mAdapter;

	// TODO: Rename and change types of parameters
	public static VehicleLocationListFragment newInstance() {
		VehicleLocationListFragment fragment = new VehicleLocationListFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation changes).
	 */
	public VehicleLocationListFragment() {}

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//setup adapter
		mAdapter = new VehicleLocationAdapter(getActivity(), mVehicleLocations);
		setListAdapter(mAdapter);
	}

	@Override public void onResume() {
		super.onResume();
		//fetch the location
		new VehicleLocationAsyncTask().execute();
	}

	@Override public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override public void onDetach() {
		super.onDetach();
	}

	@Override public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
	}

	private class VehicleLocationAsyncTask extends AsyncTask<Void, Void, ServerResponse<VehicleLocationResponse>> {

		private VehicleLocationAsyncTask() {}

		@Override protected ServerResponse<VehicleLocationResponse> doInBackground(Void... params) {
			String apiKey = null;
			//todo: add your api key here

			if (null == apiKey) {
				throw new IllegalArgumentException("api key was null");
			}

			AtApi api = new AtApi(apiKey);//construct api object with our api key
			RealtimeService realtimeService = api.getRealtimeService(); //get the realtime service
			return realtimeService.vehiclelocations();//get vehicle locations synchronously
		}

		@Override protected void onPostExecute(ServerResponse<VehicleLocationResponse> response) {
			super.onPostExecute(response);
			if (response != null && response.getResponse() != null && response.getResponse().getVehicleLocations().size() > 0) {

				mVehicleLocations.clear();
				mVehicleLocations.addAll(response.getResponse().getVehicleLocations());
				mAdapter.notifyDataSetChanged();
			}
		}
	}

	public static class VehicleLocationAdapter extends ArrayAdapter<VehicleLocation> {

		public VehicleLocationAdapter(Context context, List<VehicleLocation> objects) {
			super(context, 0, objects);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			VehicleLocationWrapper vh = VehicleLocationWrapper.get(convertView, parent);
			VehicleLocation item = getItem(position);

			vh.id.setText(item.getVehicle().getVehicle().getId());
			vh.location.setText(String.format("%f, %f",item.getVehicle().getPosition().getLatitude(),
					item.getVehicle().getPosition().getLongitude()));

			return vh.root;
		}

		public static class VehicleLocationWrapper {
			public static VehicleLocationWrapper get(View convertView, ViewGroup parent) {
				if (convertView == null) {
					return new VehicleLocationWrapper(parent);
				}
				return (VehicleLocationWrapper) convertView.getTag();
			}

			public final View root;

			public final TextView id;
			public final TextView location;

			private VehicleLocationWrapper(ViewGroup parent) {
				root = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_location_row, parent, false);
				root.setTag(this);
				id = (TextView) root.findViewById(R.id.id_textview);//todo
				location = (TextView) root.findViewById(R.id.location_textview);//todo
			}
		}
	}

}
