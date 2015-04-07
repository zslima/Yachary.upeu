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
public class Pregunta {
    public static final String _id="_id";
    public static String _idpregunta="idpregunta";
    public static String _descripcion="descripcion";
    public static String _idcategoria="idcategoria";
    public static String _estado="estado";
    public static String _movilsincronizado="movilsincronizado";


    public static final String TAB_Pregunta="Pregunta";

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
    public static final String CREATE_TABLE_PREGUNTA =
            "create table if not exists "+TAB_Pregunta+" ("
                    +_id+" integer primary key autoincrement,"
                    +_idpregunta+" text,"
                    +_descripcion+" text,"
                    +_idcategoria+" text,"
                    +_estado+" text,"
                    +_movilsincronizado+" integer);";

    public static final String DELETE_TABLE_PREGUNTA = "DROP TABLE IF EXISTS " + TAB_Pregunta;





    public void close() {
        if (helper != null) {
            helper.close();
        }
    }
    public long createPregunta( String idpregunta, String descripcion, String idcategoria ,
                                       int estado, int movilsincronizado) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(_idpregunta,idpregunta);
        initialValues.put(_descripcion,descripcion);
        initialValues.put(_idcategoria,idcategoria);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizado,movilsincronizado);

        return base_datos.insert(TAB_Pregunta, null, initialValues);
    }
    public int Preguntas(String idpregunta, String descripcion, String idcategoria ,
                         int estado, int movilsincronizado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_idpregunta,idpregunta);
        initialValues.put(_descripcion,descripcion);
        initialValues.put(_idcategoria,idcategoria);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizado,movilsincronizado);

        return  base_datos.update(TAB_Pregunta, initialValues,
                _idpregunta+"=?",new String[]{idpregunta});
    }
    public int deletePregunta(String idpregunta,int estado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_estado,estado);

        return  base_datos.update(TAB_Pregunta, initialValues,
                _idpregunta+"=?",new String[]{idpregunta});
    }
    public Cursor getPregunta() {
        Cursor cr = base_datos.rawQuery("select * from "+TAB_Pregunta+";", null);
        return cr;
    }

}
