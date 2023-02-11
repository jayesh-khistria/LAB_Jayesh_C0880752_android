package com.example.lab_jayesh_c0880752_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SecondActivity extends FragmentActivity implements OnMapReadyCallback {

    public enum Letters {
        A, B, C, D
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        assert mapFragment != null;
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        GoogleMap mMap = googleMap;
        final List<Marker> markers = new ArrayList<>();

        mMap.setMinZoomPreference(10);

        LatLng toronto = new LatLng(45.5019, -73.5674);
        mMap.addMarker(new MarkerOptions().position(toronto).title("Montreal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toronto));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {

                Letters[] letters = Letters.values();

                MarkerOptions optionsMarker = new MarkerOptions().position(latLng)
                        .title(letters[markers.size()].name());

                markers.add(mMap.addMarker(optionsMarker.draggable(true)));

                Geocoder geocoder = new Geocoder(SecondActivity.this, Locale.getDefault());
                List<Address> addresses = null;

                if (addresses != null && addresses.size() > 0) {
                    Address address = addresses.get(1);
                    String cityName = address.getLocality();
                    String postalCode = address.getPostalCode();

                }
            }
        });
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}