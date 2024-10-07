package Lab_2;

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
        StringBuffer changed_buffer = remove_first_char_occurrences(buffer);

        System.out.println("The result is: " + changed_buffer);
    }

    // Метод для видалення в кожному слові всіх входжень його першої букви
    public static StringBuffer remove_first_char_occurrences(StringBuffer original_buffer) {
        original_buffer.append(' '); // Для правильної обробки останнього слова
        StringBuffer result = new StringBuffer(); // Результат маніпуляцій
        StringBuffer word = new StringBuffer(); // Тимчасове сховище для слова

        // Цикл обробляє кожен символ строки
        for (int i = 0; i < original_buffer.length(); i++) {
            // Зчитування символу
            char current_char = original_buffer.charAt(i);
            // Якщо пробіл, обробляємо слово
            if (Character.isWhitespace(current_char)) {
                if (!word.isEmpty()) {
                    // Видаляємо всі входження першої букви (без урахування регістру)
                    char first_char = word.charAt(0);
                    for (int j = 0; j < word.length(); j++) {
                        if (Character.toLowerCase(word.charAt(j)) != Character.toLowerCase(first_char)) {
                            result.append(word.charAt(j));
                        }
                    }
                    // Обнуляємо тимчасове сховище
                    word.setLength(0);
                }
                result.append(current_char);
            } else {
                word.append(current_char); // Якщо не пробіл - додаємо букву в кінець слова
            }
        }
        // Видаляємо пробіл з оригінальної строки
        original_buffer.setLength(original_buffer.length() - 1);
        // Повертаємо результат
        return result;
    }
}