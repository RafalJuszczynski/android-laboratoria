package com.example.lab2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Metoda onCreate",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Metoda onResume",Toast.LENGTH_SHORT).show();

    }

    //wstrzymane
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"Metoda onPause",Toast.LENGTH_SHORT).show();

    }

    //przykryte
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"Metoda onStop",Toast.LENGTH_SHORT).show();

    }
    //zniszczone
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Metoda onDestroy",Toast.LENGTH_SHORT).show();

    }
    //przywrocone
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"Metoda onRestart",Toast.LENGTH_SHORT).show();

    }


}
