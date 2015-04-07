package upeu.lcbm.com.yachary.entitySqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import upeu.lcbm.com.yachary.baseDatos.YacharyHelper;

/**
 * Created by ivan on 27/03/2015.
 */
public class Juego {
    public static final String _id="_id";
    public static final String _idjuego="idjuego";
    public static final String _estadojuego="estadojuego";
    public static final String _estadoturno= "estadoturno";
    public static final String _tiempoespera="tiempoespera";
    public static final String _idpersona="idpersona";
    public static final String _estado="estado";
    public static final String _movilsincronizado="movilsincronizado";

    public static  final String TAB_Juego="Juego";

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
    public static final String CREATE_TABLE_JUEGO =
            "create table if not exists "+TAB_Juego+" ("
                    +_id+" integer primary key autoincrement,"
                    +_idjuego+" text,"
                    +_estadojuego+" text,"
                    +_estadoturno+" text,"
                    +_tiempoespera+" integer,"
                    +_idpersona+" text,"
                    +_estado+" text,"
                    +_movilsincronizado+" integer);";

    public static final String DELETE_TABLE_JUEGO = "DROP TABLE IF EXISTS " + TAB_Juego;





    public void close() {
        if (helper != null) {
            helper.close();
        }
    }
    public long createJuego(String idjuego, String estadojuego, String estadoturno, String tiempoespera, String idpersona,
                                        int estado, int movilsincronizado) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(_idjuego,idjuego);
        initialValues.put(_estadojuego,estadojuego);
        initialValues.put(_estadoturno,estadoturno);
        initialValues.put(_tiempoespera,tiempoespera);
        initialValues.put(_idpersona,idpersona);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizado,movilsincronizado);

        return base_datos.insert(TAB_Juego, null, initialValues);
    }
    public int Juego(String idjuego, String estadojuego, String estadoturno, String tiempoespera, String idpersona,
                     int estado, int movilsincronizado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_idjuego,idjuego);
        initialValues.put(_estadojuego,estadojuego);
        initialValues.put(_estadoturno,estadoturno);
        initialValues.put(_tiempoespera,tiempoespera);
        initialValues.put(_idpersona,idpersona);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizado,movilsincronizado);

        return  base_datos.update(TAB_Juego, initialValues,
                _idjuego+"=?",new String[]{idjuego});
    }
    public int deleteJuego(String idjuego,int estado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_estado,estado);

        return  base_datos.update(TAB_Juego, initialValues,
                _idjuego+"=?",new String[]{idjuego});
    }
    public Cursor getJuego() {
        Cursor cr = base_datos.rawQuery("select * from "+TAB_Juego+";", null);
        return cr;
    }
}

