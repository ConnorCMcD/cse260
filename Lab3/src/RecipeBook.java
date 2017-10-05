import java.util.ArrayList;

public class RecipeBook {
	private String name;
	private ArrayList<CookingRecipe> recipes = new ArrayList<CookingRecipe>();
	public RecipeBook(String bookName) {
		name = bookName;
	}
	public CookingRecipe addRecipe(String name, RecipeIngredient[] ingredients) {
		for(CookingRecipe r:recipes) {
			if(r.getName().equals(name)) {
				return null;
			}
		}
		CookingRecipe r = new CookingRecipe(name);
		for(RecipeIngredient i:ingredients) {
			r.addOrUpdateIngredient(i, i.getQuantity());
		}
		recipes.add(r);
		return r;
	}
	public CookingRecipe removeRecipe(String name) {
		for(CookingRecipe r:recipes) {
			if(r.getName().equals(name)) {
				recipes.remove(r);
				return r;
			}
		}
		return null;
	}
	public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients) {
		ArrayList<CookingRecipe> foundRecipes = new ArrayList<CookingRecipe>();
		for(CookingRecipe r:recipes) {
			boolean hasIngredients = true;
			for(RecipeIngredient i:ingredients) {
				if(r.getRecipeIngredient(i) == null) {
					hasIngredients = false;
					break;
				}
			}
			if(hasIngredients) {
				foundRecipes.add(r);
			}
		}
		if(foundRecipes.isEmpty()) {
			return null;
		}else {
			return (CookingRecipe[]) foundRecipes.toArray();
		}
	}
	public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients) {
		ArrayList<CookingRecipe> foundRecipes = new ArrayList<CookingRecipe>();
		for(CookingRecipe r:recipes) {
			if(r.getNumberOfIngredients() < numberOfIngredients) {
				foundRecipes.add(r);
			}
		}
		if(foundRecipes.isEmpty()) {
			return null;
		}else {
			return (CookingRecipe[]) foundRecipes.toArray();
		}
	}
	public CookingRecipe[] findRecipesLowCalories() {
		float lowestCal = recipes.get(0).calculateCalories();
		ArrayList<CookingRecipe> foundRecipes = new ArrayList<CookingRecipe>();
		for(CookingRecipe r:recipes) {
			if(r.calculateCalories()<lowestCal) {
				foundRecipes.clear();
				foundRecipes.add(r);
				lowestCal = r.calculateCalories();
			}else if(r.calculateCalories()==lowestCal) {
				foundRecipes.add(r);
			}
		}
		return (CookingRecipe[]) foundRecipes.toArray();
	}
	public String getName() {
		return name;
	}
}
