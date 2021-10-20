package sis104.tareas.a1erparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnConection,  btnServiciosweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConection = findViewById(R.id.btnCrud);
        btnServiciosweb = findViewById(R.id.btnWebservice);
    }
    //button methots
    public void Conectarse(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityCrud.class);
        startActivity(intent);
    }

    public void ServiciosWeb(View view){
        Intent intent = new Intent(MainActivity.this,MainActivityWebService.class);
        startActivity(intent);
    }

    public void Salir(View view){
        Toast.makeText(this, "Gracias", Toast.LENGTH_LONG).show();
        finish();
    }
}