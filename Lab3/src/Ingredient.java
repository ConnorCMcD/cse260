
public class Ingredient {
	private String name, measuringUnit;
	private int calPerUnit;
	public Ingredient(String name, String measuringUnit, int caloriesPerUnit) {
		this.name = name;
		this.measuringUnit = measuringUnit;
		calPerUnit = caloriesPerUnit;
	}
	public String getName() {
		return name;
	}
	public String getMeasuringUnit() {
		return measuringUnit;
	}
	public int getCaloriesPerUnit() {
		return calPerUnit;
	}
	public boolean equals(Ingredient ingredient) {
		return (ingredient.getName().equals(name) && ingredient.getMeasuringUnit().equals(measuringUnit) && (ingredient.getCaloriesPerUnit() == calPerUnit));
	}
	public String toString() {
		return "Ingredient\nname=" + name + "\nmeasuringUnit=" + measuringUnit + "\ncaloriesPerUnit=" + calPerUnit;
	}
}
