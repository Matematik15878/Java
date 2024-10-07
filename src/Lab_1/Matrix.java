package Lab_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private final int rows;         // Кількість рядків матриці
    private final int cols;         // Кількість колонок матриці
    private final double[][] data;  // Вміст матриці типу double

    // Конструктор класу
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Setter значення елементу матриці
    public void set(int row, int col, double value) {
        data[row][col] = value;
    }

    // Getter значення елементу матриці
    public double get(int row, int col) {
        return data[row][col];
    }

    // Метод ручного вводу матриці з консолі
    public void fill_matrix_console() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean valid_input = false;

                while (!valid_input) {
                    try {
                        System.out.printf("Enter element [%d][%d] of matrix: ", i, j);
                        double value = scanner.nextDouble();
                        this.set(i, j, value);
                        valid_input = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                        scanner.next();
                    }
                }
            }
        }
    }

    // Метод випадкового заповнення матриці
    public void fill_matrix_randomly(double minValue, double maxValue) {
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double randomValue = minValue + (maxValue - minValue) * random.nextDouble();
                this.set(i, j, randomValue);
            }
        }
    }

    // Метод виводу матриці в консоль
    public void print_matrix() {
        double maxElement = find_max();
        int maxLength = String.format("%.2f", maxElement).length();

        for (int i = 0; i < rows; i++) {
            System.out.print('|');
            for (int j = 0; j < cols; j++) {
                System.out.printf((j != 0 ? ", " : "") + "%" + maxLength + ".2f", this.get(i, j));
            }
            System.out.println("|");
        }
    }

    // Метод для знаходження максимального елементу матриці
    public double find_max() {
        double max_element = this.get(0, 0);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.get(i, j) > max_element) {
                    max_element = this.get(i, j);
                }
            }
        }

        return max_element;
    }

    // Метод множення матриць
    public Matrix multiply_by(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Number of columns in Matrix A must be equal to number of rows in Matrix B");
        }

        Matrix result = new Matrix(this.rows, other.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.set(i, j, sum);
            }
        }

        return result;
    }

    // Метод знаходження суми найбільших елементів рядків
    public double get_sum_of_larges_elements_in_rows() {
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            double max = Double.NEGATIVE_INFINITY;
            for (int j = 0; j < cols; j++) {
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
            sum += max;
        }
        return sum;
    }
}
