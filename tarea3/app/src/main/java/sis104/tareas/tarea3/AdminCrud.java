package sis104.tareas.tarea3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminCrud extends SQLiteOpenHelper {
    //String tabla = "CREATE TABLE ciudades(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre VARCHAR(50), descripcion VARCHAR(150), latitud FLOAT, longitud FLOAT);";
    String tabla = "CREATE TABLE ciudades(nombre VARCHAR(50) PRIMARY KEY, descripcion VARCHAR(150), latitud FLOAT, longitud FLOAT);";
    String tabla_drop = "DROP TABLE IF EXISTS ciudades;";

    public AdminCrud (Context context, String nombre, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context, nombre, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(tabla_drop);
        sqLiteDatabase.execSQL(tabla);
    }
}