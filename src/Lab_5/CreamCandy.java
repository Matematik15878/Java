package Lab_5;

// Клас кремової цукерки
public class CreamCandy extends  Candy{
    private final String cream_type;     // Тип крему

    // Конструктор
    public CreamCandy(String name, double weight, int sugar_content, int chocolate_content, double calories, String cream_type) {
        super(name, weight, calories, sugar_content, chocolate_content);
        this.cream_type = cream_type;
    }

    // Геттер
    public String get_cream_type() {
        return cream_type;
    }

    // Метод виведення інформації про цукерку
    @Override
    public void print_info() {
        System.out.println("Cream Candy: " + get_name() + " | Cream: " + cream_type + " | Weight: " +
                get_weight() + " g | Sugar: " + get_sugar_content() + "% | Chocolate: " +
                get_chocolate_content() + "% | Calories: " + get_calories() + " kcal");
    }
}
