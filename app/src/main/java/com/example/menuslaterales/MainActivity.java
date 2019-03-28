package com.example.menuslaterales;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements datos.OnFragmentInteractionListener, fragmenttres.OnFragmentInteractionListener
{

    DrawerLayout drawerLayout;
    ListView listView;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar  = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        drawerLayout = findViewById(R.id.drawerlayout);
        listView= findViewById(R.id.menulateral);
        linearLayout=findViewById(R.id.contenedor);


        String[] lista= {"Opcion1","Opcion2","Opcion3","Opcion4","Opcion5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,lista);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {


                String pos;
                pos = (String) listView.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this,pos,Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(listView);
                switch(pos)
                {
                    case "Opcion1":

                        datos datos= new datos();
                        FragmentTransaction transaction;
                        transaction= getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.contenedor,datos);
                        transaction.commitNow();
                        break;
                    case "Opcion2":
                        fragmenttres fragmenttres = new fragmenttres();
                        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                        transaction1.replace(R.id.contenedor,fragmenttres);
                        transaction1.commitNow();
                        break;

                }

//                datos frag = datos.newInstance("datos","Fragment 2");
//                getSupportFragmentManager();


            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();


        if(id==android.R.id.home)
        {
            if (drawerLayout.isDrawerOpen(listView))
            {
                drawerLayout.closeDrawer(listView);
            }
            else
                {
                    drawerLayout.openDrawer(listView);
                }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}