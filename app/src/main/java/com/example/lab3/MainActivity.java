package com.example.lab3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Random;

import static com.example.lab3.R.id.button_los;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

                Toast.makeText(getApplicationContext(),"Kliknięto przycisk FAB",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void Kliknij(View view){
        Toast.makeText(getApplicationContext(),"Kliknięto przycisk ZALOGUJ SIE DO APLIKACJI",
                Toast.LENGTH_SHORT).show();

        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    public void Aparat(View view){
        Toast.makeText(getApplicationContext(),"Kliknięto przycisk APARAT",
                Toast.LENGTH_SHORT).show();

        Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intencja,REQUEST_IMAGE_CAPTURE);
    }


    public void losowanie(View view){
        Random rand = new Random();
        int liczba = rand.nextInt((21-0)+1)+0;

        ImageButton do_losowania = (ImageButton) findViewById(R.id.button_los);


        if(liczba>=0 && liczba<=5){
            do_losowania.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_delete));
        }
        else if (liczba>=6 && liczba<=10){
            do_losowania.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_camera));

        }
        else if (liczba>=11 && liczba<=15){
            do_losowania.setImageDrawable(getResources().getDrawable(R.drawable.kwiatek));
        }

        else if (liczba>=16 && liczba<=21){
            do_losowania.setImageDrawable(getResources().getDrawable(R.drawable.chmura));
        }


    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        RelativeLayout lay = (RelativeLayout) findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(),imageBitmap));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk ACTION SETTINGS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_bar_search:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk APP BAR SEARCH", Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_bar_search1:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk APP BAR SEARCH 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_bar_switch:
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk APP BAR SWITCH", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
