package com.example.gabriela.dispositivosmoveisacch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gabriela.dispositivosmoveisacch.controller.BancoController;

public class DialogItemHistorico extends AlertDialog {
    private Context context;
    private int idItem;
    private onFinishDialog listener;

    protected DialogItemHistorico(Context context, int idItem, onFinishDialog listener) {
        super(context);
        this.context = context;
        this.idItem = idItem;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_item_historico);
        Button buttonExcluir = findViewById(R.id.btnExcluir);
        Button buttonEditar = findViewById(R.id.btnEditar);

        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluir();
            }
        });
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar();

            }
        });

    }

    public void excluir(){
        BancoController crud = new BancoController(context);

        Toast.makeText( context, "Excluir", Toast.LENGTH_SHORT ).show();
        crud.deleteDados(idItem);

        this.dismiss();
        listener.onFinishedDialog();
    }

    public void editar(){
        Toast.makeText( context, "Editar", Toast.LENGTH_SHORT ).show();
        Intent intent = new Intent(context, QuantidadeFalta.class);
        intent.putExtra( "idItem", idItem );
        context.startActivity(intent);

    }

    public interface onFinishDialog{
        void onFinishedDialog();
    }
}
