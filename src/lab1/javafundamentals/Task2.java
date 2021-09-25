package lab1.javafundamentals;

import java.util.Scanner;

public class Task2 {

    public static void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input x: ");
        double x = in.nextDouble();
        System.out.print("Input y: ");
        double y = in.nextDouble();

        if (((y >= 0) & (y <= 5) & (x >= -4) & (x <= 4)) | ((y >= -3) & (y <= 0) & (x >= -6) & (x <= 6))) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        in.close();
    }
}
