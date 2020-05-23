package com.example.pulpik.lab3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.content.Intent;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    static final int  REQUEST_IMAGE_CAPTURE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk FAB", Toast.LENGTH_SHORT).show();

            }
        });


        final ImageView btnTest =(ImageView) findViewById(R.id.ikonka);
        final Button button = (Button) findViewById(R.id.button_zmien);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final int random = new Random().nextInt(4)+1;
                int id = getResources().getIdentifier("a"+random, "drawable", getPackageName());
                btnTest.setImageResource(id);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void kliknij(View obiekt ){

        Toast.makeText(getApplicationContext(),"Kliknieto przycisk Button", Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intencja);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk Settings", Toast.LENGTH_SHORT).show();
                Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja,REQUEST_IMAGE_CAPTURE);
                return true;
            case R.id.action_settings2:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk Weather", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings3:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk App", Toast.LENGTH_SHORT).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onActivityResult(int RequestCode, int resultCode, Intent data){
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.con);
        lay.setBackground(new BitmapDrawable(getResources(),imageBitmap));


    }



}
