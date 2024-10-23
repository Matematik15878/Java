package Lab_5;

// Клас цукерки
class Candy {
    private final String name;               // назва цукерки
    private final double weight;             // вага 1 цукерки
    private final double calories;           // кількість калорій в 1 цукерці
    private final int sugar_content;         // вміст цукру в цукерці
    private final int chocolate_content;     // вміст шоколаду в цукерці

    // Конструктор
    public Candy(String name, double weight, double calories, int sugar_content, int chocolate_content) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.sugar_content = sugar_content;
        this.chocolate_content = chocolate_content;
    }

    // Геттери
    public String get_name() {
        return name;
    }
    public double get_weight() {
        return weight;
    }
    public double get_calories() {
        return calories;
    }
    public int get_sugar_content() {
        return sugar_content;
    }
    public int get_chocolate_content() {
        return chocolate_content;
    }

    // Метод виведення інформації про цукерку
    public void print_info() {
        System.out.println("Candy information: " + name + " | Weight: " + weight + " g | Sugar: " +
                sugar_content + "% | Chocolate: " + chocolate_content + "% | Calories: " + calories + " kcal");
    }
}
