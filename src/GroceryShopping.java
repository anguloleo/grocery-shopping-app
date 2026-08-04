import java.util.InputMismatchException;
import java.util.Scanner;

public class GroceryShopping {

    //Method: Check if item in stock
    public static void checkStock(String[] itemsArray, String itemName) {
        boolean found = false;
        for (String item : itemsArray) {
            if (itemName.equalsIgnoreCase(item)) {
                found = true;
            }
        }
        if(found){
            System.out.println("We have " + itemName + " in stock!\n");
        }else{
            System.out.println("We don't have " + itemName + " in stock!\n");
        }
    }
    //Method: Discount
    public static void discountTotal(float totalBill){
        System.out.println("Congratulations, you get 10% off your purchase today!");
        totalBill -= (.10f * totalBill);
        System.out.printf("Your new total with discount applied is: $%.2f%n%n", totalBill);
    }
    //Method: Average Price
    public static void averagePrice(float[] priceArray) {
        float sumAllPrices = 0f;
        for (float groceryPrice : priceArray) {
            sumAllPrices += groceryPrice;
        }
        System.out.printf("The average price of all items is: $%.2f%n", (sumAllPrices/priceArray.length));
    }
    //Method: List items below a price
    public static void listItemsBelowPrice(String[] itemArr, float[] priceArr, float maxPrice){
        for(int i = 0; i < priceArr.length; i++) {
            if(priceArr[i] <= maxPrice) {
                System.out.printf("%s: $%.2f%n", itemArr[i], priceArr[i]);
            }
        }
    }

    //Method: Get item price
    public static float getPrice(String[] groceryItems, float[] groceryPrices, String itemName) {
        float itemPrice;
        for (int i = 0; i < groceryItems.length; i++) {
            if (itemName.equalsIgnoreCase(groceryItems[i])) {
                System.out.printf("%s: $%.2f%n", groceryItems[i], groceryPrices[i]);
                return groceryPrices[i];
            }
        }
        return -1;
    }


    //MAIN METHOD
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Arrays
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


        //Menu
        while (true) {

                System.out.println("Hello and welcome to the Grocery Shopping App");
                System.out.println("Please select from the following options:");
                System.out.println(
                                "1. Check if item in stock\n" +
                                "2. Shop for items\n" +
                                "3. Calculate average price of items\n" +
                                "4. Filter items below a price\n" +
                                "Enter \"exit\" when ready to exit app.");
                String userInput = scanner.nextLine();


                switch (userInput) {
                    case "1":
                            System.out.print("What item would you like to check?");
                            String stockItemName = scanner.nextLine();
                            checkStock(groceryItems, stockItemName);
                            break;
                    case "2":
                        float totalBill = 0f;
                        while (true) {
                            System.out.print("What items would you like to add to your cart?\n" +
                                    "(Type \"complete\" when done adding items.) ");
                            String itemName = scanner.nextLine();

                            if (itemName.equalsIgnoreCase("complete")) {
                                System.out.println("Finished adding items\n");
                                discountTotal(totalBill);
                                break;
                            }

                            float itemPrice = getPrice(groceryItems, groceryPrices, itemName);
                            if(itemPrice == -1){
                                System.out.println("We don't have " + itemName + " in stock!\n");
                                continue;
                            }

                            int quantity;
                            while(true){
                                try {
                                    System.out.println("How many would you like? ");
                                    quantity = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Please enter a number!");
                                }
                            }

                            totalBill += itemPrice * quantity;
                            System.out.printf("You're new total is: $%.2f%n%n", totalBill);

                        }
                        break;
                    case "3":
                        averagePrice(groceryPrices);
                        System.out.println();
                        break;
                    case "4":
                        try {
                            System.out.print("Enter maximum price you'd like to see items for: ");
                            float maxPrice = Float.parseFloat(scanner.nextLine());
                            listItemsBelowPrice(groceryItems, groceryPrices, maxPrice);
                            System.out.println();
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a number!");
                        }
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 1, 2, 3, 4, or exit.");
                }

                if (userInput.equalsIgnoreCase("exit")) {   //exit app
                    System.out.println("Thank you for using the shopping cart. Goodbye!");
                    break;
                }
            }

    }
}