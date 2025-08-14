package com.example.apppracticab;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    private ArrayList<Persona> registroPersonas;

    PersonaAdapter personaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       lista = findViewById(R.id.listaPrincipal); //listView

       registroPersonas = new ArrayList<>();

        registroPersonas.add(new Persona("Jose","Lopez","Caceres",77563256));
        registroPersonas.add(new Persona("Maria","Gomez","Bolaños",77563256));
        registroPersonas.add(new Persona("Roberto","Barragan","Caceres",77563256));
        registroPersonas.add(new Persona("Anna","Peredo","Rojas",77563256));
        registroPersonas.add(new Persona("Emma","Mendez","Gonzales",77563256));

        personaAdapter = new PersonaAdapter(getApplicationContext(), registroPersonas);
        lista.setAdapter(personaAdapter);

    }
}