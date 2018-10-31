package com.example.gabriela.dispositivosmoveisacch.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gabriela.dispositivosmoveisacch.R;
import com.example.gabriela.dispositivosmoveisacch.entidades.Materia;

import java.util.ArrayList;
import java.util.Arrays;

public class AdapterMaterias extends BaseAdapter {

    private ArrayList<Materia> materias = new ArrayList<>(Arrays.asList(new Materia[]{
            new Materia( "Programação para Dispositivos Moveis ", "Segunda : 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
            new Materia( "Verificação e Validação ", "Segunda: 19:00 - 20:30" ),
    }));

    private Context context;

    public AdapterMaterias(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return materias.size();
    }

    @Override
    public Materia getItem(int position) {
        return materias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_materia, parent, false);

        TextView lblMateria = view.findViewById(R.id.lblMateria);
        TextView lblHorario = view.findViewById(R.id.lblHorario);

        lblMateria.setText( materias.get(position).getNome() );
        lblHorario.setText( materias.get(position).getHorarios() );

        return view;
    }
}
