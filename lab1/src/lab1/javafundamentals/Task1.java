package lab1.javafundamentals;

import java.util.Scanner;

public class Task1 {

    public static void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Task 1");
        System.out.print("Input x: ");
        double x = in.nextDouble();
        System.out.print("Input y: ");
        double y = in.nextDouble();

        double num = 1 + Math.pow(Math.sin(x + y), 2);
        double denum = 2 + Math.abs(x - (2 * x) / (1 + Math.pow(x, 2) * Math.pow(y, 2)));
        double value = num / denum + x;
        System.out.println("The result is " + value);
        in.close();
    }
}
