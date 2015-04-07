package upeu.lcbm.com.yachary.entitySqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

import upeu.lcbm.com.yachary.baseDatos.YacharyHelper;

/**
 * Created by ivan on 27/03/2015.
 */
public class CategoriaPregunta {
    public static final String _id="_id";
    public static final String  _idjuegopregunta="idjuegopregunta";
    public static final String  _idpregunta="idpregunta";
    public static final String  _idjuego="idjuego";
    public static final String  _estado="estado";
    public static final String  _movilsincronizable="movilsincronizable";


    public static final String TAB_CategoriaPregunta="CategoriaPregunta";

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
    public static final String CREATE_TABLE_CATEGORIA_PREGUNTA =
            "create table if not exists "+TAB_CategoriaPregunta+" ("
                    +_id+" integer primary key autoincrement,"
                    +_idjuegopregunta+" text,"
                    +_idpregunta+" text,"
                    +_idjuego+" text,"
                    +_estado+" integer,"
                    +_movilsincronizable+" integer);";

    public static final String DELETE_TABLE_CATEGORIA_PREGUNTA = "DROP TABLE IF EXISTS " + TAB_CategoriaPregunta;





    public void close() {
        if (helper != null) {
            helper.close();
        }
    }
    public long createCategoriaPregunta(String idjuegopregunta, String idpregunta, String idjuego,
                                        int estado, int movilsincronizable) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(_idjuegopregunta,idjuegopregunta);
        initialValues.put(_idpregunta,idpregunta);
        initialValues.put(_idjuego,idjuego);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsincronizable,movilsincronizable);

        return base_datos.insert(TAB_CategoriaPregunta, null, initialValues);
    }
    public int updateCategoriaPregunta(String idjuegopregunta, String idpregunta, String idjuego,
                                       int estado, int movilsincronizable){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_idjuegopregunta,idjuegopregunta);
        initialValues.put(_idpregunta,idpregunta);
        initialValues.put(_idjuego,idjuego);
        initialValues.put(_estado,_estado);
        initialValues.put(_movilsincronizable,movilsincronizable);

        return  base_datos.update(TAB_CategoriaPregunta, initialValues,
                _idjuegopregunta+"=?",new String[]{idjuegopregunta});
    }
    public int deleteCategoriaPregunta(String idjuegopregunta,int estado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_estado,estado);

        return  base_datos.update(TAB_CategoriaPregunta, initialValues,
                _idjuegopregunta+"=?",new String[]{idjuegopregunta});
    }
    public Cursor getCategoriaPregunta() {
        Cursor cr = base_datos.rawQuery("select * from "+TAB_CategoriaPregunta+";", null);
        return cr;
    }
}
