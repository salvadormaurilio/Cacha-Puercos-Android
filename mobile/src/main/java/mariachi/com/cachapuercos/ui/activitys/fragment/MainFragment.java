package mariachi.com.cachapuercos.ui.activitys.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.model.LocationsSample;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private MarkerOptions markerOptions;

    Bundle args;




    public MainFragment() {
        // Required empty public constructor
    }



    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        args = getArguments();
        int index = args.getInt("index", 0);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(lat,longi);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    public void setUserMarket(LatLng latLng){
        if (markerOptions==null){
            markerOptions = new MarkerOptions().position(latLng).title("Hola Eder");
            mMap.addMarker(markerOptions);

        }
        //updateMApForZip(06470);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,18));
    }

   // private void updateMApForZip(int zipCode){
   //     ArrayList<LocationsSample> locationsSamples = DataService.getInstance().getLocationWith10MilesOfZip(zipCode);
   //     for (int i =0; i<locationsSamples.size();i++){
   //         LocationsSample locationsSample = locationsSamples.get(i);
   //         MarkerOptions markerOptions = new MarkerOptions().position(new LatLng(locationsSample.getLatitud(),locationsSample.getLongitude()));
   //         markerOptions.title(locationsSample.getLocationAddress());
   //         markerOptions.snippet(locationsSample.getLocationAddress());
   //         markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin));
   //         mMap.addMarker(markerOptions);
   //     }
   // }


}
