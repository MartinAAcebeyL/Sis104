package sis104.tareas.a1erparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityCrud extends AppCompatActivity {
    EditText txtNombreC, txtDirecion, txtTelefono;
    Button btnCreate, btnUpdate, btnRead, btnDelate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_crud);

        //referencias con el layout XML
        txtNombreC = findViewById(R.id.txtCrudNombre);
        txtDirecion = findViewById(R.id.txtCrudDireccion);
        txtTelefono = findViewById(R.id.txtCrudTelefono);

        btnCreate = findViewById(R.id.btnCreate);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnRead = findViewById(R.id.btnRead);
        btnDelate = findViewById(R.id.btnDelete);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crear();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consulta();
            }
        });

        btnDelate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });
    }


    //Metodos crud
    public void consulta(){
        if(txtNombreC.length() == 0)
            Toast.makeText(this, "Debe ingresar un nobre completo para buscar", Toast.LENGTH_LONG).show();
        else{
            AdminCrud  admin = new AdminCrud(this,"parcial", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            //se lee el nombre
            String name = txtNombreC.getText().toString();
            //Se realiza la consulta
            String x =  "\"" + name + "\"";
            String sql = "Select nombrecompleto,direccion, telefono from clientes where nombrecompleto="+x+"limit 1";

            Log.d("sql",sql);
            Cursor fila = db.rawQuery(sql,null);
            if(fila.moveToFirst()){
                txtNombreC.setText(fila.getString(0));
                txtDirecion.setText(fila.getString(1));
                txtTelefono.setText(fila.getString(2));
                Toast.makeText(this, "Consulta satisfactoria", Toast.LENGTH_LONG).show();
            }else
                Toast.makeText(this, "No existe registro", Toast.LENGTH_LONG).show();
        }
    }

    public void crear(){
        if(txtNombreC.length() == 0 || txtTelefono.length() == 0 || txtDirecion.length() == 0)
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        else{
            AdminCrud  admin = new AdminCrud(this,"parcial", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            //se lee el nombre
            String nombreC = txtNombreC.getText().toString();
            String direccion = txtDirecion.getText().toString();
            String telefono = txtTelefono.getText().toString();

            //Varialbles de registro
            ContentValues registro = new ContentValues();

            registro.put("nombreCompleto ", nombreC);
            registro.put("direccion ", direccion);
            registro.put("telefono ", telefono);
            //se insertan en la Bd
            db.insert("clientes",null, registro);

            //se cierra la conexion
            //db.close();

            //se limpian los campos
            txtNombreC.setText("");
            txtDirecion.setText("");
            txtTelefono.setText("");
            Toast.makeText(this, "registro echo", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminar(){
        if(txtNombreC.length() == 0)
            Toast.makeText(this, "Debe ingresar un nobre completo para eliminar", Toast.LENGTH_LONG).show();
        else{
            AdminCrud  admin = new AdminCrud(this,"parcial", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            //se lee el nombre
            String name = txtNombreC.getText().toString();
            String x =  "\"" + name + "\"";
            //Se borra el registro
            int cant = db.delete("clientes","nombreCompleto="+x, null);
            //se cierra la conexion
            //db.close();
            //se limpian los campos
            txtNombreC.setText("");
            txtTelefono.setText("");
            txtDirecion.setText("");

            //Se existe el usuario mensajes
            if(cant == 0)
                Toast.makeText(this, "No existe el cliente", Toast.LENGTH_LONG).show();
            else if(cant == 1)
                Toast.makeText(this, "cliente eliminado", Toast.LENGTH_LONG).show();
        }
    }

    public void editar(){
        if(txtNombreC.length() == 0 || txtTelefono.length() == 0 || txtDirecion.length() == 0)
            Toast.makeText(this, "Debe ingresar un nobre completo para editar", Toast.LENGTH_LONG).show();
        else {
            AdminCrud  admin = new AdminCrud(this,"parcial", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            //se lee los campos
            String name = txtNombreC.getText().toString();
            String x =  "\"" + name + "\"";
            String direcion = txtDirecion.getText().toString();
            String telefono = txtTelefono.getText().toString();

            //Varialbles de registro
            ContentValues registro = new ContentValues();

            registro.put("nombreCompleto", name);
            registro.put("direccion", direcion);
            registro.put("telefono", telefono);
            //se hace el update
            int cant = db.update("clientes", registro, "nombreCompleto="+x, null);
            //se cierra la conexion
            //db.close();
            //Se existe el usuario mensajes
            if(cant == 0)
                Toast.makeText(this, "cliente nuevo creado", Toast.LENGTH_LONG).show();
            else if(cant == 1)
                Toast.makeText(this, "cliente actualizado", Toast.LENGTH_LONG).show();

            //se limpian los campos
            txtNombreC.setText("");
            txtDirecion.setText("");
            txtTelefono.setText("");
        }
    }
}