package com.example.siridhanyahub;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class HealthFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_health, container, false);

        LinearLayout container2 =
                view.findViewById(R.id.health_cards_container);

        // Add one card per millet
        addHealthCard(container2,
                "🌾 Navane (Foxtail Millet)",
                "✅ Controls blood sugar — good for diabetics\n"
                        + "✅ High fibre — aids digestion\n"
                        + "✅ Rich in iron — prevents anaemia\n"
                        + "✅ Gluten-free — safe for all ages\n"
                        + "💧 Needs 70% less water than rice",
                "#E8F5E9");

        addHealthCard(container2,
                "🌾 Sajje (Pearl Millet)",
                "✅ High in protein — builds muscle\n"
                        + "✅ Rich in magnesium — good for heart\n"
                        + "✅ Boosts energy — great for farmers\n"
                        + "✅ Keeps you full longer\n"
                        + "💧 Drought-resistant crop",
                "#FFF8E1");

        addHealthCard(container2,
                "🌾 Baragu (Sorghum)",
                "✅ High antioxidants — fights cancer risk\n"
                        + "✅ Lowers cholesterol\n"
                        + "✅ Good for weight management\n"
                        + "✅ Suitable for diabetic diet\n"
                        + "💧 Grows in dry, hot conditions",
                "#FBE9E7");

        addHealthCard(container2,
                "🌾 Ragi (Finger Millet)",
                "✅ Highest calcium of all grains\n"
                        + "✅ Excellent for growing children\n"
                        + "✅ Prevents osteoporosis\n"
                        + "✅ Reduces anxiety and stress\n"
                        + "💧 Grows in poor soil conditions",
                "#E3F2FD");

        return view;
    }

    // Helper — creates one health card dynamically
    private void addHealthCard(LinearLayout parent,
                               String title, String facts, String bgColor) {

        LinearLayout card = new LinearLayout(getContext());
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundColor(Color.parseColor(bgColor));
        card.setPadding(32, 24, 32, 24);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 16);
        card.setLayoutParams(params);

        TextView tvTitle = new TextView(getContext());
        tvTitle.setText(title);
        tvTitle.setTextSize(16);
        tvTitle.setTextColor(Color.parseColor("#3E2723"));
        tvTitle.setTypeface(null, android.graphics.Typeface.BOLD);
        tvTitle.setPadding(0, 0, 0, 10);

        TextView tvFacts = new TextView(getContext());
        tvFacts.setText(facts);
        tvFacts.setTextSize(13);
        tvFacts.setTextColor(Color.parseColor("#555555"));
        tvFacts.setLineSpacing(6, 1);

        card.addView(tvTitle);
        card.addView(tvFacts);
        parent.addView(card);
    }
}
