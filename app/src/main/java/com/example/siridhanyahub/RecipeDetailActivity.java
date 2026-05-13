package com.example.siridhanyahub;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // Receive data sent from RecipeAdapter
        String name = getIntent().getStringExtra("name");
        String millet = getIntent().getStringExtra("millet");
        String desc = getIntent().getStringExtra("desc");
        String steps = getIntent().getStringExtra("steps");
        String prep = getIntent().getStringExtra("prep");

        // Fill in the header fields
        ((TextView) findViewById(R.id.tv_detail_title)).setText(name);
        ((TextView) findViewById(R.id.tv_detail_millet)).setText(millet);
        ((TextView) findViewById(R.id.tv_detail_description)).setText(desc);
        ((TextView) findViewById(R.id.tv_detail_prep)).setText("⏱ " + prep);

        // Back button closes this screen
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());

        // Build step-by-step cards from the steps string
        LinearLayout stepsContainer =
                findViewById(R.id.steps_container);

        String[] stepList = steps.split("\\n");
        for (int i = 0; i < stepList.length; i++) {
            stepsContainer.addView(
                    makeStepCard(i + 1, stepList[i].trim()));
        }
    }

    // Creates one numbered step card
    private LinearLayout makeStepCard(int stepNum, String stepText) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setBackgroundColor(Color.WHITE);
        row.setPadding(16, 16, 16, 16);
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 8);
        row.setLayoutParams(lp);

        // Step number circle
        TextView numView = new TextView(this);
        numView.setText(String.valueOf(stepNum));
        numView.setTextSize(14);
        numView.setTextColor(Color.WHITE);
        numView.setTypeface(null, android.graphics.Typeface.BOLD);
        numView.setBackgroundColor(Color.parseColor("#5D4037"));
        numView.setPadding(18, 10, 18, 10);
        LinearLayout.LayoutParams np =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        np.setMargins(0, 0, 14, 0);
        numView.setLayoutParams(np);

        // Step text
        TextView stepView = new TextView(this);
        stepView.setText(stepText);
        stepView.setTextSize(14);
        stepView.setTextColor(Color.parseColor("#333333"));

        row.addView(numView);
        row.addView(stepView);
        return row;
    }
}