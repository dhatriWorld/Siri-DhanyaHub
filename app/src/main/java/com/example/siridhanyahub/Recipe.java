package com.example.siridhanyahub;

public class Recipe {
    private String id;
    private String recipeName;
    private String milletType;    // "Navane", "Sajje", "Baragu"
    private String description;
    private String steps;         // cooking steps
    private String prepTime;      // e.g. "20 mins"

    public Recipe(String id, String recipeName, String milletType,
                  String description, String steps, String prepTime) {
        this.id = id;
        this.recipeName = recipeName;
        this.milletType = milletType;
        this.description = description;
        this.steps = steps;
        this.prepTime = prepTime;
    }

    public String getId() { return id; }
    public String getRecipeName() { return recipeName; }
    public String getMilletType() { return milletType; }
    public String getDescription() { return description; }
    public String getSteps() { return steps; }
    public String getPrepTime() { return prepTime; }
}