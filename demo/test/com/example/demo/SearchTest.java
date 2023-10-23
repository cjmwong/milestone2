package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    private Pair pair;
    private PropertyAssessment p1;
    private PropertyAssessment p2;
    private PropertyAssessment p3;
    private PropertyAssessment p4;
    private PropertyAssessment p5;
    private Neighborhood n1;
    private Neighborhood n2;
    private Coordinates c1;
    private Coordinates c2;
    private Assessment a1;
    private Assessment a2;
    private Assessment a3;
    private Assessment a4;
    private Assessment a5;
    private ArrayList<PropertyAssessment> testArray = new ArrayList<>();
    private HashMap<String, PropertyAssessment> hMap1;

    @BeforeEach
    void setup() {
        n1 = new Neighborhood("12345", "NEIGHBOR", "HOME");
        n2 = new Neighborhood("54321", "HOOD", "HOUSE");
        c1 = new Coordinates(new BigDecimal(50000), new BigDecimal(-100000));
        c2 = new Coordinates(new BigDecimal(58000), new BigDecimal(150000));
        a1 = new Assessment(new BigDecimal(1000), "35", "35", "30", "RESIDENTIAL", "COMMERCIAL", "RESIDENTIAL");
        a2 = new Assessment(new BigDecimal(2000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");
        a3 = new Assessment(new BigDecimal(3000), "35", "35", "30", "RESIDENTIAL", "COMMERCIAL", "RESIDENTIAL");
        a4 = new Assessment(new BigDecimal(4000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");
        a5 = new Assessment(new BigDecimal(5000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");
        p1 = new PropertyAssessment("1234", "123", "5432", "STREET", true, n1, c1, a1);
        p2 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a2);
        p3 = new PropertyAssessment("1234", "123", "5432", "STREET", true, n1, c1, a3);
        p4 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a4);
        p5 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a5);
        pair = LoadData.readCSV("Property_Assessment_Data_2023.csv");

        testArray.add(p1);
        testArray.add(p2);
        testArray.add(p3);
        testArray.add(p4);
        testArray.add(p5);

        hMap1 = new HashMap<>();
        hMap1.put("1234", p1);
        hMap1.put("9876", p2);
        hMap1.put("1235", p3);
        hMap1.put("9874", p4);
    }
    @Test
    void searchByAccount() {
        assertEquals(p1, CsvPropertyAssessmentDAO.getByAccountNumber("1234", hMap1));
        assertEquals(p2, CsvPropertyAssessmentDAO.getByAccountNumber("9876", hMap1));
    }

    @Test
    void searchByNeighborhood() {
        assertEquals(3, CsvPropertyAssessmentDAO.getByNeighborhood("HOOD", testArray).size()); //3 total properties in neighborhood "HOOD"
        assertEquals(2, CsvPropertyAssessmentDAO.getByNeighborhood("NEIGHBOR", testArray).size()); //2 total properties in "NEIGHBOR"
    }

    @Test
    void buildNeighborhoodList() {
        assertEquals(2, CsvPropertyAssessmentDAO.buildNeighborhoodList(testArray).size()); //2 total neighborhoods
        assertEquals(403, CsvPropertyAssessmentDAO.buildNeighborhoodList(pair.getList()).size()); //403 total neighborhoods in csv file
    }

    @Test
    void searchByAssessment() {
        assertEquals(5, CsvPropertyAssessmentDAO.getByAssessment("RESIDENTIAL", testArray).size()); //5 total residential properties
        assertEquals(896, CsvPropertyAssessmentDAO.getByAssessment("FARMLAND", pair.getList()).size()); //896 total FARMLAND properties"
    }

    @Test
    void buildAssessmentList() {
        assertEquals(2, CsvPropertyAssessmentDAO.buildAssessmentList(testArray).size()); //2 total assessment types
        assertEquals(5, CsvPropertyAssessmentDAO.buildAssessmentList(pair.getList()).size()); //2 total assessment types in csv file
    }

    @Test
    void removeDuplicates() {
        testArray.add(p1);
        assertEquals(testArray.size() - 1, CsvPropertyAssessmentDAO.removeDuplicates(testArray).size());
        testArray.add(p1);
        testArray.add(p2);
        testArray.add(p3);
        assertEquals(testArray.size() - 3, CsvPropertyAssessmentDAO.removeDuplicates(testArray).size());
    }
}