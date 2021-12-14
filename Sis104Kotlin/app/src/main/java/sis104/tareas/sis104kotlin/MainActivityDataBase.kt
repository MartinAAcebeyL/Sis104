package sis104.tareas.sis104kotlin

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_data_base.*

class MainActivityDataBase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_data_base)

        //referencias con el layout XML
        val txtCrudNombre = findViewById<EditText>(R.id.txtCrudNombre)
        val txtCrudDescripcion = findViewById<EditText>(R.id.txtCrudDescripcion)
        val txtCrudLatitud = findViewById<EditText>(R.id.txtCrudLatitud)
        val txtCrudLongitud = findViewById<EditText>(R.id.txtCrudLongitud)


        val btnCreate = findViewById<Button>(R.id.btnCreate)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val btnRead = findViewById<Button>(R.id.btnRead)
        val btnDelate = findViewById<Button>(R.id.btnDelete)

       btnCreate.setOnClickListener(){
           crear()
       }

        btnUpdate.setOnClickListener(){
            editar()
        }

        btnRead.setOnClickListener(){
            consulta()
        }

        btnDelate.setOnClickListener(){
            eliminar()
        }

    }

    //Metodos crud
    fun consulta() {
        if (txtCrudNombre.length() == 0)
            Toast.makeText(this,"Debe ingresar un nonbre",Toast.LENGTH_LONG).show()
        else {
            val admin = AdminCrud(this, "administracion", null, 1)
            val db = admin.writableDatabase

            //se lee el nombre
            val name: String = txtCrudNombre.getText().toString()
            //Se realiza la consulta
            val x = "\"" + name + "\""
            val sql = "Select nombre,descripcion, latitud, longitud from ciudades where nombre=$x"

            Log.d("sql", sql)
            val fila = db.rawQuery(sql, null)
            if (fila.moveToFirst()) {
                txtCrudNombre.setText(fila.getString(0))
                txtCrudDescripcion.setText(fila.getString(1))
                txtCrudLatitud.setText(fila.getString(2))
                txtCrudLongitud.setText(fila.getString(3))
            } else {
                Toast.makeText(this, "No existe registro", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun crear() {
        val admin = AdminCrud(this, "administracion", null, 1)
        val db = admin.writableDatabase

        //se lee el nombre
        val name: String = txtCrudNombre.getText().toString()
        val descripcion: String = txtCrudDescripcion.getText().toString()
        val latitud: String = txtCrudLatitud.getText().toString()
        val longitud: String = txtCrudLongitud.getText().toString()

        //Varialbles de registro
        val registro = ContentValues()
        registro.put("nombre ", name)
        registro.put("descripcion ", descripcion)
        registro.put("latitud ", latitud)
        registro.put("longitud ", longitud)
        //se insertan en la Bd
        db.insert("ciudades", null, registro)

        //se limpian los campos
        txtCrudNombre.setText("")
        txtCrudDescripcion.setText("")
        txtCrudLatitud.setText("")
        txtCrudLongitud.setText("")
        Toast.makeText(this, "registro echo", Toast.LENGTH_LONG).show()
    }

    fun eliminar() {
        val admin = AdminCrud(this, "administracion", null, 1)
        val db = admin.writableDatabase

        //se lee el nombre
        val name: String = txtCrudNombre.getText().toString()
        val x = "\"" + name + "\""
        //Se borra el registro
        val cant = db.delete("ciudades", "nombre=$x", null)
        //se cierra la conexion
        db.close()
        //se limpian los campos
        txtCrudNombre.setText("")
        txtCrudDescripcion.setText("")
        txtCrudLatitud.setText("")
        txtCrudLongitud.setText("")

        //Se existe el usuario mensajes
        if (cant == 0) {
            Toast.makeText(this, "No existe el usuario", Toast.LENGTH_LONG).show()
        } else if (cant == 1) {
            Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_LONG).show()
        }
    }

    fun editar() {
        val admin = AdminCrud(this, "administracion", null, 1)
        val db = admin.writableDatabase

        //se lee los campos
        val name: String = txtCrudNombre.getText().toString()
        val x = "\"" + name + "\""
        val descripcion: String = txtCrudDescripcion.getText().toString()
        val latitud: String = txtCrudLatitud.getText().toString()
        val longitud: String = txtCrudLongitud.getText().toString()

        //Varialbles de registro
        val registro = ContentValues()
        registro.put("nombre ", name)
        registro.put("descripcion ", descripcion)
        registro.put("latitud ", latitud)
        registro.put("longitud ", longitud)

        //se hace el update
        val cant = db.update("ciudades", registro, "nombre=$x", null)
        //se cierra la conexion
        //db.close();

        //se limpian los campos
        txtCrudNombre.setText("")
        txtCrudDescripcion.setText("")
        txtCrudLatitud.setText("")
        txtCrudLongitud.setText("")
        //Se existe el usuario mensajes
        if (cant == 0) {
            Toast.makeText(this, "usuario nuevo creado", Toast.LENGTH_LONG).show()
        } else if (cant == 1) {
            Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_LONG).show()
        }
    }
}