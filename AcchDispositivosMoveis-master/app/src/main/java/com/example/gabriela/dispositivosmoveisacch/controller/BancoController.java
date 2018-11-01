package com.example.gabriela.dispositivosmoveisacch.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gabriela.dispositivosmoveisacch.repository.HistoricoRepository;

public class BancoController {
    private SQLiteDatabase db;
    private HistoricoRepository banco;

    public BancoController(Context context){
        banco = new HistoricoRepository(context);
    }

    public String insereDado(String materia, String qtTotal, String valorFinal){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(HistoricoRepository.MATERIA, materia);
        valores.put(HistoricoRepository.QTTOTAL, qtTotal);
        valores.put(HistoricoRepository.RESULTADO, valorFinal);

        resultado = db.insert(HistoricoRepository.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID, banco.MATERIA,banco.RESULTADO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
