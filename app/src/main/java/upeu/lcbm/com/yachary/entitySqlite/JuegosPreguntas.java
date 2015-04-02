package upeu.lcbm.com.yachary.entitySqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import upeu.lcbm.com.yachary.baseDatos.YacharyHelper;

/**
 * Created by ivan on 27/03/2015.
 */
public class JuegosPreguntas {
    public static final String _id="_id";
    public static final String idpregunta="idpregunta";
    public static final String idjuego="idjuego";
    public static final String idjuegopreg = "idjuegopreg";
    public static  final String movilsincronizado= "movilsincronizado";

    public static final String JuegosPreguntas="JuegosPreguntas";

    private YacharyHelper helper;
    private SQLiteDatabase base_datos;
    private final Context context;

    public  JuegosPreguntas (Context ctx){
        this.context=ctx;
    }
    public JuegosPreguntas open()throws SQLException {

        helper=new YacharyHelper(context);
        base_datos=helper.getWritableDatabase();
        return this;
    }

}
