package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {
//         Write a program that reads a set of floating-point values. Ask the user to enter the values, then print:
//         * the average of the values.
//         * the smallest of the values.
//         * the largest
//         * the range, that is the difference between the smallest and largest
        double total = 0;
        int count = 0;
        double average = 0;
        double smallest = -1;
        double largest = -1;
        double range = 0;

        System.out.println("Please enter decimal numbers. Enter 'end' when finished.");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            smallest = number;
            largest = number;
            total += number;
            count++;
            average = total / count;
        }

        while (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            if (number < smallest)
                smallest = number;
            if (number > largest)
                largest = number;
            range = largest - smallest;
            total += number;
            count++;
            average = total / count;
        }
        System.out.println("* average: " + average);
        System.out.println("* smallest: " + smallest);
        System.out.println("* largest: " + largest);
        System.out.println("* range: " + range);
    }
}
