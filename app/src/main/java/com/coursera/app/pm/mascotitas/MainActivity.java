package com.coursera.app.pm.mascotitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private Toolbar mToolbar;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.primero,"Rambo",0));
        mascotas.add(new Mascota(R.drawable.segundo,"Dina",1));
        mascotas.add(new Mascota(R.drawable.tercero,"Perla",2));
        mascotas.add(new Mascota(R.drawable.cuarto,"Steben",3));
        mascotas.add(new Mascota(R.drawable.quinto,"Choco",3));
        mascotas.add(new Mascota(R.drawable.sexto,"Filulay",3));
        mascotas.add(new Mascota(R.drawable.septimo,"Betoben",3));
        mascotas.add(new Mascota(R.drawable.octavo,"Mimo",3));

        rv = (RecyclerView) findViewById(R.id.rvMascotas);

        //GridLayoutManager glm = new GridLayoutManager(this,2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation( LinearLayoutManager.VERTICAL );

        //rv.setLayoutManager(glm);
        rv.setLayoutManager(llm);
        inicializarListaMascotas();
    }

    private void inicializarListaMascotas() {
        MascotaAdapter ada = new MascotaAdapter(mascotas);
        rv.setAdapter( ada );
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
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_star) {
            Intent intent = new Intent(this, DetalleActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
