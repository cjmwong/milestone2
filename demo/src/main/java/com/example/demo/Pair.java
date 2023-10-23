package com.example.demo;

import java.util.*;

/**
 * Pair class to hold a linked hashmap of all properties and a sorted array list of all properties
 * @author Calvin Wong
 */
public class Pair {
    private List<PropertyAssessment> list;
    private Map<String, PropertyAssessment> map;

    /**
     * Constructor of the pair class
     * @param property sorted array list of all properties, sorted by assessment value
     * @param propertyMap linked hashmap
     */
    public Pair(List<PropertyAssessment> property, Map<String, PropertyAssessment> propertyMap) {
        this.list = property;
        this.map = propertyMap;
        }

    /**
     * Gets the sorted array list containing all properties
     * @return sorted array list of all properties
     */
    public List<PropertyAssessment> getList() {
        return list;
    }

    /**
     * Sets a new list as the sorted array list of all properties
     * @param list new sorted array list containing all properties
     */
    public void setList(ArrayList<PropertyAssessment> list) {
        this.list = list;
    }
    /**
     * Gets the hashmap containing all properties
     * @return sorted hashmap of all properties
     */
    public Map<String, PropertyAssessment> getMap() {
        return map;
    }
    /**
     * Sets a new map as the hashmap of all properties
     * @param map new sorted map containing all properties
     */
    public void setMap(Map<String, PropertyAssessment> map) {
        this.map = map;
    }

    /**
     * String representation of the Pair class
     * @return String representation of the Pair class
     */
    @Override
    public String toString() {
        return "Pair{" +
                "list=" + list +
                ", map=" + map +
                '}';
    }
    /**
     * Compares an object to Pair class to check for equality
     * @param o object to compare to
     * @return True if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(list, pair.list) && Objects.equals(map, pair.map);
    }
    /**
     * Override hashcode method of the object
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(list, map);
    }
}
