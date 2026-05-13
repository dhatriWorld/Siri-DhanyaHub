package com.example.siridhanyahub;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class BuyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_buy, container, false);

        LinearLayout fpoContainer =
                view.findViewById(R.id.fpo_cards_container);

        // Add FPO contact cards
        addFpoCard(fpoContainer,
                "🌾 Davangere Millet FPO",
                "📍 Davangere, Karnataka",
                "Navane, Sajje, Baragu",
                "📞 +91 98765 43210",
                "Min order: 10 kg  |  Delivery available");

        addFpoCard(fpoContainer,
                "🌾 Mysuru Organic Farmers",
                "📍 Mysuru, Karnataka",
                "Ragi, Navane",
                "📞 +91 87654 32109",
                "Min order: 5 kg  |  100% Organic certified");

        addFpoCard(fpoContainer,
                "🌾 Hubli Siri-Dhanya Group",
                "📍 Hubli-Dharwad, Karnataka",
                "Baragu, Sajje, Ragi",
                "📞 +91 76543 21098",
                "Min order: 20 kg  |  Wholesale rates");

        addFpoCard(fpoContainer,
                "🌾 Bengaluru Millet Network",
                "📍 Bengaluru, Karnataka",
                "All millet types",
                "📞 +91 65432 10987",
                "Min order: 2 kg  |  Home delivery");

        return view;
    }

    // Helper — creates one FPO card dynamically
    private void addFpoCard(LinearLayout parent, String name,
                            String location, String millets,
                            String phone, String details) {

        LinearLayout card = new LinearLayout(getContext());
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundColor(Color.WHITE);
        card.setPadding(32, 24, 32, 24);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 12);
        card.setLayoutParams(params);

        card.addView(makeText(name, 16, "#3E2723", true));
        card.addView(makeText(location, 13, "#888888", false));
        card.addView(makeText("Sells: " + millets, 13, "#5D4037", false));
        card.addView(makeText(phone, 14, "#388E3C", true));
        card.addView(makeText(details, 12, "#999999", false));

        parent.addView(card);
    }

    // Helper — makes a styled TextView
    private TextView makeText(String text, int size,
                              String color, boolean bold) {
        TextView tv = new TextView(getContext());
        tv.setText(text);
        tv.setTextSize(size);
        tv.setTextColor(Color.parseColor(color));
        tv.setPadding(0, 4, 0, 4);
        if (bold) tv.setTypeface(null,
                android.graphics.Typeface.BOLD);
        return tv;
    }
}