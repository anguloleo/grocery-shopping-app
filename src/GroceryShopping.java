import java.util.Scanner;

public class GroceryShopping {

    public static void main(String[] args){

        String[] groceryItems = new String[15];
        float[] groceryPrices = new float[15];

        groceryItems[0] = "Apple";
        groceryItems[1] = "Orange";
        groceryItems[2] = "Banana";
        groceryItems[3] = "Milk";
        groceryItems[4] = "Yogurt";
        groceryItems[5] = "Grapes";
        groceryItems[6] = "Bread";
        groceryItems[7] = "Peanut butter";
        groceryItems[8] = "Jelly";
        groceryItems[9] = "Lettuce";
        groceryItems[10] = "Apricot";
        groceryItems[11] = "Avocado";
        groceryItems[12] = "Soda";
        groceryItems[13] = "Chips";
        groceryItems[14] = "Watermelon";

        groceryPrices[0] = .50f;
        groceryPrices[1] = .80f;
        groceryPrices[2] = .20f;
        groceryPrices[3] = 3.99f;
        groceryPrices[4] = .99f;
        groceryPrices[5] = 3.48f;
        groceryPrices[6] = 2.88f;
        groceryPrices[7] = 4.59f;
        groceryPrices[8] = 3.75f;
        groceryPrices[9] = 2.14f;
        groceryPrices[10] = .98f;
        groceryPrices[11] = 1.50f;
        groceryPrices[12] = 1.98f;
        groceryPrices[13] = 2.78f;
        groceryPrices[14] = 6.99f;

        Scanner scanner = new Scanner(System.in);

        while(true){

            String userInput = scanner.nextLine();

            if(userInput.equalsIgnoreCase("exit")){
                System.out.println("Thank you for using the shopping cart. Goodbye!");
                break;
            }





        }

    }
}