package com.smallacademy.userroles;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.storage.FirebaseStorage;

import org.jetbrains.annotations.NotNull;

public class Profile extends AppCompatActivity {






    Button updateProfilee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);





        updateProfilee = (Button) findViewById(R.id.updateProfile);

        updateProfilee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),EditProfile.class);
                startActivity(i);
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.firstFragment:
                        Intent intent0 = new Intent(Profile.this, MusicPlayer.class);
                        startActivity(intent0);
                        break;

                    case R.id.secondFragment:
                        Intent intent1 = new Intent(Profile.this, NeuroAlma.class);
                        startActivity(intent1);
                        break;

                    case R.id.thirdFragment:
                        Intent intent2 = new Intent(Profile.this, Carrito.class);
                        startActivity(intent2);
                        break;

                    case R.id.fourFragment:
                        Intent intent3 = new Intent(Profile.this, Descargas.class);
                        startActivity(intent3);

                        break;
                    case R.id.fiveFragment:
                        break;
                }
                return false;
            }
        });


    }



    public void update(View view){

    }


    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();

    }
}
