package com.example.apppracticab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonaAdapter extends BaseAdapter {

    //Contexto
    private Context contexto;
    private ArrayList<Persona> listaPersonas;


    public PersonaAdapter(Context contexto, ArrayList<Persona> listaPersonas) {
        this.contexto = contexto;
        this.listaPersonas = listaPersonas;
    }

    @Override
    public int getCount() {
        return listaPersonas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPersonas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //trabajar el view con los elementos
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_persona,parent,false);

        //obtencion de los textos
        TextView inicial = view.findViewById(R.id.txtInicial);
        TextView nombreCompleto = view.findViewById(R.id.txtNombreCompleto);
        TextView telefono = view.findViewById(R.id.txtTelefono);

        Persona persona = listaPersonas.get(position);

        inicial.setText(persona.getNombre().substring(0,1).toUpperCase()); //inicial del nombre en mayuscula
        nombreCompleto.setText(persona.getNombre()+" "+persona.getApPaterno()+" "+persona.getApMaterno());
        telefono.setText(String.valueOf(persona.getTelefono()));

        return view;

    }
}
