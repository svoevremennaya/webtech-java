package lab1.javafundamentals;

import java.util.Scanner;

public class Task6 {

    public static void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the number of elements in array: ");
        int n = in.nextInt();
        System.out.println("Input the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[][] matrix = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            k = i;
            for (int j = 0; j < n; j++, k++) {
                if (k >= n) {
                    k = 0;
                }
                matrix[i][j] = arr[k];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
