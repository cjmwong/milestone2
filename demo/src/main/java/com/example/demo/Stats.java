package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Stats class to calculate max, min, mean, and median values for a group of properties
 * @author Calvin Wong
 */
public class Stats {
    /**
     * gets the minimum and maximum values for a set of PropertyAssessment objects
     * @param properties arraylist of sorted PropertyAssessment objects sorted by assessment value
     * @return array of the lowest and the highest cost PropertyAssessment object
     */
    public static BigDecimal[] getMinAndMaxValue(List<PropertyAssessment> properties){
        //Array list sorted by assessed value passed in
        return new BigDecimal[]{properties.get(0).getAssessment().getValue(), properties.get(properties.size()-1).getAssessment().getValue()};
    }

    /**
     * Calculates the mean of a group of PropertyAssessment objects
     * @param properties arraylist of sorted PropertyAssessment objects sorted by assessment value
     * @return the mean of the group of PropertyAssessment objects
     */
    public static BigDecimal mean(List<PropertyAssessment> properties) {
        int i;
        BigDecimal sum = new BigDecimal(0);
        for (i = 0; i < properties.size(); i++) {
            sum = sum.add(properties.get(i).getAssessment().getValue());
        }
        BigDecimal divisor = new BigDecimal(properties.size());
        return sum.divide(divisor, 0, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the median of a group of PropertyAssessment objects
     * @param properties arraylist of sorted PropertyAssessment objects sorted by assessment value
     * @return the median of the group of PropertyAssessment objects
     */
    public static BigDecimal median(List<PropertyAssessment> properties){
        if (properties.size() % 2 == 0) {
            int mid1 = (properties.size() / 2) - 1;
            int mid2 = mid1 + 1;
            BigDecimal two = new BigDecimal(2);
            return properties.get(mid1).getAssessment().getValue().add(properties.get(mid2).getAssessment().getValue()).divide(two, RoundingMode.HALF_UP);
            }
        int mid1 = (properties.size() / 2);
        return properties.get(mid1).getAssessment().getValue();
        }
}

