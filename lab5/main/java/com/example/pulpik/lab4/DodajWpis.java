package com.example.pulpik.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class DodajWpis extends AppCompatActivity {
    private int modify_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);

        ArrayAdapter gatunki = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[] {"Pies","Kot","Koń","Gołąb","Kruk","Dzik","Karp","Osioł"});
        Spinner gatunek = (Spinner) findViewById
                (R.id.input_gatunek);
        gatunek.setAdapter(gatunki);


        Bundle extras = getIntent().getExtras();
        try {
            if(extras.getSerializable("element") != null) {
                Animal zwierz = (Animal) extras.getSerializable("element");
                Spinner formGatunek = (Spinner) findViewById(R.id.input_gatunek);
                EditText kolor = (EditText) findViewById(R.id.inputKolor);
                EditText wielkosc = (EditText) findViewById(R.id.input_wielkosc);
                EditText opis = (EditText) findViewById(R.id.input_opis);


                kolor.setText(zwierz.getKolor());
                wielkosc.setText(Float.toString(zwierz.getWielkosc()));
                opis.setText(zwierz.getOpis());

                int i;
                switch (zwierz.getGatunek()) {
                    case "Pies": i = 0; break;
                    case "Kot": i = 1; break;
                    case "Koń": i = 2;break;
                    case "Gołąb": i = 3;break;
                    case "Kruk": i = 4;break;
                    case "Dzik": i = 5;break;
                    case "Karp": i = 6;break;
                    case "Osioł": i = 7;break;
                    default: i = -1;
                }
                formGatunek.setSelection(i);

                this.modify_id = zwierz.getId();
            }
        }catch(Exception ex) {
            this.modify_id=0;
        }


    }

    public void wyslij(View view) {
        EditText kolor = (EditText) findViewById(R.id.inputKolor);
        EditText wielkosc = (EditText) findViewById(R.id.input_wielkosc);
        EditText opis = (EditText) findViewById(R.id.input_opis);
        Spinner gatunek = (Spinner) findViewById(R.id.input_gatunek);

        Animal zwierze = new Animal(
                gatunek.getSelectedItem().toString(),
                kolor.getText().toString(),
                Float.valueOf(wielkosc.getText().toString()),
                opis.getText().toString()
        );

        zwierze.setId(this.modify_id);

        Intent intencja = new Intent();
        intencja.putExtra("nowy", zwierze);
        setResult(RESULT_OK, intencja);
        finish();

    }
}