package Lab_5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainProg {

    // Виконуючий метод
    public static void main(String[] args) {
        System.out.println("The program is designed to create candies, add them to a gift for children, \n" +
                "sort the gift by the weight of the candy and output candies containing a certain amount of chocolate");

        ChocolateCandy c_candy_1 = new ChocolateCandy("Shokolpki", 8.4, 15, 80, 9.5, "milk");
        ChocolateCandy c_candy_2 = new ChocolateCandy("Karakum", 14.1, 15, 70, 24, "white");
        FruitCandy f_candy_1 = new FruitCandy("Candy Bob", 40, 8, 40, "berry");
        FruitCandy f_candy_2 = new FruitCandy("Fruit Cocktail", 120, 45, 30, 120, "fruity");
        CreamCandy cr_candy_1 = new CreamCandy("Sharm", 10, 20, 50, 12, "creamy");

        ChildrensGift gift = new ChildrensGift();
        gift.add_candy(c_candy_1, 40);
        gift.add_candy(c_candy_2, 10);
        gift.add_candy(f_candy_1, 2);
        gift.add_candy(f_candy_2, 15);
        gift.add_candy(cr_candy_1, 3);

        System.out.println("\nOriginal list of candies:");
        gift.show_gift_contents();

        System.out.println("\nSorted by weight of candy list:");
        gift.sort_by_chocolate_content();
        gift.show_gift_contents();

        System.out.println("\nTotal weight of gift = " + gift.get_total_weight());

        System.out.println("\nTo display candies whose chocolate content falls within a range, enter the range.");
        int [] range = enter_chocolate_content();
        List<GiftItem> result_items = gift.find_by_chocolate_content(range[0], range[1]);
        for (GiftItem item : result_items) {
            item.print_item_info();
        }

    }

    // Метод коректного вводу границь вмісту шоколаду
    public static int[] enter_chocolate_content() {
        Scanner scanner = new Scanner(System.in);

        boolean valid_input = false;

        int min = 0, max = 0;

        while (!valid_input) {
            valid_input = true;

            try {
                System.out.println("Enter the minimum of chocolate content: ");
                min = scanner.nextInt();
                System.out.println("Enter the maximum of chocolate content: ");
                max = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again and enter a valid number.\n");
                valid_input = false;
                scanner.next();
            }

            if (min > 100 || max > 100 || min < 0 || max < 0) {
                System.out.println("Chocolate content cannot be more than 100 or less than 0. Try again! \n");
                valid_input = false;
            }
        }

        return new int[]{min, max};
    }
}
