package com.example.gabriela.dispositivosmoveisacch.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gabriela.dispositivosmoveisacch.repository.HistoricoRepository;

public class BancoController {
    private SQLiteDatabase db;
    private HistoricoRepository banco;

    public BancoController(Context context){
        banco = new HistoricoRepository(context);
    }

    public String insereDado(String materia, String qtTotal, String valorFinal, String horario){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(HistoricoRepository.MATERIA, materia);
        valores.put(HistoricoRepository.QTTOTAL, qtTotal);
        valores.put(HistoricoRepository.RESULTADO, valorFinal);
        valores.put(HistoricoRepository.HORARIO, horario);

        resultado = db.insert(HistoricoRepository.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDadoById (int id){
        Cursor cursor;
        String [] campos = {banco.ID, banco.MATERIA, banco.RESULTADO, banco.HORARIO};
        db = banco.getWritableDatabase();
        String where = banco.ID + " = " + id;
        cursor = db.query(banco.TABELA, campos, where, null, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        db.close();

        return cursor;
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID, banco.MATERIA,banco.RESULTADO, banco.HORARIO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alterarDados( int id, String materia, String resultado, String horario){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = banco.ID + " = " + id;

        valores = new ContentValues();
        valores.put(banco.MATERIA, materia );
        valores.put(banco.RESULTADO, resultado);
        valores.put(banco.HORARIO, horario);

        db.update(banco.TABELA, valores, where, null);
        db.close();

    }

    public void deleteDados(int id){
        String where = banco.ID + " = " + id;
        db = banco.getWritableDatabase();
        long teste = db.delete(banco.TABELA, where, null);
        Log.i("TESTETESTE", "" + teste);
        db.close();
    }
}
