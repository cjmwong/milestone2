package com.example.demo;

import java.util.Scanner;

/**
 * main for lab 3
 * @author Calvin Wong
 */
public class Lab3Main {
    /**
     * main program for lab 3
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.print("CSV filename: ");
        Scanner parser = new Scanner(System.in);
        Pair pair;
        String fName = parser.nextLine();
        pair = LoadData.readCSV(fName);
        Display.printL3AssessmentStats(pair.getList());
    }
}

