import java.util.ArrayList;

public class CookingRecipe {
	private String name;
	private ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
	public CookingRecipe(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void addOrUpdateIngredient(Ingredient ingredient, float quantity) {
		RecipeIngredient i = getRecipeIngredient(ingredient);
		if(i != null) {
			i.setQuantity(quantity);
		}
		else {
			ingredients.add(new RecipeIngredient(ingredient.getName(), ingredient.getMeasuringUnit(), ingredient.getCaloriesPerUnit(), quantity));
		}
		return;
	}
	public RecipeIngredient getRecipeIngredient(Ingredient ingredient) {
		for(RecipeIngredient i:ingredients) {
			if(i.equals(ingredient)) {
				return i;
			}
		}
		return null;
	}
	public RecipeIngredient getRecipeIngredient(String ingredientName) {
		for(RecipeIngredient i:ingredients) {
			if(i.getName().equals(ingredientName)) {
				return i;
			}
		}
		return null;
	}
	public RecipeIngredient removeRecipeIngredient(Ingredient ingredient) {
		for(RecipeIngredient i:ingredients) {
			if(i.equals(ingredient)) {
				ingredients.remove(i);
				return i;
			}
		}
		return null;
	}
	public RecipeIngredient removeRecipeIngredient(String ingredientName) {
		for(RecipeIngredient i:ingredients) {
			if(i.getName().equals(ingredientName)) {
				ingredients.remove(i);
				return i;
			}
		}
		return null;
	}
	public float calculateCalories() {
		float calories = 0;
		for(RecipeIngredient i:ingredients) {
			calories += (i.getCaloriesPerUnit() * i.getQuantity());
		}
		return calories;
	}
	public int getNumberOfIngredients() {
		return ingredients.size();
	}
	public String toString() {
		String s = getName()+ ":";
		for(RecipeIngredient i:ingredients) {
			s = s + String.format(" %s %.2f %s,", i.getName(), i.getQuantity(), i.getMeasuringUnit());
		}
		return s;
	}
}
