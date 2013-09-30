package com.planetmedia.qualitas.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 
public class TablasSQLiteHelper extends SQLiteOpenHelper {
	StringBuilder querys = new StringBuilder();
	
	
	//Sentencia SQL para crear la tabla de Usuarios
    //String sqlCreate = 
	
 
    public TablasSQLiteHelper(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creaci�n de la tabla
    	querys.append("DROP TABLE IF EXISTS tbmen001;");
        querys.append("CREATE TABLE tbmen001 (");
        querys.append("id_tipo_vehiculo INT(10) NOT NULL AUTO_INCREMENT,");
        querys.append("tipo_vehiculo VARCHAR(150) NOT NULL,");
        querys.append("status CHAR(1) NOT NULL,");
        querys.append("PRIMARY KEY(id_tipo_vehiculo));");
        db.execSQL(querys.toString());
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, 
                          int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aqu� utilizamos directamente 
        //      la opci�n de eliminar la tabla anterior y crearla de nuevo 
        //      vac�a con el nuevo formato.
        //      Sin embargo lo normal ser� que haya que migrar datos de la 
        //      tabla antigua a la nueva, por lo que este m�todo deber�a 
        //      ser m�s elaborado.
 
        //Se elimina la versi�n anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
 
        //Se crea la nueva versi�n de la tabla
        db.execSQL(querys.toString());
    }
}

