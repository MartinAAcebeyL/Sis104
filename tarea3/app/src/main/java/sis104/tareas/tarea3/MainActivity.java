package sis104.tareas.tarea3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnConection, btnGrafics, btnCalculadora, btnExit, btnServiciosweb, btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConection = findViewById(R.id.btnConection);
        btnCalculadora = findViewById(R.id.btnCalcular);
        btnGrafics = findViewById(R.id.btbGrafics);
        btnExit = findViewById(R.id.btnExit);
        btnServiciosweb = findViewById(R.id.btnServiciosweb);
        btnMaps = findViewById(R.id.btnMaps);
    }

    //button methots
    public void Conectarse(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityCrud.class);
        startActivity(intent);
    }

    public void Calculadora(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityCalculadora.class);
        startActivity(intent);
    }

    public void Graficos(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityGraficos.class);
        startActivity(intent);
    }

    public void ServiciosWeb(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityWebService.class);
        startActivity(intent);
    }

    public void Mapas(View view){
        Intent intent = new Intent(MainActivity.this,MapsActivity.class);
        startActivity(intent);
    }

    public void Salir(View view){
        Toast.makeText(this, "Gracias", Toast.LENGTH_LONG).show();
        finish();
    }


}