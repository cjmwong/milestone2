package com.example.demo;

import java.util.*;

/**
 * Search class used to search for properties matching search criteria
 * @author Calvin Wong
 */
public class CsvPropertyAssessmentDAO {
    private Pair allProperties;

    /**
     * Searches for a property by account number
     * @param accNum the property account number to search
     * @param properties hashmap of all properties with account number as the key
     * @return PropertyAssessment object matching the search criteria or null
     */
    public static PropertyAssessment getByAccountNumber(String accNum, Map<String, PropertyAssessment> properties){
        return properties.get(accNum);
    }

    /**
     * Searches for properties based on neighborhood
     * @param neighborhood neighborhood to search for
     * @param properties arraylist of properties sorted by assessed value
     * @return array list of PropertyAssessment objects matching the search criteria or null
     */
    public static List<PropertyAssessment> getByNeighborhood(String neighborhood, List<PropertyAssessment> properties ){
        Map<String, List<PropertyAssessment>> neighborhoodList = buildNeighborhoodList(properties);
        return neighborhoodList.get(neighborhood);
    }

    /**
     * builds a hashmap of PropertyAssessment objects that are grouped by neighborhood as the key
     * @param properties array list of PropertyAssessment objects sorted by assessment value
     * @return hashmap of PropertyAssessment objects that are grouped by neighborhood as the key
     */
    public static Map<String, List<PropertyAssessment>> buildNeighborhoodList(List<PropertyAssessment> properties) {
        Map<String, List<PropertyAssessment>> neighborhoodList = new HashMap<>();
        int i;
        for (i = 0; i < properties.size(); i++) {
            //append property to arraylist in hashmap value if neighborhood already exists as a key, create a new arraylist if neighborhood is not in the hashmap
            if (neighborhoodList.containsKey(properties.get(i).getNInfo().getNeighborhood())) {
                neighborhoodList.get(properties.get(i).getNInfo().getNeighborhood()).add(properties.get(i));
            } else {
                List<PropertyAssessment> p = new ArrayList<>();
                p.add(properties.get(i));
                neighborhoodList.put(properties.get(i).getNInfo().getNeighborhood(), p);
            }
        }
        return neighborhoodList;
    }

    /**
     * builds a hashmap of PropertyAssessment objects that are grouped by assessment class as the key
     * @param assessment the assessment class to search for
     * @param properties arraylist of properties sorted by assessed value
     * @return array list of PropertyAssessment objects matching the search criteria or null
     */
    public static List<PropertyAssessment> getByAssessment(String assessment, List<PropertyAssessment> properties){
        Map<String, List<PropertyAssessment>> assessmentList = buildAssessmentList(properties);
        return removeDuplicates(assessmentList.get(assessment)); //returns an array list with no duplicate properties
    }

    /**
     * builds a hashmap of PropertyAssessment objects that are grouped by assessment as the key
     * @param properties arraylist of properties sorted by assessed value
     * @return array list of PropertyAssessment objects matching the search criteria or null
     */
    public static Map<String, List<PropertyAssessment>> buildAssessmentList(List<PropertyAssessment> properties) {
        Map<String, List<PropertyAssessment>> assessmentList = new HashMap<>();
        int i;
        //iterate through class 1, class 2, and class 3
        for (i = 0; i < properties.size(); i++) {
            //append property to arraylist in hashmap value if assessment class already exists as a key, create a new arraylist if assessment class is not in the hashmap
            if (assessmentList.containsKey(properties.get(i).getAssessment().getClass1())) {
                assessmentList.get(properties.get(i).getAssessment().getClass1()).add(properties.get(i));
            }
            else {
                List<PropertyAssessment> p = new ArrayList<>();
                p.add(properties.get(i));
                assessmentList.put(properties.get(i).getAssessment().getClass1(), p);
            }
            if (assessmentList.containsKey(properties.get(i).getAssessment().getClass2())) {
                assessmentList.get(properties.get(i).getAssessment().getClass2()).add(properties.get(i));
            }
            else {
                //if class 2 is an empty field, skip
                if (properties.get(i).getAssessment().getClass3().length() == 0) {
                    continue;
                }
                List<PropertyAssessment> p = new ArrayList<>();
                p.add(properties.get(i));
                assessmentList.put(properties.get(i).getAssessment().getClass2(), p);
            }
            if (assessmentList.containsKey(properties.get(i).getAssessment().getClass3())) {
                assessmentList.get(properties.get(i).getAssessment().getClass3()).add(properties.get(i));
            }
            else {
                //if class 3 is an empty field, skip
                if (properties.get(i).getAssessment().getClass3().length() == 0) {
                    continue;
                }
                List<PropertyAssessment> p = new ArrayList<>();
                p.add(properties.get(i));
                assessmentList.put(properties.get(i).getAssessment().getClass3(), p);
            }
        }
        return assessmentList;
    }

    /**
     * removes duplicates in the arraylist of PropertyAssessment objects
     * @param properties arraylist of PropertyAssessment objects that match assessment class search criteria and sorted by assessment value
     * @return non-duplicate arraylist of PropertyAssessment objects that match assessment class search criteria and sorted by assessment value
     */
    public static List<PropertyAssessment> removeDuplicates(List<PropertyAssessment> properties){
        if (properties == null) {
            return null;
        }
        Set<PropertyAssessment> temp = new LinkedHashSet<>(properties);
        properties.clear();
        properties.addAll(temp);
        return properties;
    }

    private void getAll(String fName) {
        this.allProperties = LoadData.readCSV(fName);
    }
}
