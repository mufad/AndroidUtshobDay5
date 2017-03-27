package com.droiddigger.androidutshobday5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{

    boolean ready=false;
    GoogleMap myMap;
    MarkerOptions bracu, nsu,ewu,uap,uiu;
    static final CameraPosition home = CameraPosition.builder().target(new LatLng(23.759936, 90.361341)).
            zoom(10).bearing(0).tilt(45).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        bracu=new MarkerOptions().position(new LatLng(23.779928, 90.407274)).title("BRACU");
        nsu=new MarkerOptions().position(new LatLng(23.814795 , 90.424983)).title("NSU");
        ewu=new MarkerOptions().position(new LatLng(23.768458 , 90.425602)).title("EWU");
        uap=new MarkerOptions().position(new LatLng(23.754740 , 90.389226)).title("UAP");
        uiu=new MarkerOptions().position(new LatLng(23.744403 , 90.372720)).title("UIU");
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ready=true;
        myMap=googleMap;
        myMap.addMarker(bracu);
        myMap.addMarker(nsu);
        myMap.addMarker(uiu);
        myMap.addMarker(uap);
        myMap.addMarker(ewu);
        myMap.moveCamera(CameraUpdateFactory.newCameraPosition(home));

    }
}
