package com.example.gabriela.dispositivosmoveisacch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabriela.dispositivosmoveisacch.controller.BancoController;

public class QuantidadeFaltaRestantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantidade_falta_restantes);
    }

    public void onClickVoltar(View view) {
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }

    public void onClickCalcular(View view) {
        BancoController crud = new BancoController(getBaseContext());
        TextView qtFaltas = findViewById(R.id.qtFaltas);
        TextView qtAulas = findViewById(R.id.qtAulas);
        TextView porcFaltas = findViewById(R.id.porcFaltas);
        TextView qtTotalRestante = findViewById(R.id.total);

        if ( qtAulas.getText().toString().isEmpty() ) {
            qtAulas.requestFocus();
            qtAulas.setError(getString(R.string.erropreco));
        } else if ( qtFaltas.getText().toString().isEmpty() ) {
            qtFaltas.requestFocus();
            qtFaltas.setError(getString(R.string.erropreco));
        } else {

            int faltas = Integer.parseInt(qtFaltas.getText().toString());
            double aulas = Integer.parseInt(qtAulas.getText().toString());
            double porcentagem = Integer.parseInt(porcFaltas.getText().toString().replace("%", ""));

            double resultado = aulas * (porcentagem / 100);
            int faltasRestantes = (int) resultado - faltas;

            if (faltasRestantes > 0) {
                qtTotalRestante.setText("Você ainda pode gazear " + Integer.toString(faltasRestantes) + " aulas");
            } else if (faltasRestantes == 0) {
                qtTotalRestante.setText("Você não pode mais faltar :/");
            } else {
                qtTotalRestante.setText(" Tarde de mais camarada, talvez no próximo semestre ):");
            }

        }
    }
}
