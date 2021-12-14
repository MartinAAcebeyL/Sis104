package sis104.tareas.segundoparcial;

import androidx.fragment.app.FragmentActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import sis104.tareas.segundoparcial.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    AdminCrud dataBase;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        dataBase = new AdminCrud(MapsActivity.this,"parcial2", null,1);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        
        db = dataBase.getWritableDatabase();
        String sql = "SELECT direccion, latitud, longitud FROM clientes;";
        Cursor fila = db.rawQuery(sql,null);
        fila.moveToFirst();
        int num_rows = fila.getCount();
        for(int i = 0; i < num_rows; i++){
            float lat = fila.getFloat(1);
            float lon = fila.getFloat(2);;

            //String titulo = "1";
            String titulo = fila.getString(0);
            LatLng punto = new LatLng(lat, lon);
            mMap.addMarker(new MarkerOptions().position(punto).title(titulo));
            fila.moveToNext();
        }
    }
}