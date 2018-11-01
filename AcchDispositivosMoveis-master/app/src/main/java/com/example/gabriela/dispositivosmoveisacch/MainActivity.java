package com.example.gabriela.dispositivosmoveisacch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClickQtFaltas(View view) {
        Intent qtFaltasActivity = new Intent(MainActivity.this, QuantidadeFalta.class);
        startActivity(qtFaltasActivity);
    }

    public void onClickQtFaltasRestantes(View view) {
        Intent intent = new Intent(MainActivity.this, QuantidadeFaltaRestantes.class);
        startActivity(intent);
    }

    public void onClickHorarios(View view) {
        Intent intent = new Intent(MainActivity.this, MateriasActivity.class);
        startActivity(intent);
    }

    public void onClickHistorico(View view) {
        Intent intent = new Intent(MainActivity.this, HistoricoActivity.class);
        startActivity(intent);
    }
}
