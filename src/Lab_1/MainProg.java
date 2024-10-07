package Lab_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProg {
    // Виконуючий метод
    public static void main(String[] args) {
        System.out.println("This program is designed to multiply two matrices of data type double" +
                           "\nand find the sum of the largest elements of each row ");

        int [] dimensions = enter_sizes();

        Matrix a = new Matrix(dimensions[0], dimensions[1]);
        Matrix b = new Matrix(dimensions[2], dimensions[3]);
        Matrix c = null;

        fill_matrix(a, "A");
        fill_matrix(b, "B");

        try {
            c = a.multiply_by(b);
            print_result(a, b, c);

            System.out.println();
            print_sum_of_largest_elements_in_rows(a, "A");
            print_sum_of_largest_elements_in_rows(b, "B");
            print_sum_of_largest_elements_in_rows(c, "C");

            System.out.printf("The total sum of the largest elements of the matrices = %.2f%n",
            a.get_sum_of_larges_elements_in_rows() + b.get_sum_of_larges_elements_in_rows() + c.get_sum_of_larges_elements_in_rows());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод коректного вводу розмірів матриць
    public static int[] enter_sizes() {
        Scanner scanner = new Scanner(System.in);

        boolean valid_input = false;
        boolean valid_input_2;

        int rows_1 = 0, cols_1 = 0, rows_2 = 0, cols_2 = 0;

        while (!valid_input) {
            valid_input = true;
            valid_input_2 = false;

            while (!valid_input_2) {
                try {
                    System.out.println("\nEnter the amount of rows of the matrix A: ");
                    rows_1 = scanner.nextInt();
                    System.out.println("Enter the amount of columns of the matrix A: ");
                    cols_1 = scanner.nextInt();

                    System.out.println("\nEnter the amount of rows of the matrix B: ");
                    rows_2 = scanner.nextInt();
                    System.out.println("Enter the amount of columns of the matrix B: ");
                    cols_2 = scanner.nextInt();

                    valid_input_2 = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please try again and enter a valid number.");
                    scanner.next();
                }
            }

            if (rows_1 <= 0 || cols_1 <= 0 || rows_2 <= 0 || cols_2 <= 0) {
                System.out.println("Dimensions of the matrices must be positive. Try again");
                valid_input = false;
                continue;
            }

            if (cols_1 != rows_2) {
                System.out.println("Number of columns of the matrix A must be equal to the number of rows of the matrix B. Try again");
                valid_input = false;
            }
        }

        return new int[]{rows_1, cols_1, rows_2, cols_2};
    }

    // Метод ручного або випадкового заповнення матриці
    public static void fill_matrix(Matrix matrix, String matrix_name) {
        Scanner scanner = new Scanner(System.in);
        boolean valid_input = false;

        while (!valid_input) {
            System.out.println("\nHow would you like to fill matrix " + matrix_name + "?");
            System.out.println("1 - Manually");
            System.out.println("2 - Randomly");

            try {
                int choice = scanner.nextInt();

                if (choice == 1) {
                    matrix.fill_matrix_console();
                    valid_input = true;
                } else if (choice == 2) {
                    System.out.println("Enter the minimum value for random numbers:");
                    double minValue = scanner.nextDouble();
                    System.out.println("Enter the maximum value for random numbers:");
                    double maxValue = scanner.nextDouble();
                    matrix.fill_matrix_randomly(minValue, maxValue);
                    valid_input = true;
                } else {
                    System.out.println("Invalid choice! Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }
    }

    // Метод виводу результату множення матриць
    public static void print_result(Matrix a, Matrix b, Matrix c) {
        if (c != null) {
            System.out.println();
            a.print_matrix();
            System.out.println("\n*\n");
            b.print_matrix();
            System.out.println("\n=\n");
            c.print_matrix();
        }
    }

    // Метод виводу суми найбільших елементів кожного рядка
    public static void print_sum_of_largest_elements_in_rows(Matrix m, String matrix_name) {
        double sum = m.get_sum_of_larges_elements_in_rows();
        System.out.printf("Sum of the largest elements of the matrix %s rows = %.2f%n", matrix_name, sum);
    }
}
