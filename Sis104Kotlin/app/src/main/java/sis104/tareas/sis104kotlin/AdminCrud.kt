package sis104.tareas.sis104kotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class AdminCrud(context: Context?, nombre: String?, cursorFactory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, nombre, cursorFactory, version) {

    var tabla = "CREATE TABLE ciudades(nombre VARCHAR(50) PRIMARY KEY, descripcion VARCHAR(150), latitud FLOAT, longitud FLOAT);"
    var tabla_drop = "DROP TABLE IF EXISTS ciudades;"

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(tabla)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL(tabla_drop)
        sqLiteDatabase.execSQL(tabla)
    }
}