package com.smallacademy.userroles;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import org.jetbrains.annotations.NotNull;


public class NeuroAlma extends AppCompatActivity {


    private AdView mAdView;

    GridView gridView;
    String[] neuroNames = {"Tranquilidad", "Paz", "Evolución Personal", "Regresión"};
    String[] neuroPrices = {"$3.88","$5.43","$4.99","$2.56"};
    int[] neuroImages = {R.drawable.horoscopo,R.drawable.meditacion,R.drawable.eespiritual,R.drawable.horoscopo};


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neuro_alma);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });




        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Details.class);
                intent.putExtra("name",neuroNames[position]);
                intent.putExtra("price",neuroPrices[position]);
                intent.putExtra("image",neuroImages[position]);

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
                        Intent intent0 = new Intent(NeuroAlma.this, MusicPlayer.class);
                        startActivity(intent0);
                        break;

                    case R.id.secondFragment:

                        break;

                    case R.id.thirdFragment:
                        Intent intent2 = new Intent(NeuroAlma.this, Carrito.class);
                        startActivity(intent2);
                        break;

                    case R.id.fourFragment:
                        Intent intent3 = new Intent(NeuroAlma.this, Descargas.class);
                        startActivity(intent3);

                        break;
                    case R.id.fiveFragment:
                        Intent intent4 = new Intent(NeuroAlma.this, Profile.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });

    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return neuroImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView name = view1.findViewById(R.id.neuros);
            TextView price = view1.findViewById(R.id.prices);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(neuroNames[position]);
            price.setText(neuroPrices[position]);
            image.setImageResource(neuroImages[position]);
            return view1;
        }
    }
}
