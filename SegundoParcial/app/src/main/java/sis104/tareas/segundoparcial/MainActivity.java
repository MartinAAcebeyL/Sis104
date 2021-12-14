package sis104.tareas.segundoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrud = findViewById(R.id.btnCrud);


    }
    public void Conectarse(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityCrud.class);
        startActivity(intent);
    }

    public void Mapas(View view){
        Intent intent = new Intent(MainActivity.this,MapsActivity.class);
        startActivity(intent);
    }
}