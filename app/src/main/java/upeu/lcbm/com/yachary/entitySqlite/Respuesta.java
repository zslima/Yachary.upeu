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
public class Respuesta {
    public static final String _id="_id";
    public static final String _idrespuesta="idrespuesta";
    public static final String _nombre="nombre";
    public static final String _estadovalidado="estadovalidado";
    public static final String _idpregunta="idpreguntas";
    public static final String _estado="estado";
    public static final String _movilsincronizado="movilsincronizado";


    public static final String TAB_Respuesta="Respuesta";


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
    public static final String CREATE_TABLE_RESPUESTA =
            "create table if not exists "+TAB_Respuesta+" ("
                    +_id+" integer primary key autoincrement,"
                    +_idrespuesta+" text,"
                    +_nombre+" text,"
                    +_estadovalidado+" text,"
                    +_idpregunta+" text,"
                    +_estado+" text,"
                    +_movilsincronizado+" integer);";

    public static final String DELETE_TABLE_RESPUESTA = "DROP TABLE IF EXISTS " + TAB_Respuesta;





    public void close() {
        if (helper != null) {
            helper.close();
        }
    }
    public long createRespuesta( String idrespuesta, String nombre, String estadovalidado ,
                                String idpregunta ,int estado, int movilsincronizado) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(_idrespuesta,idrespuesta);
        initialValues.put(_nombre,nombre);
        initialValues.put(_estadovalidado,estadovalidado);
        initialValues.put(_idpregunta,idpregunta);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizado,movilsincronizado);

        return base_datos.insert(TAB_Respuesta, null, initialValues);
    }
    public int Respuestas(String idrespuesta, String nombre, String estadovalidado ,
                         String idpregunta ,int estado, int movilsincronizado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_idrespuesta,idrespuesta);
        initialValues.put(_nombre,nombre);
        initialValues.put(_estadovalidado,estadovalidado);
        initialValues.put(_idpregunta,idpregunta);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizado,movilsincronizado);

        return  base_datos.update(TAB_Respuesta, initialValues,
                _idrespuesta+"=?",new String[]{idrespuesta});
    }
    public int deleteRespuesta(String idrespuesta,int estado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_estado,estado);

        return  base_datos.update(TAB_Respuesta, initialValues,
                _idrespuesta+"=?",new String[]{idrespuesta});
    }
    public Cursor getRespuesta() {
        Cursor cr = base_datos.rawQuery("select * from "+TAB_Respuesta+";", null);
        return cr;
    }

}
