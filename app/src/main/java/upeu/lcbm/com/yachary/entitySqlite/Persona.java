package upeu.lcbm.com.yachary.entitySqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import upeu.lcbm.com.yachary.baseDatos.YacharyHelper;

/**
 * Created by ivan on 27/03/2015.
 */
public class Persona {
    public static final String _id="_id";
    public static final String idpersona = "idpersona";
    public static final String nombre = "nombre";
    public static final String appaterno = "appaterno";
    public static final String apmaterno = "apmaterno";
    public static final String edad = "edad";
    public static final String sexo = "sexo";
    public static final String correo = "correo";
    public static final String movil = "movil";
    public static final String telefono = "telefono";
    public static final String religion = "religion";
    public static final  String direccion="direccion";
    public static final String estado="estado";
    public static final String movilsicronizado="movilsincronizado";

    public static  final String Persona="Persona";


    private YacharyHelper helper;
    private SQLiteDatabase base_datos;
    private final Context context;

    public  Persona (Context ctx){
        this.context=ctx;
    }
    public Persona open()throws SQLException {

        helper=new YacharyHelper(context);
        base_datos=helper.getWritableDatabase();
        return this;
    }
}
