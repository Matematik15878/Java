package Lab_5;

// Клас фруктової цукерки
public class FruitCandy extends Candy {
    private final String flavor;    // Смак цукерки

    // Конструктор на випадок цукерки без шоколаду
    public FruitCandy(String name, double weight, int sugar_content, int calories, String flavor) {
        super(name, weight, calories, sugar_content, 0);
        this.flavor = flavor;
    }

    // Конструктор на випадок цукерки з шоколадом
    public FruitCandy(String name, double weight, int sugar_content, int chocolate_content, double calories, String flavor) {
        super(name, weight, calories, sugar_content, chocolate_content);
        this.flavor = flavor;
    }

    // Геттер
    public String get_flavor() {
        return flavor;
    }

    // Метод виведення інформації про цукерку
    @Override
    public void print_info() {
        System.out.println("Chocolate candy: " + get_name() + " | Flavor: " + flavor + " | Weight: " + get_weight() + " g | Sugar: " +
                get_sugar_content() + "% | Chocolate: " + get_chocolate_content() + "% | Calories: " +
                get_calories() + " kcal");
    }
}
