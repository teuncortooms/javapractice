package com.company;

import java.util.Scanner;

public class Analyser {

    private double total;
    private int count;
    private double average;
    private double smallest;
    private double largest;
    private double range;

    public Analyser() {
    }

    public void Run() {
        System.out.println("Please enter decimal numbers. Enter 'end' when finished.");
        handleInput();
        printData();
    }

    private void handleInput() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            initDataWithFirstValue(scanner.nextDouble());
        }
        while (scanner.hasNextDouble()) {
            updateDataWithNextValue(scanner.nextDouble());
        }
    }

    private void initDataWithFirstValue(double number) {
        smallest = number;
        largest = number;
        total += number;
        count++;
        average = total / count;
    }

    private void updateDataWithNextValue(double number) {
        if (number < smallest)
            smallest = number;
        if (number > largest)
            largest = number;
        range = largest - smallest;
        total += number;
        count++;
        average = total / count;
    }

    private void printData() {
        System.out.println("* average: " + average);
        System.out.println("* smallest: " + smallest);
        System.out.println("* largest: " + largest);
        System.out.println("* range: " + range);
    }
}
