package Lab_3;

public class Boat {
    private String name;                  // Назва корабля
    private String type;                  // Тип корябля
    private float speed_in_knots;         // Швидкість у міднародних вузлах
    private float width_in_meters;        // Максимальна ширина корабля
    private float length_in_meters;       // Довжина корябля
    private float displacement_in_tonnes; // Водотоннажність корабля

    // Конструктор класу
    public Boat(String name, String type, float speed_in_knots, float width_in_meters, float length_in_meters, float displacement_in_tonnes) {
        this.name = name;
        this.type = type;
        this.speed_in_knots = speed_in_knots;
        this.width_in_meters = width_in_meters;
        this.length_in_meters = length_in_meters;
        this.displacement_in_tonnes = displacement_in_tonnes;
    }

    // Getter імені
    public String get_name() {
        return name;
    }
    // Getter типу корабля
    public String get_type() {
        return type;
    }
    // Getter швидкості
    public float get_speed() {
        return speed_in_knots;
    }
    // Getter ширини
    public float get_width() {
        return width_in_meters;
    }
    // Getter довжини
    public float get_length() {
        return length_in_meters;
    }
    // Getter водотоннажності
    public float get_displacement() {
        return displacement_in_tonnes;
    }

    // Метод для виводу інформації про корабель
    public String to_string() {
        return type + " " + name + ": " + length_in_meters + " meters long and " + width_in_meters +
               " meters wide, displacement = " + displacement_in_tonnes +
               " tonnes, max speed = " + speed_in_knots + " knots";
    }
}
