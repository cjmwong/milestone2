package com.example.demo;

import com.example.demo.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicSliderUI;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {
    private Coordinates c1;
    private Coordinates c2;
    private Coordinates c3;
    private Coordinates c4;
    @BeforeEach
    void setup(){
        c1 = new Coordinates(new BigDecimal(50000), new BigDecimal(-100000));
        c2 = new Coordinates(new BigDecimal(58000), new BigDecimal(150000));
        c3 = new Coordinates(new BigDecimal(50000), new BigDecimal(-100000));
        c4 = new Coordinates(new BigDecimal(58000), new BigDecimal(150000));
    }

    @Test
    void getLatitude() {
        assertEquals(new BigDecimal(50000), c1.getLatitude());
        assertEquals(new BigDecimal(58000), c2.getLatitude());
    }

    @Test
    void setLatitude() {
        c1.setLatitude(new BigDecimal(100));
        c2.setLatitude(new BigDecimal(500));
        assertEquals(new BigDecimal(100), c1.getLatitude());
        assertEquals(new BigDecimal(500), c2.getLatitude());
    }

    @Test
    void getLongitude() {
        assertEquals(new BigDecimal(-100000), c1.getLongitude());
        assertEquals(new BigDecimal(150000), c2.getLongitude());
    }

    @Test
    void setLongitude() {
        c1.setLongitude(new BigDecimal(100));
        c2.setLongitude(new BigDecimal(500));
        assertEquals(new BigDecimal(100), c1.getLongitude());
        assertEquals(new BigDecimal(500), c2.getLongitude());
    }

    @Test
    void testToString() {
        assertEquals("Coordinates{" +
                "latitude=" + c1.getLatitude() +
                ", longitude=" + c1.getLongitude() +
                '}', c1.toString());
    }

    @Test
    void testEquals() {
        boolean t1 = c1.equals(c2);
        boolean t2 = c1.equals(c3);
        boolean t3 = c2.equals(c3);
        boolean t4 = c2. equals(c4);
        assertFalse(t1);
        assertTrue(t2);
        assertFalse(t3);
        assertTrue(t4);
    }

    @Test
    void testHashCode() {
        int h1 = c1.hashCode();
        int h2 = c2.hashCode();
        int h3 = c3.hashCode();
        int h4 = c4.hashCode();
        assertEquals(h1, h3);
        assertEquals(h2, h4);
    }
}