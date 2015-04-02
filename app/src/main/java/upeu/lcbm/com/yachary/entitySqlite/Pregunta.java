package upeu.lcbm.com.yachary.entitySqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import upeu.lcbm.com.yachary.baseDatos.YacharyHelper;

/**
 * Created by ivan on 27/03/2015.
 */
public class Pregunta {
    public static final String _id="_id";
    public static String idpregunta="idpregunta";
    public static String descripcion="descripcion";
    public static String idcategoria="idcategoria";
    public static String movilsincronizable="movilsincronizable";


    public static final String Pregunta="Pregunta";

    private YacharyHelper helper;
    private SQLiteDatabase base_datos;
    private final Context context;

    public  Pregunta (Context ctx){
        this.context=ctx;
    }
    public Pregunta open()throws SQLException {

        helper=new YacharyHelper(context);
        base_datos=helper.getWritableDatabase();
        return this;
    }
}
