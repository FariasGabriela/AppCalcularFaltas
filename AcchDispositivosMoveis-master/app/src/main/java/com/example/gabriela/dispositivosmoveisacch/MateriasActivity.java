package com.example.gabriela.dispositivosmoveisacch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.gabriela.dispositivosmoveisacch.adapters.AdapterMaterias;

public class MateriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        ListView lvMaterias = findViewById(R.id.lvMaterias);
        lvMaterias.setAdapter( new AdapterMaterias(MateriasActivity.this));
    }
}
