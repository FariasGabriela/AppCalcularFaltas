package com.example.gabriela.dispositivosmoveisacch;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.gabriela.dispositivosmoveisacch.controller.BancoController;
import com.example.gabriela.dispositivosmoveisacch.repository.HistoricoRepository;

public class HistoricoActivity extends AppCompatActivity {

    private ListView historico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {HistoricoRepository.MATERIA, HistoricoRepository.RESULTADO};
        int[] idViews = new int[] {R.id.nome_materia, R.id.quantidadeFaltas};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_item_historico,cursor,nomeCampos,idViews, 0);
        historico = (ListView)findViewById(R.id.listView);
        historico.setAdapter(adaptador);
    }

}
