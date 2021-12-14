package sis104.tareas.tarea3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminCrudServicioWeb extends SQLiteOpenHelper {
    String create_tabla = "CREATE TABLE tareaWsBd(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, latitud FLOAT, longitud FLOAT);";
    String drop_tabla   = "DROP TABLE IF EXISTS tareaWsBd;";

    public AdminCrudServicioWeb(Context context, String nombre, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context, nombre, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(drop_tabla);
        sqLiteDatabase.execSQL(create_tabla);
    }
}