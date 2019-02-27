package Data;

import java.util.Objects;

public class recipe {
    private String recipe_name;
    private String instructions;
    private String ingredients;

    public recipe(String recipe_name, String instructions, String ingredients) {
        this.recipe_name = recipe_name;
        this.instructions = instructions;
        this.ingredients = ingredients;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.recipe_name);
        hash = 23 * hash + Objects.hashCode(this.instructions);
        hash = 23 * hash + Objects.hashCode(this.ingredients);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final recipe other = (recipe) obj;
        if (!Objects.equals(this.recipe_name, other.recipe_name)) {
            return false;
        }
        if (!Objects.equals(this.instructions, other.instructions)) {
            return false;
        }
        if (!Objects.equals(this.ingredients, other.ingredients)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "recipe{" + "recipe_name=" + recipe_name + ", instructions=" + instructions + ", ingredients=" + ingredients + '}';
    }
}
