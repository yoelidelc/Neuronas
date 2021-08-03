package com.smallacademy.userroles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class Details extends AppCompatActivity {

    TextView name,price;
    ImageView image;

    Button addcar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        addcar = (Button) findViewById(R.id.addcar);

        addcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this, Carrito.class);
                startActivity(intent);
            }
        });



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.firstFragment:
                        Intent intent0 = new Intent(Details.this, MusicPlayer.class);
                        startActivity(intent0);
                        break;

                    case R.id.secondFragment:

                        break;

                    case R.id.thirdFragment:
                        Intent intent2 = new Intent(Details.this, Carrito.class);
                        startActivity(intent2);
                        break;

                    case R.id.fourFragment:
                        Intent intent3 = new Intent(Details.this, Descargas.class);
                        startActivity(intent3);

                        break;
                    case R.id.fiveFragment:
                        Intent intent4 = new Intent(Details.this, Profile.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });


        name = findViewById(R.id.griddata);
        price = findViewById(R.id.textView_price);
        image = findViewById(R.id.imageView_carrito);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));
        image.setImageResource(intent.getIntExtra("image",0));

    }
}