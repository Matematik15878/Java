package Lab_5;

// Клас шоколадної цукерки
public class ChocolateCandy extends Candy {
    private final String chocolate_type;     // Тип шоколаду

    // Конструктор
    public ChocolateCandy(String name, double weight, int sugar_content, int chocolate_content, double calories, String chocolate_type) {
        super(name, weight, calories, sugar_content, chocolate_content);
        this.chocolate_type = chocolate_type;
    }

    // Геттер
    public String get_chocolate_type() {
        return chocolate_type;
    }

    // Метод виведення інформації про цукерку
    @Override
    public void print_info() {
        System.out.println("Chocolate: " + get_name() + " | Type of chocolate: " + chocolate_type + " | Weight: " +
                get_weight() + " g | Sugar: " + get_sugar_content() + "% | Chocolate: " +
                get_chocolate_content() + "% | Calories: " + get_calories() + " kcal");
    }
}
