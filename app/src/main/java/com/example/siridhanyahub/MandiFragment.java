package com.example.siridhanyahub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MandiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_mandi, container, false);

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_mandi);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

        // Load simulated price data
        List<MilletPrice> priceList = getSampleData();
        MandiAdapter adapter = new MandiAdapter(priceList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Simulated millet price data
    private List<MilletPrice> getSampleData() {
        List<MilletPrice> list = new ArrayList<>();

        list.add(new MilletPrice(
                "Navane (Foxtail Millet)", "Davangere",
                45.50, 48.00, 42.00, "UP"));

        list.add(new MilletPrice(
                "Sajje (Pearl Millet)", "Bengaluru",
                38.00, 40.50, 35.00, "DOWN"));

        list.add(new MilletPrice(
                "Baragu (Sorghum)", "Mysuru",
                32.75, 35.00, 30.00, "UP"));

        list.add(new MilletPrice(
                "Ragi (Finger Millet)", "Hubli",
                52.00, 55.00, 49.00, "UP"));

        list.add(new MilletPrice(
                "Navane (Foxtail Millet)", "Bengaluru",
                47.00, 50.00, 44.00, "DOWN"));

        list.add(new MilletPrice(
                "Sajje (Pearl Millet)", "Davangere",
                36.50, 39.00, 34.00, "UP"));

        return list;
    }
}