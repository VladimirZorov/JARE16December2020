import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(liquids::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).forEach(ingredients::push);

        Map<String, Integer> foodQuantity = new TreeMap<>();
        foodQuantity.put("Bread", 0);
        foodQuantity.put("Cake", 0);
        foodQuantity.put("Pastry", 0);
        foodQuantity.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int tempLiquid = liquids.peek();
            int tempIngredient = ingredients.peek();
            int mixSum = tempLiquid + tempIngredient;
            switch (mixSum) {
                case 25:
                    foodQuantity.compute("Bread", (k, v) -> v + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 50:
                    foodQuantity.compute("Cake", (k, v) -> v + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 75:
                    foodQuantity.compute("Pastry", (k, v) -> v + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 100:
                    foodQuantity.compute("Fruit Pie", (k, v) -> v + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                default:
                    liquids.pop();
                    ingredients.addFirst(ingredients.pop() + 3);
            }
        }

       if (!foodQuantity.containsValue(0)) {
           System.out.println("Wohoo! You succeeded in cooking all the food!");
       } else {
           System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
       }

       if (liquids.isEmpty()) {
           System.out.println("Liquids left: none");
       } else {
           System.out.print("Liquids left: ");
           for (int i = 0; i < liquids.size(); i++) {
               System.out.printf("%d",liquids.poll());
               i--;
               if (liquids.size() != 0) {
                   System.out.print(", ");
               }
           }
           System.out.println();
       }

       if (ingredients.isEmpty()) {
           System.out.println("Ingredients left: none");
       } else {
           System.out.print("Ingredients left: ");
           for (int i = 0; i < ingredients.size(); i++) {
               System.out.printf("%d",ingredients.pop());
               i--;
               if (ingredients.size()!=0) {
                   System.out.print(", ");
               }
           }
           System.out.println();
       }
        foodQuantity.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
