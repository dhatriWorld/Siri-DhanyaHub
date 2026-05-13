package com.example.siridhanyahub;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load Home screen first when app opens
        loadFragment(new HomeFragment());

        BottomNavigationView bottomNav =
                findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment;
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                fragment = new HomeFragment();
            } else if (id == R.id.nav_mandi) {
                fragment = new MandiFragment();
            } else if (id == R.id.nav_recipe) {
                fragment = new RecipeFragment();
            } else if (id == R.id.nav_health) {
                fragment = new HealthFragment();
            } else {
                fragment = new BuyFragment();
            }
            loadFragment(fragment);
            return true;
        });
    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}