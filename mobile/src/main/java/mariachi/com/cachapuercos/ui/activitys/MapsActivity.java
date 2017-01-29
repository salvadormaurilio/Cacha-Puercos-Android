package mariachi.com.cachapuercos.ui.activitys;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import mariachi.com.cachapuercos.R;
import mariachi.com.cachapuercos.ui.activitys.fragment.MainFragment;

public class MapsActivity extends FragmentActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks,LocationListener {

    GoogleApiClient mGoogleApiClient;
    final int PERMISSIONLOC=111;
    private MainFragment mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.container_main);
        getMapFragment();
    }
    private void getMapFragment() {
        if (mainFragment==null)
        {
            mainFragment= MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_main,mainFragment)
                    .commit();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            getPermissions();
        }else {
            startLocationServices();
        }

    }

    private void getPermissions() {
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},PERMISSIONLOC);
        Log.e("Rquesting","permissions");
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.e("Location its","latitud "+location.getLatitude()+"longitud "+location.getLongitude());
        mainFragment.setUserMarket(new LatLng(location.getLatitude(),location.getLongitude()));
    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    private void startLocationServices(){
        Log.e("MAPS","Starting connection  location detector");
        try {

            LocationRequest locationRequest = LocationRequest.create().setPriority(LocationRequest.PRIORITY_LOW_POWER);
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,locationRequest,this);

            Log.e("MAPS","Starting location obtained");
        }catch(SecurityException exception){

            Log.e("MAPS","Starting location denaied");
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSIONLOC :
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    startLocationServices();
                }else{

                }
                break;
        }
    }
}
