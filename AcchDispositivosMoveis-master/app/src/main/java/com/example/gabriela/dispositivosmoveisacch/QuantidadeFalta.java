package com.example.gabriela.dispositivosmoveisacch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class QuantidadeFalta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantidade_falta);
    }
    public void onClickVoltar(View view) {
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }

    private boolean validarCamposVazios(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    public void onClickCalcular(View view) {
        TextView qtAulas = findViewById(R.id.qtAulas);
        TextView porcFaltas = findViewById(R.id.porcFaltas);
        TextView valorResultado = findViewById(R.id.resultado);

        double aulas = Integer.parseInt(qtAulas.getText().toString());
        double porcentagem = Integer.parseInt(porcFaltas.getText().toString().replace("%", ""));


        if ( aulas == 0 ){
            qtAulas.requestFocus();
        }else {

            double resultado = aulas * (porcentagem / 100);

            if (resultado > 0) {
                valorResultado.setText( "Você pode gazear " + Integer.toString( (int) resultado ) + " aulas" );
            } else if (resultado == 0) {
                valorResultado.setText("Você não pode mais faltar :/");
            } else {
                valorResultado.setText(" Tarde de mais camarada, talvez no próximo semestre ):");
            }
        }


    }
}
