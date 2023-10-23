package com.example.demo;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 * ReadFile class reads a property csv file and builds PropertyAssessment objects from the read file
 * @author Calvin Wong
 */
public class LoadData {
    /**
     * Reads a property assessment csv file and stores information in a data structure
     * @param fName the name of the file to read
     * @return a pair of data structures: sorted array list, and hashmap
     */
    public static Pair readCSV(String fName) {
        PropertyAssessment p;
        Map<String, PropertyAssessment> properties = new HashMap<>();
        List<PropertyAssessment> sortedList = new ArrayList<>();
        Pair pair;
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "\\" + "src" + "\\" + fName));
            String line;
            String[] propertyInfo;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                propertyInfo = line.split(",", -1);
                p = buildProperty(propertyInfo);
                sortedList.add(p);
            }
            Collections.sort(sortedList);
            pair = new Pair(sortedList, properties);
            int i;
            for (i = 0; i < sortedList.size(); i++) {
                properties.put(sortedList.get(i).getAccNum(), sortedList.get(i));
            }
            return pair;
        } catch (IOException ex) {
            System.out.println(("Error: can't open file " + fName));
            System.exit(-1);
        }
        return new Pair(sortedList, properties);
    }

    /**
     * Builds a PropertyAssessment object from an array of string
     * @param propertyInfo array of strings containing information of the property ([Account Number, Suite, House Number,
     *                     Street Name, Garage, Neighbourhood ID, Neighbourhood, Ward, Assessed Value, Latitude, Longitude,
     *                     Point Location, Assessment Class % 1, Assessment Class % 2, Assessment Class % 3, Assessment Class 1, Assessment Class 2, Assessment Class 3])
     * @return PropertyAssessment object of a single property
     */
    public static PropertyAssessment buildProperty(String[] propertyInfo) {
        BigDecimal aValue = new BigDecimal(propertyInfo[8]);
        BigDecimal lat = new BigDecimal(propertyInfo[9]);
        BigDecimal longitude = new BigDecimal(propertyInfo[10]);
        Neighborhood n = new Neighborhood(propertyInfo[5], propertyInfo[6], propertyInfo[7]);
        Coordinates c = new Coordinates(lat, longitude);
        Assessment a = new Assessment(aValue, propertyInfo[12], propertyInfo[13], propertyInfo[14], propertyInfo[15], propertyInfo[16], propertyInfo[17]);
        if (propertyInfo[4].equals("Y")) {
            return new PropertyAssessment(propertyInfo[0], propertyInfo[1], propertyInfo[2], propertyInfo[3], true, n, c, a);
        }
        return new PropertyAssessment(propertyInfo[0], propertyInfo[1], propertyInfo[2], propertyInfo[3], false, n, c, a);
    }
}


