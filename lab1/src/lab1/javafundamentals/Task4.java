package lab1.javafundamentals;

import java.util.Scanner;

public class Task4 {

    public static void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the number of elements in array: ");
        int n = in.nextInt();
        System.out.println("Input the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i])) {
                System.out.println("arr[" + i + "] = " + arr[i]);
            }
        }
        in.close();
    }

    public static boolean isPrime(int number) {
        if (number > 1) {
            double sqrt = Math.sqrt(number);
            for (int i = 2; i <= sqrt; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }
}
