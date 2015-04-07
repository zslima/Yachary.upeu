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
public class JuegosPreguntas {
    public static final String _id="_id";
    public static final String _idjuegopregunta = "idjuegopregunta";
    public static final String _idpregunta="idpregunta";
    public static final String _idjuego="idjuego";

    public static final String _estado="estado";
    public static  final String _movilsincronizado= "movilsincronizado";

    public static final String TAB_JuegosPregunta="JuegosPregunta";

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
    public static final String CREATE_TABLE_JUEGOS_PREGUNTAS =
            "create table if not exists "+TAB_JuegosPregunta+" ("
                    +_id+" integer primary key autoincrement,"
                    +_idjuegopregunta+" text,"
                    +_idpregunta+" text,"
                    +_idjuego+" text,"
                    +_estado+" text,"
                    +_movilsincronizado+" integer);";

    public static final String DELETE_TABLE_JUEGOS_PREGUNTAS = "DROP TABLE IF EXISTS " + TAB_JuegosPregunta;





    public void close() {
        if (helper != null) {
            helper.close();
        }
    }
    public long createJuegosPreguntas( String idjuegopregunta ,String idpregunta, String idjuego,
                                       int estado, int movilsincronizado) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(_idjuegopregunta,idjuegopregunta);
        initialValues.put(_idpregunta,idpregunta);
        initialValues.put(_idjuego,idjuego);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizado,movilsincronizado);

        return base_datos.insert(TAB_JuegosPregunta, null, initialValues);
    }
    public int JuegosPreguntas(String idjuegopregunta ,String idpregunta, String idjuego,
                               int estado, int movilsincronizado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_idjuegopregunta,idjuegopregunta);
        initialValues.put(_idjuego,idpregunta);
        initialValues.put(_idpregunta,idjuego);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizado,movilsincronizado);

        return  base_datos.update(TAB_JuegosPregunta, initialValues,
                _idjuego+"=?",new String[]{idjuego});
    }
    public int deleteJuegosPreguntas(String idjuegopregunta,int estado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_estado,estado);

        return  base_datos.update(TAB_JuegosPregunta, initialValues,
                _idjuegopregunta+"=?",new String[]{idjuegopregunta});
    }
    public Cursor getJuegoPregunta() {
        Cursor cr = base_datos.rawQuery("select * from "+TAB_JuegosPregunta+";", null);
        return cr;
    }

}

