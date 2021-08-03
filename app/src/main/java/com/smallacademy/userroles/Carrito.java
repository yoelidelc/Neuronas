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

public class Carrito extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.firstFragment:
                        Intent intent0 = new Intent(Carrito.this, MusicPlayer.class);
                        startActivity(intent0);
                        break;

                    case R.id.secondFragment:
                        Intent intent1 = new Intent(Carrito.this, NeuroAlma.class);
                        startActivity(intent1);
                        break;

                    case R.id.thirdFragment:
                        break;

                    case R.id.fourFragment:
                        Intent intent3 = new Intent(Carrito.this, Descargas.class);
                        startActivity(intent3);

                        break;
                    case R.id.fiveFragment:
                        Intent intent4 = new Intent(Carrito.this, Profile.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }
}
