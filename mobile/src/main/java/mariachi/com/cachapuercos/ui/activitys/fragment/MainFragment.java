package mariachi.com.cachapuercos.ui.activitys.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;
import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.model.PoliceMan;
import mariachi.com.cachapuercos.ui.activitys.payactivity.PayActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment
    implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

  private GoogleMap mMap;
  private List<PoliceMan> mPoliceManList;

  public static MainFragment newInstance() {
    return new MainFragment();
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    SupportMapFragment mapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);

    return view;
  }

  public void setUserMarket(LatLng latLng) {
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
  }

  @Override public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
        == PackageManager.PERMISSION_GRANTED
        || ActivityCompat.checkSelfPermission(getContext(),
        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
      mMap.setMyLocationEnabled(true);
    }

    showPolices(createListPoliceMan());
    mMap.setOnMarkerClickListener(this);
  }

  private void showPolices(List<PoliceMan> listPoliceMan) {

    for (PoliceMan policeMan : listPoliceMan) {
      mMap.addMarker(new MarkerOptions().title(policeMan.getName())
          .position(new LatLng(policeMan.getLatitude(), policeMan.getLongitude()))
          .icon(BitmapDescriptorFactory.fromResource(R.mipmap.police_indicator))

      );
    }
  }

  private List<PoliceMan> createListPoliceMan() {
    mPoliceManList = new ArrayList<>();

    mPoliceManList.add(new PoliceMan("Pedro Henandez Garcia", 19.412800, -99.166197,
        "http://mxcdn02.mundotkm.com/2015/12/poli_poliglota_df3.jpg", 5, "Muy honesto."));

    mPoliceManList.add(new PoliceMan("Jose Perez Moreno", 19.415027, -99.163464,
        "https://i.ytimg.com/vi/fXNEB8Ce_qQ/hqdefault.jpg", 3, "Acepta chantajes o mordidas"));

    mPoliceManList.add(new PoliceMan("Antonio Lopez Satiago", 19.411043, -99.164409,
        "https://static-lacuarta-qa.s3.amazonaws.com/wp-content/uploads/sites/5/2014/07/22/1978766.jpg",
        1, "Corructo, siempre obrece chntajes"));

    return mPoliceManList;
  }

  @Override public boolean onMarkerClick(Marker marker) {

    int position = getPositionFromId(marker.getId());

    Intent intent = new Intent(getContext(), PayActivity.class);
    intent.putExtra("Police", mPoliceManList.get(position));
    startActivity(intent);

    return false;
  }

  private int getPositionFromId(String id) {
    return Integer.parseInt(id.substring(1, id.length()));
  }
}
