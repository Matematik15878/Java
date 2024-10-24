package Lab_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Клас подарунку для дитини з цукерок
public class ChildrensGift {
    private final List<GiftItem> items;    // Список цукерок

    // Конструктор
    public ChildrensGift() {
        items = new ArrayList<>();
    }

    // Метод додавання цукерок
    public void add_candy(Candy candy, int quantity) {
        items.add(new GiftItem(candy, quantity));
    }

    // Метод виведення загальної маси
    public double get_total_weight() {
        double total_weight = 0;
        for (GiftItem item : items) {
            total_weight += item.get_total_weight();
        }
        return total_weight;
    }

    // Виведення вмісту подарунка
    public void show_gift_contents() {
        for (GiftItem item : items) {
            item.print_item_info();
        }
    }

    // Сортування за вмістом шоколаду
    public void sort_by_chocolate_content() {
        items.sort(Comparator.comparing(item -> item.get_candy().get_chocolate_content()));
    }

    // Пошук цукерок за діапазоном вмісту шоколаду
    public List<GiftItem> find_by_chocolate_content(double min, double max) {
        List<GiftItem> result = new ArrayList<>();
        for (GiftItem item : items) {
            double chocolateContent = item.get_candy().get_chocolate_content();
            if (chocolateContent >= min && chocolateContent <= max) {
                result.add(item);
            }
        }
        return result;
    }
}
