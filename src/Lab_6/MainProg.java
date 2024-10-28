package Lab_6;

import java.util.Comparator;

public class MainProg {
    public static void main(String[] args) {
        // Створення та заповнення списку конфет
        CandyList candy_list = new CandyList(new Candy("C3", 43.9, 230.5, 35, 15));
        candy_list.add(new Candy("C4", 99.9, 245.0, 30, 20));
        candy_list.add(new Candy("C5", 15.0, 280.0, 25, 18));
        candy_list.add(0, new Candy("C1", 12.4, 250.0, 28, 22));
        candy_list.add(1, new Candy("C2", 90.3, 210.0, 26, 19));

        // Виведення початкового списку конфет
        System.out.println("\nПочатковий список цукерок:");
        candy_list.forEach(Candy::print_info);

        // Сортування конфет за калоріями
        candy_list.sort(Comparator.comparingDouble(Candy::get_calories));
        System.out.println("\nСортування списку за калорійністю");
        candy_list.forEach(Candy::print_info);

        // Фільтрація списку за мінімальним вмістом цукру 30%
        CandyList filtered_list = new CandyList();
        candy_list.stream().filter(candy -> candy.get_sugar_content() >= 30).forEach(filtered_list::add);
        System.out.println("\nФільтрований список (цукерки, що містять більше 30% цукру):");
        filtered_list.forEach(Candy::print_info);

        // Видалення одного об'єкту
        System.out.println("\nКількість цукерок до видалення: " + candy_list.size());
        Candy delete_candy = new Candy("C1", 12.4, 250.0, 28, 22);
        candy_list.remove(delete_candy);
        System.out.println("\nСписок цукерок після видалення С1:");
        candy_list.forEach(Candy::print_info);

        // Розширення списку
        CandyList moreCandies = new CandyList();
        moreCandies.add(new Candy("A1", 13.0, 250.0, 89, 22));
        moreCandies.add(new Candy("A2", 96.6, 210.0, 26, 56));
        candy_list.addAll(2, moreCandies);
        System.out.println("\nРозширений список цукерок:");
        candy_list.forEach(Candy::print_info);
        System.out.println("\nКількість цукерок після розширення: " + candy_list.size());

        // Очистка списку
        candy_list.clear();
        System.out.println("\nКількість цукерок після очистки списку: " + candy_list.size());
    }
}
