package com.example.demo;

import com.example.demo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    private Pair pair1;
    private Pair pair2;
    private PropertyAssessment p1;
    private PropertyAssessment p2;
    private PropertyAssessment p3;
    private PropertyAssessment p4;
    private Neighborhood n1;
    private Neighborhood n2;
    private Coordinates c1;
    private Coordinates c2;
    private Assessment a1;
    private Assessment a2;
    private ArrayList<PropertyAssessment> aList1;
    private ArrayList<PropertyAssessment> aList2;
    private HashMap<String, PropertyAssessment> hMap1;
    private HashMap<String, PropertyAssessment> hMap2;
    @BeforeEach
    void setup(){
        n1 = new Neighborhood("12345", "NEIGHBOR", "HOME");
        n2 = new Neighborhood("54321", "HOOD", "HOUSE");
        c1 = new Coordinates(new BigDecimal(50000), new BigDecimal(-100000));
        c2 = new Coordinates(new BigDecimal(58000), new BigDecimal(150000));
        a1 = new Assessment(new BigDecimal(1000), "35", "35", "30", "RESIDENTIAL", "COMMERCIAL", "RESIDENTIAL");
        a2 = new Assessment(new BigDecimal(2000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");

        p1 = new PropertyAssessment("1234", "123", "5432", "STREET", true, n1, c1, a1);
        p2 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a2);
        p3 = new PropertyAssessment("1235", "123", "5432", "STREET", true, n1, c1, a1);
        p4 = new PropertyAssessment("9874", "987", "2345", "NAME", false, n2, c2, a2);

        pair1 = new Pair(new ArrayList<> (), new HashMap<>());
        pair2 = new Pair(new ArrayList<> (), new HashMap<>());
        pair1.getList().add(p2);
        pair1.getList().add(p1);
        pair1.getMap().put("1234", p1);
        pair1.getMap().put("9876", p2);

        pair2.getList().add(p4);
        pair2.getList().add(p3);
        pair2.getMap().put("1235", p3);
        pair2.getMap().put("9874", p4);

        aList1 = new ArrayList<>();
        aList2 = new ArrayList<>();
        aList1.add(p2);
        aList1.add(p1);
        aList2.add(p4);
        aList2.add(p3);

        hMap1 = new HashMap<>();
        hMap2 = new HashMap<>();
        hMap1.put("1234", p1);
        hMap1.put("9876", p2);
        hMap2.put("1235", p3);
        hMap2.put("9874", p4);
    }

    @Test
    void getList() {
        assertEquals(aList1 , pair1.getList());
        assertEquals(aList2, pair2.getList());
    }

    @Test
    void setList() {
        pair1.setList(aList2);
        pair2.setList(aList1);
        assertEquals(aList1 , pair2.getList());
        assertEquals(aList2, pair1.getList());
    }

    @Test
    void getMap() {
        assertEquals(hMap1 , pair1.getMap());
        assertEquals(hMap2, pair2.getMap());
    }

    @Test
    void setMap() {
        pair1.setMap(hMap2);
        pair2.setMap(hMap1);
        assertEquals(hMap1 , pair2.getMap());
        assertEquals(hMap2, pair1.getMap());
    }

    @Test
    void testToString() {
        assertEquals("Pair{" +
                "list=" + pair1.getList() +
                ", map=" + pair1.getMap() +
                '}', pair1.toString());
        assertEquals("Pair{" +
                "list=" + pair2.getList() +
                ", map=" + pair2.getMap() +
                '}', pair2.toString());
    }

    @Test
    void testEquals() {
        boolean t1 = pair1.equals(pair2);
        boolean t2 = pair2.equals(pair1);
        boolean t3 = pair1.equals(pair1);
        boolean t4 = pair2. equals(pair2);
        assertFalse(t1);
        assertFalse(t2);
        assertTrue(t3);
        assertTrue(t4);
    }

    @Test
    void testHashCode() {
        int h1 = pair1.hashCode();
        int h2 = pair2.hashCode();
        assertFalse(h2 == h1);
        assertTrue(h1 == h1);
    }
}