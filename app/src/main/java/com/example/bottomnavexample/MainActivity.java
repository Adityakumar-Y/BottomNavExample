package com.example.bottomnavexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavexample.Fragments.FavoritesFragment;
import com.example.bottomnavexample.Fragments.HomeFragment;
import com.example.bottomnavexample.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch(menuItem.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_search1:
                        fragment = new SearchFragment();
                        break;
                    case R.id.nav_favorites:
                        fragment = new FavoritesFragment();
                        break;
                    case R.id.nav_search:
                        fragment = new SearchFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                return true;
            }
        });

    }


}
