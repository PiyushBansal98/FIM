package com.example.piyush.fim;
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
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);//use operating system service .location manager is hardware component

        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {// network provider works indoor,gps provider works outdoor
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);//if we wont give permission app will crash
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double lat= location.getLatitude();//get latitude
                    double  lng=location.getLongitude();// holds current location latlng
                    LatLng latLng=new LatLng(lat,lng);//latlong class
                    Geocoder geocoder= new Geocoder(getApplicationContext());// it is class which is used to convert current latitude variable into address
                    try {
                        List<Address>addressList = geocoder.getFromLocation(lat,lng,1);//list is generic with address class
                        String str1= addressList.get(0).getCountryName();
                        str1+= addressList.get(0).getLocality();
                        str1+= addressList.get(0).getSubLocality();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str1));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10.2f));// update the map

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }
        else if (locationManager.isProviderEnabled(locationManager.GPS_PROVIDER))
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double lat= location.getLatitude();
                    double  lng=location.getLongitude();
                    LatLng latLng=new LatLng(lat,lng);
                    Geocoder geocoder= new Geocoder(getApplicationContext());
                    try {
                        List<Address>addressList = geocoder.getFromLocation(lat,lng,1);
                        String str1= addressList.get(0).getCountryName();
                        str1+= addressList.get(0).getLocality();
                        str1+= addressList.get(0).getSubLocality();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str1));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10.2f));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}