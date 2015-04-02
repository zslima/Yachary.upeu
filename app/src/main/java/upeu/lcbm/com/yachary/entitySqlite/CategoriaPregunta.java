package upeu.lcbm.com.yachary.entitySqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

import upeu.lcbm.com.yachary.baseDatos.YacharyHelper;

/**
 * Created by ivan on 27/03/2015.
 */
public class CategoriaPregunta {
    public static final String _id="_id";
    public static final String _idjuegopregunta="idjuegopreguntas";
    public static final String  idpregunta="idpregunta";
    public static final String  idjuego="idjuego";
    public static final String  movilsincronizable="movilsincronizable";


    public static final String CategoriaPregunta="CategoriaPregunta";

    private YacharyHelper helper;
    private SQLiteDatabase base_datos;

    private final Context context;

    public  CategoriaPregunta (Context ctx){
        this.context=ctx;
    }
    public CategoriaPregunta open()throws SQLException{

        helper=new YacharyHelper(context);
        base_datos=helper.getWritableDatabase();
        return this;
    }
}
