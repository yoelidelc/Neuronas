package com.smallacademy.userroles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.util.ArrayList;


public class MusicPlayer extends AppCompatActivity {


    public ArrayList<Music> arrayList;
    public CustomMusicAdapter adapter;
    public ListView songList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.firstFragment:
                        break;

                    case R.id.secondFragment:
                        Intent intent1 = new Intent(MusicPlayer.this, NeuroAlma.class);
                        startActivity(intent1);
                        break;

                    case R.id.thirdFragment:
                        Intent intent2 = new Intent(MusicPlayer.this, Carrito.class);
                        startActivity(intent2);
                        break;

                    case R.id.fourFragment:
                        Intent intent3 = new Intent(MusicPlayer.this, Descargas.class);
                        startActivity(intent3);

                        break;
                    case R.id.fiveFragment:
                        Intent intent4 = new Intent(MusicPlayer.this, Profile.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });


        songList = (ListView) findViewById(R.id.lsongList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("1-. Barrido Emocional"," ",R.raw.barrido_emocional));
        arrayList.add(new Music("2.- Regresión"," ",R.raw.regresion));
        arrayList.add(new Music("3.- Kundalini y la Glándula Pineal"," ",R.raw.kundalini));
        arrayList.add(new Music("4.- Utilizando la bioquímica para sanar"," ",R.raw.kundalini));
        arrayList.add(new Music("5.- Activación de mi metamorfosis bioquímica"," ",R.raw.activacion));
        arrayList.add(new Music("6.- Activando mi sanación quántica"," ",R.raw.activando));
        arrayList.add(new Music("7.- Equilibrando mi energía quántica"," ",R.raw.equilibrando));
        arrayList.add(new Music("8.- Limitando la vejez y las enfermedades"," ",R.raw.limitando));
        arrayList.add(new Music("9.- Repotenciando mi alma"," ",R.raw.repotenciando));
        arrayList.add(new Music("10.- Sanación quántica del planeta y mi país"," ",R.raw.sanacion));
        arrayList.add(new Music("11.- Miedo al éxito y al fracaso"," ",R.raw.miedoalexito));

        adapter = new CustomMusicAdapter(this,R.layout.custom_music_item,arrayList);
        songList.setAdapter(adapter);

    }

    @Override
    public void onBackPressed(){

    }



}