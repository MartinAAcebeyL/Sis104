package sis104.tareas.segundoparcial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminCrud extends SQLiteOpenHelper {
    //id, nombre completo, nit/ci, direccion, celular, latitud, longitud
    String tabla = "CREATE TABLE clientes(id INTEGER PRIMARY KEY AUTOINCREMENT,nombreCompleto VARCHAR(80), ci VARCHAR(30), direccion VARCHAR(30), celular VARCHAR(10), latitud FLOAT, longitud FLOAT);";
    String tabla_drop = "DROP TABLE IF EXISTS clientes;";

    public AdminCrud(Context context, String nombre, SQLiteDatabase.CursorFactory cursorFactory, int version){
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