package com.example.demo;

import java.util.Objects;
import java.math.BigDecimal;

/**
 * Coordinate class to hold longitude and latitude information for the property
 * @author Calvin Wong
 */
public class Coordinates {
    BigDecimal latitude;
    BigDecimal longitude;

    /**
     * Constructor of the Coordinate class
     * @param latitude longitude of the property
     * @param longitude latitude of the property
     */
    public Coordinates(BigDecimal latitude, BigDecimal longitude){
        this. latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Get the latitude of the property
     * @return latitude of the property
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Sets the current latitude of the property to a new value
     * @param latitude new latitude to set
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
    /**
     * Get the longitude of the property
     * @return longitude of the property
     */
    public BigDecimal getLongitude() {
        return longitude;
    }
    /**
     * Sets the current longitude of the property to a new value
     * @param longitude new longitude to set
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * String representation of the Coordinate object
     * @return string description of the Coordinate object
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    /**
     * Compares an object to Coordinate class to check for equality
     * @param o object to compare to
     * @return True if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return latitude.equals(that.latitude) && longitude.equals(that.longitude);
    }
    /**
     * Override hashcode method of the object
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
