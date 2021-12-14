package sis104.tareas.tarea3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityGraficos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Graphics(MainActivityGraficos.this));

    }
}