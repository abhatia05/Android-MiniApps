package com.example.ashishbhatia.whereiam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    LocationManager lmgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Log.i("TAG","First");
        lmgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (lmgr.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            lmgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double longitude = location.getLongitude();
                    double latitude = location.getLatitude();

                    Log.i("TAG", String.valueOf(longitude));
                    Log.i("TAG", String.valueOf(latitude));

                    LatLng latlng = new LatLng(latitude, longitude);

                    Geocoder gc = new Geocoder(getApplicationContext());
                    try {
                        Log.i("T","Network Provider");
                        List<Address> addresslist = gc.getFromLocation(latitude, longitude, 1);


                        String str = addresslist.get(0).getLocality();
                        str += addresslist.get(0).getCountryName();
                        Log.i("Tag",str);
                        mMap.addMarker(new MarkerOptions().position(latlng).title(str));
                        CameraUpdate loc = CameraUpdateFactory.newLatLngZoom(latlng,13.2F);
                        mMap.animateCamera(loc);
                       // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,13.2F));

                    } catch (IOException e) {
                        Log.i("TAG","ERROR");
                        e.printStackTrace();
                    }


                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }


            });
        } else if (lmgr.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            lmgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double longitude = location.getLongitude();
                    double latitude = location.getLatitude();

                    Log.i("TAG","GPS_PROVIDER");

                    LatLng latlng = new LatLng(latitude, longitude);


                    Geocoder gc = new Geocoder(getApplicationContext());
                    try {
                        Log.i("T","GPS Provider");
                        List<Address> addresslist = gc.getFromLocation(latitude, longitude, 1);

                        String str = addresslist.get(0).getLocality();
                        str += addresslist.get(0).getCountryName();

                        mMap.addMarker(new MarkerOptions().position(latlng).title("My House"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,10.2F));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }

            });

        }

    }
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady (GoogleMap googleMap){
            mMap = googleMap;

            // Add a marker in Sydney and move the camera

          //   LatLng sydney = new LatLng(-34, 151);
          //   mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
          //   mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    }
