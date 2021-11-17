package lab1.javafundamentals;

import java.util.Scanner;

public class Task7 {

    public static void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the number of elements in array: ");
        int n = in.nextInt();
        System.out.println("Input the array:");
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextDouble();
        }

        int i = 0;
        while (i < n - 1) {
            if (arr[i] <= arr[i + 1]) {
                i++;
            }
            else {
                double temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                if (i <= 0) {
                    i = 0;
                }
                else {
                    i--;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            System.out.print(arr[j]);
        }
        in.close();
    }
}
