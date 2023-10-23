package com.example.demo;

import java.util.Objects;

/**
 * Neighborhood class containing neighborhood information for the property
 * @author Calvin Wong
 */
public class Neighborhood {
    String neighborhoodID;
    String neighborhood;
    String ward;

    /**
     * Constructor for the neighborhood class
     * @param neighborhoodID ID of the neighborhood
     * @param neighborhood Neighborhood where property is located
     * @param ward Ward that the property is located in
     */
    public Neighborhood(String neighborhoodID, String neighborhood, String ward) {
        this.neighborhoodID = neighborhoodID;
        this.neighborhood = neighborhood;
        this.ward = ward;
    }

    /**
     * Gets the neighborhood ID of the property
     * @return the neighborhood ID of the property
     */
    public String getNeighborhoodID() {
        return neighborhoodID;
    }

    /**
     * Set a new neighborhood ID for the property
     * @param neighborhoodID new neighborhood ID to set
     */
    public void setNeighborhoodID(String neighborhoodID) {
        this.neighborhoodID = neighborhoodID;
    }

    /**
     * Get the neighborhood that the property is located in
     * @return the neighborhood that the property is located in
     */
    public String getNeighborhood() {
        return neighborhood;
    }
    /**
     * Set a new neighborhood for the property
     * @param neighborhood new neighborhood ID to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    /**
     * Get the ward that the property is located in
     * @return the ward that the property is located in
     */
    public String getWard() {
        return ward;
    }
    /**
     * Set a new ward for the property
     * @param ward new neighborhood ID to set
     */
    public void setWard(String ward) {
        this.ward = ward;
    }
    /**
     * String representation of the Neighborhood object
     * @return string description of the Neighborhood object
     */
    @Override
    public String toString() {
        return "Neighborhood{" +
                "neighborhoodID=" + neighborhoodID +
                ", neighborhood='" + neighborhood + '\'' +
                ", ward='" + ward + '\'' +
                '}';
    }
    /**
     * Compares an object to Neighborhood class to check for equality
     * @param o object to compare to
     * @return True if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighborhood that = (Neighborhood) o;
        return Objects.equals(neighborhoodID, that.neighborhoodID) && Objects.equals(neighborhood, that.neighborhood) && Objects.equals(ward, that.ward);
    }
    /**
     * Override hashcode method of the object
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(neighborhoodID, neighborhood, ward);
    }
}