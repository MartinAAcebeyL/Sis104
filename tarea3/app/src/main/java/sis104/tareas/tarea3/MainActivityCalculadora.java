package sis104.tareas.tarea3;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityCalculadora extends AppCompatActivity {
    private EditText txtnum1, txtnum2;
    private Button btnSuma, btnResta, btnDiv, btnPro, btnExitCalcu;
    private TextView txtResultado;
    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculadora);

        txtnum1 = (EditText)findViewById(R.id.editTxtnum1);
        txtnum2 = (EditText)findViewById(R.id.editTxtnum2);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnPro = findViewById(R.id.btnPro);
        btnDiv = findViewById(R.id.btnDiv);
        btnExitCalcu = findViewById(R.id.btnExitCalculadora);
        txtResultado = findViewById(R.id.txtResult);


        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(txtnum1.getText().toString());
                float num2 = Float.parseFloat(txtnum2.getText().toString());
                calculadora = new Calculadora(num1, num2);
                txtResultado.setText(String.valueOf(calculadora.suma()));
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(txtnum1.getText().toString());
                float num2 = Float.parseFloat(txtnum2.getText().toString());
                calculadora = new Calculadora(num1, num2);
                txtResultado.setText(String.valueOf(calculadora.resta()));
            }
        });

        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(txtnum1.getText().toString());
                float num2 = Float.parseFloat(txtnum2.getText().toString());
                calculadora = new Calculadora(num1, num2);
                txtResultado.setText(String.valueOf(calculadora.producto()));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(txtnum1.getText().toString());
                float num2 = Float.parseFloat(txtnum2.getText().toString());
                calculadora = new Calculadora(num1, num2);
                txtResultado.setText(String.valueOf(calculadora.division()));
            }
        });
    }
    // button methods
    public void salir_calcu(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}