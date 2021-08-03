package com.smallacademy.userroles;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class Descargas extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descargas);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.firstFragment:
                        Intent intent0 = new Intent(Descargas.this, MusicPlayer.class);
                        startActivity(intent0);
                        break;

                    case R.id.secondFragment:
                        Intent intent1 = new Intent(Descargas.this, NeuroAlma.class);
                        startActivity(intent1);
                        break;

                    case R.id.thirdFragment:
                        Intent intent2 = new Intent(Descargas.this, Carrito.class);
                        startActivity(intent2);
                        break;

                    case R.id.fourFragment:

                        break;

                    case R.id.fiveFragment:
                        Intent intent4 = new Intent(Descargas.this, Profile.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }
}