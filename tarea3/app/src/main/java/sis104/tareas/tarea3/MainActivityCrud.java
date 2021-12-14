package sis104.tareas.tarea3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityCrud extends AppCompatActivity {
    EditText txtNombre, txtDescripcion, txtLongitud, txtLatitud;
    Button btnCreate, btnUpdate, btnRead, btnDelate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_crud);

        //referencias con el layout XML
        txtNombre = findViewById(R.id.txtCrudNombre);
        txtDescripcion = findViewById(R.id.txtCrudDescripcion);
        txtLatitud = findViewById(R.id.txtCrudLatitud);
        txtLongitud = findViewById(R.id.txtCrudLongitud);


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
        if(txtNombre.length() == 0)
            Toast.makeText(this, "Debe ingresar un nonbre", Toast.LENGTH_LONG).show();
        else{
            AdminCrud  admin = new AdminCrud(this,"administracion", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            //se lee el nombre
            String name = txtNombre.getText().toString();
            //Se realiza la consulta
            String x =  "\"" + name + "\"";
            String sql = "Select nombre,descripcion, latitud, longitud from ciudades where nombre="+x;
            //System.out.println(sql);
            Log.d("sql",sql);
            Cursor fila = db.rawQuery(sql,null);
            if(fila.moveToFirst()){
                //Cursor fila = db.rawQuery("Select nombre, descripcion, latitud, longitud  from ciudades where id="+fila_name.getString(0),null);
                txtNombre.setText(fila.getString(0));
                txtDescripcion.setText(fila.getString(1));
                txtLatitud.setText(fila.getString(2));
                txtLongitud.setText(fila.getString(3));
            }else{
                Toast.makeText(this, "No existe registro", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void crear(){
        AdminCrud  admin = new AdminCrud(this,"administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        //se lee el nombre
        String name = txtNombre.getText().toString();
        String descripcion = txtDescripcion.getText().toString();
        String latitud = txtLatitud.getText().toString();
        String longitud = txtLongitud.getText().toString();

        //Varialbles de registro
        ContentValues registro = new ContentValues();

        registro.put("nombre ", name);
        registro.put("descripcion ", descripcion);
        registro.put("latitud ", latitud);
        registro.put("longitud ", longitud);
        //se insertan en la Bd
        db.insert("ciudades",null,registro);

        //se cierra la conexion
        //db.close();

        //se limpian los campos
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtLatitud.setText("");
        txtLongitud.setText("");
        Toast.makeText(this, "registro echo", Toast.LENGTH_LONG).show();
    }

    public void eliminar(){
        AdminCrud  admin = new AdminCrud(this,"administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        //se lee el nombre
        String name = txtNombre.getText().toString();
        String x =  "\"" + name + "\"";
        //Se borra el registro
        int cant = db.delete("ciudades","nombre="+x, null);
        //se cierra la conexion
        db.close();
        //se limpian los campos
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtLatitud.setText("");
        txtLongitud.setText("");

        //Se existe el usuario mensajes
        if(cant == 0){
            Toast.makeText(this, "No existe el usuario", Toast.LENGTH_LONG).show();
        }else if(cant == 1){
            Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_LONG).show();
        }
    }

    public void editar(){
        AdminCrud  admin = new AdminCrud(this,"administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        //se lee los campos
        String name = txtNombre.getText().toString();
        String x =  "\"" + name + "\"";
        String descripcion = txtDescripcion.getText().toString();
        String latitud = txtLatitud.getText().toString();
        String longitud = txtLongitud.getText().toString();

        //Varialbles de registro
        ContentValues registro = new ContentValues();

        registro.put("nombre ", name);
        registro.put("descripcion ", descripcion);
        registro.put("latitud ", latitud);
        registro.put("longitud ", longitud);
        //se hace el update
        int cant = db.update("ciudades", registro, "nombre="+x, null);
        //se cierra la conexion
        //db.close();

        //se limpian los campos
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtLatitud.setText("");
        txtLongitud.setText("");
        //Se existe el usuario mensajes
        if(cant == 0){
            Toast.makeText(this, "usuario nuevo creado", Toast.LENGTH_LONG).show();
        }else if(cant == 1){
            Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_LONG).show();
        }
    }
}