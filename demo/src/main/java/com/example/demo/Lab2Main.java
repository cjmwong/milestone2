package com.example.demo;

import java.util.Scanner;

/**
 * main for lab 2
 * @author Calvin Wong
 */
public class Lab2Main {
    /**
     * main program for lab 2
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.print("CSV filename: ");
        Scanner parser = new Scanner(System.in);
        Pair pair;
        String fName = parser.nextLine();
        pair = LoadData.readCSV(fName);
        Display.printL2AllStats(pair.getList());
        Display.printL2AccNumStats(pair.getMap());
        Display.printL2NeighborhoodStats(pair.getList());
    }
}

