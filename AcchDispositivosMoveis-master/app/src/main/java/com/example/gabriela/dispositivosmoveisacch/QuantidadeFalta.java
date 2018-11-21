package com.example.gabriela.dispositivosmoveisacch;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabriela.dispositivosmoveisacch.controller.BancoController;
import com.example.gabriela.dispositivosmoveisacch.repository.HistoricoRepository;

public class QuantidadeFalta extends AppCompatActivity {
    int item;
    BancoController crud;
    EditText editQtAulas;
    EditText editResultado;
    EditText editMateria;
    EditText editHorario;
    Cursor cursor;
    private HistoricoRepository banco;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantidade_falta);

        bundle = getIntent().getExtras();

        if ( bundle != null  ) {
            item = bundle.getInt("idItem");
            crud = new BancoController(getBaseContext());

            editQtAulas = (EditText) findViewById(R.id.qtAulas);
            editMateria = (EditText) findViewById(R.id.nomeMateria);
            editHorario = (EditText) findViewById(R.id.horario);

            cursor = crud.carregaDadoById(item);
            editQtAulas.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.RESULTADO)));
            editMateria.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.MATERIA)));
            editHorario.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.HORARIO)));


        }

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
        BancoController crud = new BancoController(getBaseContext());
        TextView qtAulas = findViewById(R.id.qtAulas);
        TextView nomeMateria = findViewById(R.id.nomeMateria);
        TextView horarioMateria = findViewById(R.id.horario);

        if ( nomeMateria.getText().toString().isEmpty() ) {
            nomeMateria.requestFocus();
            nomeMateria.setError(getString(R.string.erropreco));
        } else if ( qtAulas.getText().toString().isEmpty() ) {
            qtAulas.requestFocus();
            qtAulas.setError(getString(R.string.erropreco));
        } else if ( bundle != null ) {
            Toast.makeText( getApplicationContext(), "Atualizado", Toast.LENGTH_LONG ).show();
            String nome = nomeMateria.getText().toString();
            int aulas =  Integer.parseInt(qtAulas.getText().toString());
            String horario = horarioMateria.getText().toString();
            crud.alterarDados(item, nome, Integer.toString(aulas), horario);
        }else {

            String nome = nomeMateria.getText().toString();
            Integer aulas = Integer.parseInt(qtAulas.getText().toString());
            double porcentagem = 25;
            String horario = horarioMateria.getText().toString();


            double resultado = aulas * (porcentagem / 100);

            Toast.makeText(getApplicationContext(),  "Você pode gazear " + Integer.toString( (int) resultado ) + " aulas"  , Toast.LENGTH_LONG).show();

            String banco = crud.insereDado(nome, Integer.toString(aulas), qtAulas.getText().toString(), horario );


        }


    }
}
