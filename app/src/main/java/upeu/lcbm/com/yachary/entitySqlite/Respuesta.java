package upeu.lcbm.com.yachary.entitySqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import upeu.lcbm.com.yachary.baseDatos.YacharyHelper;

/**
 * Created by ivan on 27/03/2015.
 */
public class Respuesta {
    public static final String _id="_id";
    public static final String idrespuesta="idrespuesta";
    public static final String nombre="nombre";
    public static final String estadovalidado="estadovalidado";
    public static final String idpreguntas="idpreguntas";
    public static final String movilsincronizado="movilsincronizado";


    public static final String Respuesta="Respuesta";


    private YacharyHelper helper;
    private SQLiteDatabase base_datos;
    private final Context context;

    public  Respuesta (Context ctx){
        this.context=ctx;
    }
    public Respuesta open()throws SQLException {

        helper=new YacharyHelper(context);
        base_datos=helper.getWritableDatabase();
        return this;
    }

}
