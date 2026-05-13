package com.example.siridhanyahub;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecipeFragment extends Fragment {

    private RecipeAdapter adapter;
    private List<Recipe> allRecipes;
    private List<Recipe> filteredRecipes;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_recipe, container, false);

        // Load all recipes
        allRecipes = getSampleRecipes();
        filteredRecipes = new ArrayList<>(allRecipes);

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_recipe);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        adapter = new RecipeAdapter(getContext(), filteredRecipes);
        recyclerView.setAdapter(adapter);

        // Search bar — filter by millet type as user types
        EditText searchBar = view.findViewById(R.id.et_search);
        searchBar.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s,
                                      int a, int b, int c) { filterRecipes(s.toString()); }
            public void beforeTextChanged(CharSequence s,
                                          int a, int b, int c) {}
            public void afterTextChanged(Editable e) {}
        });

        return view;
    }

    // Filter recipes by millet type
    private void filterRecipes(String query) {
        filteredRecipes.clear();
        if (query.isEmpty()) {
            filteredRecipes.addAll(allRecipes);
        } else {
            for (Recipe r : allRecipes) {
                if (r.getMilletType().toLowerCase()
                        .contains(query.toLowerCase())) {
                    filteredRecipes.add(r);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    // Sample recipe data
    private List<Recipe> getSampleRecipes() {
        List<Recipe> list = new ArrayList<>();
        list.add(new Recipe("r1",
                "Navane Dosa", "Navane",
                "Crispy foxtail millet dosa, healthy breakfast",
                "1.Soak Navane 4hrs\n2.Grind to batter\n3.Ferment overnight\n4.Make dosa on tawa",
                "30 mins"));
        list.add(new Recipe("r2",
                "Sajje Roti", "Sajje",
                "Soft pearl millet flatbread, rich in iron",
                "1.Mix Sajje flour + water\n2.Knead dough\n3.Roll flat\n4.Cook on tawa 3 mins each side",
                "20 mins"));
        list.add(new Recipe("r3",
                "Baragu Khichdi", "Baragu",
                "Comforting sorghum khichdi for all ages",
                "1.Wash Baragu\n2.Pressure cook with dal\n3.Add ghee + spices\n4.Serve hot",
                "25 mins"));
        list.add(new Recipe("r4",
                "Ragi Mudde", "Ragi",
                "Traditional Karnataka finger millet balls",
                "1.Boil water\n2.Add Ragi flour\n3.Stir continuously\n4.Shape into balls\n5.Serve with sambar",
                "15 mins"));
        list.add(new Recipe("r5",
                "Navane Pongal", "Navane",
                "Sweet foxtail millet pongal for festivals",
                "1.Cook Navane with jaggery\n2.Add cardamom\n3.Mix ghee + cashews\n4.Serve warm",
                "35 mins"));
        return list;
    }
}