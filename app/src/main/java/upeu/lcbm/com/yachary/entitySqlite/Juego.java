package upeu.lcbm.com.yachary.entitySqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import upeu.lcbm.com.yachary.baseDatos.YacharyHelper;

/**
 * Created by ivan on 27/03/2015.
 */
public class Juego {
    public static final String _id="_id";
    public static final String idjuego="idjuego";
    public static final String estadojuego="estadojuego";
    public static final String estadoturno= "estadoturno";
    public static final String tiempoespera="tiempoespera";
    public static final String idpersona="idpersona";
    public static final String movilsincronizado="movilsincronizado";

    public static  final String Juego="Juego";

    private YacharyHelper helper;
    private SQLiteDatabase base_datos;
    private final Context context;

    public  Juego (Context ctx){
        this.context=ctx;
    }
    public Juego open()throws SQLException {

        helper=new YacharyHelper(context);
        base_datos=helper.getWritableDatabase();
        return this;
    }
}
