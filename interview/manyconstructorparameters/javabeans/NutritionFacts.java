package interview.manyconstructorparameters.javabeans;

public class NutritionFacts {
    private int servingSize;  // (mL)            required
    private int servings;     // (per container) required
    private int calories;     // (per serving)   optional
    private int fat;          // (g/serving)     optional
    private int sodium;       // (mg/serving)    optional
    private int carbohydrate; // (g/serving)     optional

    public NutritionFacts() {

    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}
