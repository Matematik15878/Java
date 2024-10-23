package Lab_5;

// Елемент подарунку
class GiftItem {
    private final Candy candy;          // цукерка
    private final int quantity;         // кількість

    // Конструктор
    public GiftItem(Candy candy, int quantity) {
        this.candy = candy;
        this.quantity = quantity;
    }

    // Геттери
    public Candy get_candy() {
        return candy;
    }
    public int get_quantity() {
        return quantity;
    }

    // Метод знаходження загальної маси
    public double get_total_weight() {
        return candy.get_weight() * quantity;
    }

    // Метод виводу інформації
    public void print_item_info() {
        System.out.print("(Amount = " + quantity + ") ");
        candy.print_info();
    }
}