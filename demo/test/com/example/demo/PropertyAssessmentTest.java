package com.example.demo;

import com.example.demo.Assessment;
import com.example.demo.Coordinates;
import com.example.demo.Neighborhood;
import com.example.demo.PropertyAssessment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PropertyAssessmentTest {
    PropertyAssessment p1;
    PropertyAssessment p2;
    PropertyAssessment p3;
    PropertyAssessment p4;
    Neighborhood n1;
    Neighborhood n2;
    Coordinates c1;
    Coordinates c2;
    Assessment a1;
    Assessment a2;
    @BeforeEach
    void setup() {
        n1 = new Neighborhood("12345", "NEIGHBOR", "HOME");
        n2 = new Neighborhood("54321", "HOOD", "HOUSE");
        c1 = new Coordinates(new BigDecimal(50000), new BigDecimal(-100000));
        c2 = new Coordinates(new BigDecimal(58000), new BigDecimal(150000));
        a1 = new Assessment(new BigDecimal(1000), "35", "35", "30", "RESIDENTIAL", "COMMERCIAL", "RESIDENTIAL");
        a2 = new Assessment(new BigDecimal(2000), "30", "30", "40", "RESIDENTIAL", "RESIDENTIAL", "COMMERCIAL");

        p1 = new PropertyAssessment("1234", "123", "5432", "STREET", true, n1, c1, a1);
        p2 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a2);
        p3 = new PropertyAssessment("1234", "123", "5432", "STREET", true, n1, c1, a1);
        p4 = new PropertyAssessment("9876", "987", "2345", "NAME", false, n2, c2, a2);
    }

    @Test
    void getAccNum() {
        assertEquals("1234", p1.getAccNum());
        assertEquals("9876", p2.getAccNum());
    }

    @Test
    void setAccNum() {
        p1.setAccNum("5555");
        p2.setAccNum("3333");
        assertEquals("5555", p1.getAccNum());
        assertEquals("3333", p2.getAccNum());
    }

    @Test
    void getSuit() {
        assertEquals("123", p1.getSuit());
        assertEquals("987", p2.getSuit());
    }

    @Test
    void setSuit() {
        p1.setSuit("555");
        p2.setSuit("333");
        assertEquals("555", p1.getSuit());
        assertEquals("333", p2.getSuit());
    }

    @Test
    void getHouseNumber() {
        assertEquals("5432", p1.getHouseNumber());
        assertEquals("2345", p2.getHouseNumber());
    }

    @Test
    void setHouseNumber() {
        p1.setHouseNumber("543");
        p2.setHouseNumber("234");
        assertEquals("543", p1.getHouseNumber());
        assertEquals("234", p2.getHouseNumber());
    }

    @Test
    void getStreetName() {
        assertEquals("STREET", p1.getStreetName());
        assertEquals("NAME", p2.getStreetName());
    }

    @Test
    void setStreetName() {
        p1.setStreetName("NAME");
        p2.setStreetName("STREET");
        assertEquals("NAME", p1.getStreetName());
        assertEquals("STREET", p2.getStreetName());
    }

    @Test
    void hasGarage() {
        assertTrue(p1.hasGarage());
        assertFalse(p2.hasGarage());
    }

    @Test
    void setGarage() {
        p1.setGarage(false);
        p2.setGarage(true);
        assertTrue(p2.hasGarage());
        assertFalse(p1.hasGarage());
    }
    @Test
    void getNInfo() {
        assertEquals(n1, p1.getNInfo());
        assertEquals(n2, p2.getNInfo());
    }
    @Test
    void setNInfo() {
        p1.setNInfo(n2);
        p2.setNInfo(n1);
        assertEquals(n1, p2.getNInfo());
        assertEquals(n2, p1.getNInfo());
    }
    @Test
    void getCoordInfo() {
        assertEquals(c1, p1.getCoordInfo());
        assertEquals(c2, p2.getCoordInfo());
    }

    @Test
    void setCoordInfo() {
        p1.setCoordInfo(c2);
        p2.setCoordInfo(c1);
        assertEquals(c1, p2.getCoordInfo());
        assertEquals(c2, p1.getCoordInfo());
    }

    @Test
    void getAssessment() {
        assertEquals(a1, p1.getAssessment());
        assertEquals(a2, p2.getAssessment());
    }

    @Test
    void setAssessment() {
        p1.setAssessment(a2);
        p2.setAssessment(a1);
        assertEquals(a1, p2.getAssessment());
        assertEquals(a2, p1.getAssessment());
    }

    @Test
    void testToString() {
        assertEquals("Property{" +
                "accNum=" + p1.getAccNum() +
                ", suit='" + p1.getSuit() + '\'' +
                ", houseNumber='" + p1.getHouseNumber() + '\'' +
                ", StreetName='" + p1.getStreetName() + '\'' +
                ", Garage=" + p1.hasGarage() +
                ", nInfo=" + p1.getNInfo() +
                ", coordInfo=" + p1.getCoordInfo() +
                ", assessment=" + p1.getAssessment()+
                '}', p1.toString());
        assertEquals("Property{" +
                "accNum=" + p2.getAccNum() +
                ", suit='" + p2.getSuit() + '\'' +
                ", houseNumber='" + p2.getHouseNumber() + '\'' +
                ", StreetName='" + p2.getStreetName() + '\'' +
                ", Garage=" + p2.hasGarage() +
                ", nInfo=" + p2.getNInfo() +
                ", coordInfo=" + p2.getCoordInfo() +
                ", assessment=" + p2.getAssessment()+
                '}', p2.toString());
    }

    @Test
    void testEquals() {
        boolean t1 = p1.equals(p2);
        boolean t2 = p1.equals(p3);
        boolean t3 = p2.equals(p3);
        boolean t4 = p2. equals(p4);
        assertFalse(t1);
        assertTrue(t2);
        assertFalse(t3);
        assertTrue(t4);
    }

    @Test
    void testHashCode() {
        int h1 = p1.hashCode();
        int h2 = p2.hashCode();
        int h3 = p3.hashCode();
        int h4 = p4.hashCode();
        assertEquals(h1, h3);
        assertEquals(h2, h4);
    }

    @Test
    void compareTo() {
        assertEquals(1, p2.compareTo(p1));
        assertEquals(0, p2.compareTo(p4));
        assertEquals(-1, p1.compareTo(p4));

    }

}