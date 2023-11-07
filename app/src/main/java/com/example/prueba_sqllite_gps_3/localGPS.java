package com.example.prueba_sqllite_gps_3;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class localGPS extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener,GoogleMap.OnMapLongClickListener , GoogleMap.OnMarkerClickListener {

    EditText txtLatitud, txtLonguitud;
    GoogleMap mMap;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localesgps);

        txtLatitud=findViewById(R.id.txt_Latitud);
        txtLonguitud=findViewById(R.id.txt_Longuitud);
        video = findViewById(R.id.video);
        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap){
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapClickListener(this);
        LatLng SedeArica = new LatLng(-18.483131197524948, -70.3103324888695);
        mMap.addMarker(new MarkerOptions().position(SedeArica).title("Sede Arica"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SedeArica));

        LatLng SedeEquique = new LatLng(-20.23965538483178, -70.14482505993368 );
        mMap.addMarker(new MarkerOptions().position(SedeEquique).title("Sede Equique"));

        LatLng Antofagasta = new LatLng(-23.63463423973385, -70.39405491788575);
        mMap.addMarker(new MarkerOptions().position(Antofagasta).title("Sede Antofagasta"));

        LatLng LaSerena = new LatLng(-29.908320122903344, -71.25720044585273);
        mMap.addMarker(new MarkerOptions().position(LaSerena).title("Sede LaSerena"));

        LatLng ViñadelMar = new LatLng(-33.03688587819181, -71.52229167665644);
        mMap.addMarker(new MarkerOptions().position(ViñadelMar).title("Sede ViñadelMar"));

        LatLng Santiago = new LatLng(-33.44418297507327, -70.65953128423435);
        mMap.addMarker(new MarkerOptions().position(Santiago).title("Sede Santiago"));

        LatLng Talca = new LatLng(-35.42851634278347, -71.672957918884315);
        mMap.addMarker(new MarkerOptions().position(Talca).title("Sede Talca"));

        LatLng Concepcion = new LatLng(-36.81644363020313, -73.0615946879055);
        mMap.addMarker(new MarkerOptions().position(Concepcion).title("Sede Concepcion"));

        LatLng LosAngeles = new LatLng(-37.35303355948922, -72.36503884745098);
        mMap.addMarker(new MarkerOptions().position(LosAngeles).title("Sede LosAngeles"));

        LatLng Temuco = new LatLng(-38.73362574320341, -72.60228769426075);
        mMap.addMarker(new MarkerOptions().position(Temuco).title("Sede Temuco"));

        LatLng Valdivia = new LatLng(-39.78365470534815, -73.22763966347708);
        mMap.addMarker(new MarkerOptions().position(Valdivia).title("Sede Valdivia"));

        LatLng Osorno = new LatLng(-40.5716522291969, -73.13767228796132);
        mMap.addMarker(new MarkerOptions().position(Osorno).title("Sede Osorno"));

        LatLng PuertoMontt = new LatLng(-41.47208865803952, -72.92867881263263);
        mMap.addMarker(new MarkerOptions().position(PuertoMontt).title("Sede PuertoMontt"));
        mMap.setOnMarkerClickListener(this);
    }
    public boolean onMarkerClick(Marker marker) {

        String playVideo = null;

        if (marker.getTitle().equals("Sede Arica")) {
            playVideo("https://drive.google.com/uc?export=download&id=1CFtBWqsy9pQt58PG84EEUMbOMa4EwAUo");
        } else if (marker.getTitle().equals("Sede Iquique")) {
            playVideo("https://drive.google.com/uc?export=download&id=1pcu4leZ7B1ljfaHWSvfEe1jjwBzpfgum");
        } else if (marker.getTitle().equals("Sede Antofagasta")) {
            playVideo("https://drive.google.com/uc?export=download&id=1RVMosu50hRgPN8_iPgVj3zi2mYl41F4d");
        } else if (marker.getTitle().equals("Sede La Serena")) {
            playVideo("https://drive.google.com/uc?export=download&id=1AUunBj8JJu4gNxbZqQzLV_ubobGZ2kPo");
        } else if (marker.getTitle().equals("Sede Viña del Mar")) {
            playVideo("https://drive.google.com/uc?export=download&id=16dbPTkaQ3wdCsu1bNfV9f4m1NSKGRZJ0");
        } else if (marker.getTitle().equals("Sede Santiago")) {
            playVideo("https://drive.google.com/uc?export=download&id=1VydsDbA0o44xsgx2flhJwhfKdLpxedq9");
        } else if (marker.getTitle().equals("Sede Talca")) {
            playVideo("https://drive.google.com/uc?export=download&id=17XiQGdJPwo2Gmy_FlseH_sTVkn6C-7y_");
        } else if (marker.getTitle().equals("Sede Concepción")) {
            playVideo("https://drive.google.com/uc?export=download&id=1cUN-4RremeimU6fmWA-TPbTUhLyUNlZX");
        } else if (marker.getTitle().equals("Sede Los Ángeles")) {
            playVideo("https://drive.google.com/uc?export=download&id=1n_5ov81IYhsidPLnhW9KyWagK6bbNXji");
        } else if (marker.getTitle().equals("Sede Temuco")) {
            playVideo("https://drive.google.com/uc?export=download&id=1_fvr-BumFyz5CYcpYjs8Paik9o1npwcU");
        } else if (marker.getTitle().equals("Sede Valdivia")) {
            playVideo("https://drive.google.com/uc?export=download&id=1P0LTDtuFxQajq7Qx3vb60iq1J7HSUFgY");
        } else if (marker.getTitle().equals("Sede Osorno")) {
            playVideo("https://drive.google.com/uc?export=download&id=14Dn-MJ8ACfO8u1VG0v33Wi6EElbsll9L");
        } else if (marker.getTitle().equals("Sede Puerto Montt")) {
            playVideo("https://drive.google.com/uc?export=download&id=1cKIZv4vHbpM9QE2jcc44GMocW4eBdMLI");
        }
        if (playVideo != null) {

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(video);
            video.setMediaController(mediaController);


            video.setVideoPath(playVideo);


            video.start();
        }
        return false;
    }
    private void playVideo(String videoUrl) {
        Uri uri = Uri.parse(videoUrl);
        video.setVideoURI(uri);
        video.start();
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng){
        txtLatitud.setText(""+latLng.latitude);
        txtLonguitud.setText(""+latLng.longitude);
    }
    @Override
    public  void onMapLongClick(@NonNull LatLng latLng){
        txtLatitud.setText(""+latLng.latitude);
        txtLonguitud.setText(""+latLng.longitude);
    }

}
