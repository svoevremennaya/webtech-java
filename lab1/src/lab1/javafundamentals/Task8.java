package lab1.javafundamentals;

import java.util.Scanner;

public class Task8 {

    public static void execute() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the number of elements in sequence a: ");
        int n = in.nextInt();
        System.out.println("Input the sequence a:");
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextDouble();
        }

        System.out.print("Input the number of elements in sequence b: ");
        int m = in.nextInt();
        System.out.println("Input the sequence b:");
        double[] b = new double[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextDouble();
        }

        int j = 0, i = 0;
        while ((i < n) && (j < m)) {
            if (b[j] <= a[i]) {
                System.out.println("b[" + j + "] a[" + i + "]");
                j++;
            }
            i++;
        }

        if (j != m) {
            if (a[n - 1] < b[j]) {
                System.out.println("a[" + (n - 1) + "] b[" + j + "]");
            }
        }

        in.close();
    }
}
