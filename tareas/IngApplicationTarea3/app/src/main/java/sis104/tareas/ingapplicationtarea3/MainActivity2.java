package sis104.tareas.ingapplicationtarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    //Button buttonExitGraphics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        setContentView(new Graphics(MainActivity2.this));
        /*
        buttonExitGraphics = findViewById(R.id.buttonExitGraphics);

        buttonExitGraphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         */
    }
}