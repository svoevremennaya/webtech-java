package lab1.javafundamentals;

import java.util.Scanner;

public class Task5 {

    public static void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the number of elements in array: ");
        int n = in.nextInt();
        System.out.println("Input the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[i] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[j] > arr[i]) {
                    if (counts[j] <= counts[i]) {
                        counts[j] = counts[i] + 1;
                    }
                }
            }
        }

        int max = counts[0];
        for (int i = 1; i < n; i++) {
            if (counts[i] > max) {
                max = counts[i];
            }
        }

        int k = n - max;
        System.out.print(k);
        in.close();
    }
}
