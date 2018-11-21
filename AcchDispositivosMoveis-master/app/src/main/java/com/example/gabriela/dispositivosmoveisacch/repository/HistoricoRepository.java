package com.example.gabriela.dispositivosmoveisacch.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HistoricoRepository extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "historico";
    public static final String ID = "_id";
    public static final String MATERIA = "materia";
    public static final String QTTOTAL = "qtTotal";
    public static final String RESULTADO = "resultado";
    public static final String HORARIO = "horario";
    private static final int VERSAO = 1;

    public HistoricoRepository(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + MATERIA + " text,"
                + QTTOTAL + " text,"
                + RESULTADO + " text,"
                + HORARIO + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
