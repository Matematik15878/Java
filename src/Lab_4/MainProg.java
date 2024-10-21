package Lab_4;

import java.util.Scanner;

public class MainProg {
    // Виконуючий метод
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("This program is designed to remove all occurrences of the first letter of each word");

        while (input.isEmpty()) {
            System.out.println("\nEnter the string here:");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("The string cannot be empty!");
            }
        }

        StringBuffer buffer = new StringBuffer(input);
        Text text = new Text(buffer);
        StringBuffer changed_buffer = text.process_text();

        System.out.println("The result is: " + changed_buffer);
    }
}

