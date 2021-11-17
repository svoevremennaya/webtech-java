package lab1.javafundamentals;

import java.util.Scanner;

public class Task3 {

    public static void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a: ");
        double a = in.nextDouble();
        System.out.print("Input b: ");
        double b = in.nextDouble();
        System.out.print("Input h: ");
        double h = in.nextDouble();

        double x = a;
        double f;

        String leftAlignFormat = "| %-4f | %-14f |%n";
        System.out.format("+----------+----------------+%n");
        System.out.format("|     x    |      f(x)      |%n");
        System.out.format("+----------+----------------+%n");

        while (x <= b) {
            f = Math.tan(x);
            System.out.format(leftAlignFormat, x, f);
            x += h;
        }
        System.out.format("+----------+----------------+%n");
        in.close();
    }
}
