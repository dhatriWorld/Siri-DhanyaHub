package com.example.siridhanyahub;

import android.content.SharedPreferences;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecipeAdapter extends
        RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList;
    private Context context;
    private SharedPreferences prefs;

    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
        prefs = context.getSharedPreferences(
                "favourites", Context.MODE_PRIVATE);
    }

    @NonNull @Override
    public RecipeViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);

        holder.tvName.setText(recipe.getRecipeName());
        holder.tvMilletType.setText(recipe.getMilletType());
        holder.tvDescription.setText(recipe.getDescription());
        holder.tvPrepTime.setText("⏱ " + recipe.getPrepTime());

        // Show filled heart if already saved
        boolean isFav = prefs.getBoolean(recipe.getId(), false);
        holder.btnFav.setText(isFav ? "❤️" : "🤍");

        // Save / unsave on heart tap
        holder.btnFav.setOnClickListener(v -> {
            boolean current = prefs.getBoolean(recipe.getId(), false);
            prefs.edit().putBoolean(recipe.getId(), !current).apply();
            holder.btnFav.setText(!current ? "❤️" : "🤍");
            Toast.makeText(context,
                    !current ? "Saved to Favourites ❤️"
                            : "Removed from Favourites",
                    Toast.LENGTH_SHORT).show();
        });
        // Click on the recipe card → open detail screen
        holder.itemView.setOnClickListener(v -> {
            android.content.Intent intent = new
                    android.content.Intent(context,
                    RecipeDetailActivity.class);
            intent.putExtra("name",   recipe.getRecipeName());
            intent.putExtra("millet", recipe.getMilletType());
            intent.putExtra("desc",   recipe.getDescription());
            intent.putExtra("steps",  recipe.getSteps());
            intent.putExtra("prep",   recipe.getPrepTime());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return recipeList.size(); }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvMilletType, tvDescription,
                tvPrepTime, btnFav;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName        = itemView.findViewById(R.id.tv_recipe_name);
            tvMilletType  = itemView.findViewById(R.id.tv_millet_type);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvPrepTime    = itemView.findViewById(R.id.tv_prep_time);
            btnFav        = itemView.findViewById(R.id.btn_favourite);
        }
    }
}