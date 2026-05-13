package com.example.siridhanyahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_home, container, false);

        // Get bottom nav from parent Activity
        BottomNavigationView nav = requireActivity()
                .findViewById(R.id.bottom_navigation);

        // Each card navigates to its tab
        view.findViewById(R.id.card_mandi).setOnClickListener(v -> {
            nav.setSelectedItemId(R.id.nav_mandi);
        });
        view.findViewById(R.id.card_recipe).setOnClickListener(v -> {
            nav.setSelectedItemId(R.id.nav_recipe);
        });
        view.findViewById(R.id.card_health).setOnClickListener(v -> {
            nav.setSelectedItemId(R.id.nav_health);
        });
        view.findViewById(R.id.card_buy).setOnClickListener(v -> {
            nav.setSelectedItemId(R.id.nav_buy);
        });

        return view;
    }
}
