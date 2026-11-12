import java.util.*;
m main

class odd {
    public static void main(String[] args) {
        System.out.println("enter elements of array");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int a[] = new int[x];
        System.out.println("enter each element" + x);
        for (int i = 0; i < x; i++) {
            a[i] = sc.nextInt();
        }
        for (int i : a) {
            if (i % 2 == 0)
                System.out.println("even number=" + i);
            e
