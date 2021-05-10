package com.example.uasgis;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Masjidnurulfalah = new LatLng(-2.562192, 121.957267);
        LatLng Masjidnurulhudah = new LatLng(-2.5583346, 121.9657744);
        LatLng rumahku = new LatLng(-2.559508, 121.962031);

        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_hitam);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_merah);
        BitmapDrawable bitmapMe = (BitmapDrawable)getResources().getDrawable(R.drawable.rumaku);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap m = bitmapMe.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);
        Bitmap markerMe = Bitmap.createScaledBitmap(m, lebar, tinggi, false);
        mMap.addMarker(new MarkerOptions().position(Masjidnurulfalah).title("Marker in Masjidnurulfalah").snippet("ini adalah masjid nurul falah")
        .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));
        mMap.addMarker(new MarkerOptions().position(Masjidnurulhudah).title("Marker in Masjidnurulhudah").snippet("ini adalah masjid nurul hudah")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addMarker(new MarkerOptions().position(rumahku).title("Marker in rumahku").snippet("ini rumahku")
                .icon(BitmapDescriptorFactory.fromBitmap(markerMe)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rumahku, 15.5f));

        mMap.addPolyline(new PolylineOptions().add(
                rumahku,
                new LatLng(-2.559508, 121.962031),
                new LatLng(-2.559790, 121.962109),
                new LatLng(-2.559882, 121.961851),
                new LatLng(-2.560607, 121.961366),
                new LatLng(-2.559508, 121.962031),
                new LatLng(-2.562192, 121.957267),
                Masjidnurulfalah

        ).width(10).color(Color.GREEN));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Masjidnurulfalah, 15.5f));

        mMap.addPolyline(new PolylineOptions().add(
                rumahku,
                new LatLng(-2.559508, 121.962103),
                new LatLng(-2.559630, 121.962896),
                new LatLng(-2.559961, 121.963002),
                new LatLng(-2.559557, 121.963830),
                new LatLng(-2.558557, 121.965769),
                new LatLng(-2.5583346, 121.9657744),
                Masjidnurulhudah

        ).width(10).color(Color.GREEN));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Masjidnurulhudah, 15.5f));
    }
}