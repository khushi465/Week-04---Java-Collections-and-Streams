
import java.util.*;

interface MealPlan {

    String getMealType();

    List<String> getMeals();
}

class VegetarianMeal implements MealPlan {

    public String getMealType() {
        return "Vegetarian";
    }

    public List<String> getMeals() {
        return Arrays.asList("Grilled Paneer", "Salad", "Rice & Lentils");
    }
}

class VeganMeal implements MealPlan {

    public String getMealType() {
        return "Vegan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Tofu Stir Fry", "Quinoa Bowl", "Vegan Smoothie");
    }
}

class KetoMeal implements MealPlan {

    public String getMealType() {
        return "Keto";
    }

    public List<String> getMeals() {
        return Arrays.asList("Grilled Chicken", "Avocado Salad", "Zucchini Noodles");
    }
}

class Meal<T extends MealPlan> {

    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public void displayMeal() {
        System.out.println("Meal Type: " + plan.getMealType());
        System.out.println("Meals: " + plan.getMeals());
    }

    public T getPlan() {
        return plan;
    }
}

class MealPlanGenerator {

    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        System.out.println("Generating your personalized " + mealPlan.getMealType() + " plan...");
        return new Meal<>(mealPlan);
    }
}

public class P4 {

    public static void main(String[] args) {
        VegetarianMeal veg = new VegetarianMeal();
        KetoMeal keto = new KetoMeal();

        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(veg);
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(keto);

        vegMeal.displayMeal();
        System.out.println();
        ketoMeal.displayMeal();
    }
}
