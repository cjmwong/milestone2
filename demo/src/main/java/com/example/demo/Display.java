package com.example.demo;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Display class to information about the property
 * @author Calvin Wong
 */
public class Display {
    /**
     * displays required information of lab 2 main
     * @param properties array list of PropertyAssessment objects sorted by assessment value
     */
    public static void printL2AllStats(List<PropertyAssessment> properties) {
        System.out.println("Descriptive statistics of all property assessments");
        printStats(properties);
    }

    /**
     * displays information and statistics of the property that was searched
     * @param properties hashmap of PropertyAssessment objects
     */
    public static void printL2AccNumStats(Map<String, PropertyAssessment> properties) {
        System.out.print("Find a property assessment by account number: ");
        Scanner parser = new Scanner(System.in);
        String accNum = parser.nextLine();
        PropertyAssessment p = CsvPropertyAssessmentDAO.getByAccountNumber(accNum, properties);
        //return if account does not exist
        if (p == null) {
            System.out.println("Error: invalid account number...\nSorry, account number not found\n");
            return;
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance(); //format to print in dollars
        formatter.setMaximumFractionDigits(0);
        System.out.println("Account Number = " + p.getAccNum());
        System.out.println("Address = " + p.getHouseNumber() + " " + p.getStreetName());
        System.out.println("Assessed value = " + formatter.format(p.getAssessment().getValue()));
        System.out.println("Assessment Class = [" + getAssessmentClasses(p) + "]");
        System.out.println("Neighborhood = " + p.getNInfo().getNeighborhood() + " (" + p.getNInfo().getWard() + ")");
        System.out.println("Location = (" + p.getCoordInfo().getLatitude() + " " + p.getCoordInfo().getLongitude() + ")\n");
    }

    /**
     * Creates an assessment class string to print in the correct format
     * @param p PropertyAssessment object that was searched for
     * @return string of the properties assessment classes in the correct format
     */
    private static String getAssessmentClasses(PropertyAssessment p) {
        String aClass = p.getAssessment().getClass1() + " " + p.getAssessment().getClassPercent1() + "%";
        if (p.getAssessment().getClass2().length() != 0) {
            aClass += ", " + p.getAssessment().getClass2() + " " + p.getAssessment().getClassPercent2() + "%";

            if (p.getAssessment().getClass3().length() != 0) {
                aClass += ", " + p.getAssessment().getClass3() + " " + p.getAssessment().getClassPercent3() + "%";
            }
        }
        return aClass;
    }

    /**
     * displays information and statistics of all properties in a specific neighborhood
     * @param properties array list of PropertyAssessment objects sorted by assessment value
     */
    public static void printL2NeighborhoodStats(List<PropertyAssessment> properties){
        System.out.print("Neighborhood: ");
        Scanner parser = new Scanner(System.in);
        String neighborhood= parser.nextLine();
        List<PropertyAssessment> propertyList = CsvPropertyAssessmentDAO.getByNeighborhood(neighborhood.toUpperCase(), properties);
        if (propertyList == null) {
            System.out.println("Data not found\n");
            return;
        }
        System.out.println("Statistics (neighbourhood = " + neighborhood + ")");
        printStats(propertyList);
    }
    /**
     * displays information and statistics of all properties in a specific assessment class
     * @param properties array list of PropertyAssessment objects sorted by assessment value
     */
    public static void printL3AssessmentStats(List<PropertyAssessment> properties){
        System.out.print("Assessment class: ");
        Scanner parser = new Scanner(System.in);
        String assessment = parser.nextLine();
        List<PropertyAssessment> propertyList = CsvPropertyAssessmentDAO.getByAssessment(assessment.toUpperCase(), properties);
        if (propertyList == null) {
            System.out.println("Data not found\n");
            return;
        }
        System.out.println("Statistics (assessment class = " + assessment + ")");
        printStats(propertyList);
    }
    /**
     * displays information and statistics of all properties in a specific neighborhood
     * @param properties array list of PropertyAssessment objects sorted by assessment value
     */
    public static void printStats(List<PropertyAssessment> properties) {
        BigDecimal[] minAndMaxValue = Stats.getMinAndMaxValue(properties);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMaximumFractionDigits(0);
        System.out.println("n = " + properties.size());
        System.out.println("min = " + formatter.format(minAndMaxValue[0]));
        System.out.println("max = " + formatter.format(minAndMaxValue[1]));
        System.out.println("range = " + formatter.format(minAndMaxValue[1].subtract(minAndMaxValue[0])));
        System.out.println("mean = " + formatter.format(Stats.mean(properties)));
        System.out.println("median = " + formatter.format(Stats.median(properties)) + "\n");
    }
}
