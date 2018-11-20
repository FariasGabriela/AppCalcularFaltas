package com.example.gabriela.dispositivosmoveisacch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gabriela.dispositivosmoveisacch.controller.BancoController;
import com.example.gabriela.dispositivosmoveisacch.repository.HistoricoRepository;

public class HistoricoActivity extends AppCompatActivity implements DialogItemHistorico.onFinishDialog {


    private Cursor cursor;
    private ListView historico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        onResume();

        historico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( getApplicationContext(), "id: " + id + " posicao" + position, Toast.LENGTH_LONG ).show();

                int codigo = cursor.getInt(cursor.getColumnIndexOrThrow(HistoricoRepository.ID));
                DialogItemHistorico dialogHistorico = new DialogItemHistorico(HistoricoActivity.this, codigo, HistoricoActivity.this);
                dialogHistorico.show();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        cursor = new BancoController(getBaseContext()).carregaDados();

        String[] nomeCampos = new String[] {HistoricoRepository.MATERIA, HistoricoRepository.RESULTADO};
        int[] idViews = new int[] {R.id.nome_materia, R.id.quantidadeFaltas};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_item_historico,cursor,nomeCampos,idViews, 0);
        historico = (ListView)findViewById(R.id.listView);
        historico.setAdapter(adaptador);

    }

    @Override
    public void onFinishedDialog() {
       // ((SimpleCursorAdapter) historico.getAdapter()).changeCursor(new BancoController(HistoricoActivity.this).carregaDados());
        onResume();
    }
}
