
public class RecipeIngredient extends Ingredient {
	private float quantity;
	public RecipeIngredient(String name, String measuringUnit, int caloriesPerUnit, float quantity) {
		super(name, measuringUnit, caloriesPerUnit);
		this.quantity = quantity;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
}
