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
public class Persona {
    public static final String _id="_id";
    public static final String _idpersona = "idpersona";
    public static final String _nombre = "nombre";
    public static final String _appaterno = "appaterno";
    public static final String _apmaterno = "apmaterno";
    public static final String _edad = "edad";
    public static final String _sexo = "sexo";
    public static final String _correo = "correo";
    public static final String _movil = "movil";
    public static final String _telefono = "telefono";
    public static final String _religion = "religion";
    public static final  String _direccion="direccion";
    public static final String _estado="estado";
    public static final String _movilsicronizado="movilsincronizado";

    public static  final String TAB_Persona="Persona";


    private YacharyHelper helper;
    private SQLiteDatabase base_datos;
    private final Context context;

    public  Persona (Context ctx){
        this.context=ctx;
    }
    public Persona open()throws SQLException {

        helper=new YacharyHelper(context);
        base_datos=helper.getWritableDatabase();
        return this;
    }
    public  static final String CREATE_TABLE_PERSONA=
            "create table if not exist "+TAB_Persona+"("
                    +_id+" integer primary key autoincrement,"
                    +_idpersona+" text,"
                    +_nombre+" text,"
                    +_apmaterno+" text,"
                    +_apmaterno+" text,"
                    +_edad+" text,"
                    +_sexo+" text,"
                    +_correo+" text;"
                    +_movil+" text,"
                    +_telefono+" text,"
                    +_religion+" text,"
                    +_direccion+" text,"
                    +_estado+" text,"
                    +_movilsicronizado+" integer);";
    public static final String DELETE_TABLE_PERSONA="DROP TABLE IF EXISTS " + TAB_Persona;



    public void  close(){
        if (helper !=null){
            helper.close();
        }

    }
    public  long createPersona(String idpersona, String nombre, String appaterno, String _apmaterno,
                               String edad, String sexo,String correo, String movil, String telefono, String religion,
                               String direccion, int estado, int movilsincronizado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_idpersona,idpersona);
        initialValues.put(_appaterno,appaterno);
        initialValues.put(_apmaterno,appaterno);
        initialValues.put(_edad,edad);
        initialValues.put(_sexo,sexo);
        initialValues.put(_correo,correo);
        initialValues.put(_movil,movil);
        initialValues.put(_telefono,telefono);
        initialValues.put(_religion,religion);
        initialValues.put(_direccion,direccion);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsicronizado,movilsincronizado);

        return  base_datos.insert(TAB_Persona, null, initialValues);
    }
    public int updatePersona(String idpersona, String nombre, String appaterno, String _apmaterno,
                             String edad, String sexo,String correo, String movil, String telefono, String religion,
                             String direccion, int estado, int movilsincronizado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_idpersona,idpersona);
        initialValues.put(_appaterno,appaterno);
        initialValues.put(_apmaterno,appaterno);
        initialValues.put(_edad,edad);
        initialValues.put(_sexo,sexo);
        initialValues.put(_correo,correo);
        initialValues.put(_movil,movil);
        initialValues.put(_telefono,telefono);
        initialValues.put(_religion,religion);
        initialValues.put(_direccion,direccion);
        initialValues.put(_estado,estado);
        initialValues.put(_movilsicronizado,movilsincronizado);

        return base_datos.update(TAB_Persona, initialValues,
                _idpersona+"=?",new String[]{idpersona});
    }
    public int deletePersona(String idpersona,int estado){
        ContentValues initialValues = new ContentValues();
        initialValues.put(_estado,estado);

        return  base_datos.update(TAB_Persona, initialValues,
                _idpersona+"=?",new String[]{idpersona});
    }
    public Cursor getPersona(){
        Cursor cr = base_datos.rawQuery("select * from "+TAB_Persona+";", null);
        return cr;
    }
}
