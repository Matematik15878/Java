package Lab_3;

import java.util.Arrays;
import java.util.Comparator;

public class MainProg {
    // Основний метод
    public static void main(String[] args) {
        Boat[] boats = new Boat[5];

        boats[0] = new Boat("Boat 1", "Destroyer", 21.0f, 28.0f, 300.0f, 52310.0f);
        boats[1] = new Boat("Boat 2", "Destroyer", 25.1f, 12.0f, 100.0f, 1400.0f);
        boats[2] = new Boat("Boat 3", "Destroyer", 23.5f, 8.0f, 300.0f, 900.9f);
        boats[3] = new Boat("Boat 4", "Destroyer", 21.0f, 28.0f, 300.0f, 52121.4f);
        boats[4] = new Boat("Boat 5", "Destroyer", 25.1f, 12.0f, 150.0f, 14623.3f);

        // Виведення оригінального масиву
        System.out.println("\nOriginal array:");
        for (Boat boat : boats) {
            System.out.println(boat.to_string());
        }

        // Виведення відсортованого за 1 полем масиву
        Arrays.sort(boats, Comparator.comparing(Boat::get_length));
        System.out.println("\nArray sorted by ship length (asc):");
        for (Boat boat : boats) {
            System.out.println(boat.to_string());
        }

        // Виведення відсортованого за 2 полями масиву
        Arrays.sort(boats, Comparator.comparing(Boat::get_length).thenComparing(Boat::get_displacement, Comparator.reverseOrder()));
        System.out.println("\nArray sorted by ship length (asc) and displacement (desc):");
        for (Boat boat : boats) {
            System.out.println(boat.to_string());
        }
    }
}
