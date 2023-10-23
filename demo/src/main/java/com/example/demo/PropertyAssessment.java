package com.example.demo;

import java.util.Objects;

/**
 * PropertyAssessment class  represents a single property assessment and implements the Comparable interface by assessed value
 * @author Calvin Wong
 */
public class PropertyAssessment implements Comparable<PropertyAssessment> {
    private String accNum;
    private String suit;
    private String houseNumber;
    private String StreetName;
    private boolean garage;
    private Neighborhood nInfo;
    private Coordinates coordInfo;
    private Assessment assessment;

    /**
     * Constructor of the PropertyAssessment class
     * @param accNum account number of the property
     * @param suit suit of the property
     * @param houseNumber house number of the property
     * @param streetName street name of the property
     * @param garage true if the property has a garage, false otherwise
     * @param nInfo information about a properties neighborhood
     * @param coordInfo coordinate information for the property
     * @param assessment assessment information for the property
     */
    public PropertyAssessment(String accNum, String suit, String houseNumber, String streetName, boolean garage, Neighborhood nInfo, Coordinates coordInfo, Assessment assessment) {
        this.accNum = accNum;
        this.suit = suit;
        this.houseNumber = houseNumber;
        StreetName = streetName;
        this.garage = garage;
        this.nInfo = nInfo;
        this.coordInfo = coordInfo;
        this.assessment = assessment;
    }
    /**
     * get the account number of the property
     * @return the account number of the property
     */
    public String getAccNum() {
        return accNum;
    }

    /**
     * sets the account number of the property to a new value
     * @param accNum value to set the account number
     */
    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    /**
     * gets the suit of the property
     * @return the suit of the property
     */
    public String getSuit() {
        return suit;
    }

    /**
     * sets the suit of the property to a new value
     * @param suit the new suit to set for the property
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }
    /**
     * gets the house number of the property
     * @return the suit of the property
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * * sets the house number of the property to a new value
     * @param houseNumber the new house number for the property
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    /**
     * gets the street name of the property
     * @return the street name of the property
     */
    public String getStreetName() {
        return StreetName;
    }
    /**
     * * sets the street name of the property to a new value
     * @param streetName the new street name for the property
     */
    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    /**
     * check if property has a garage
     * @return true if property has a garage, false otherwise
     */
    public boolean hasGarage() {
        return garage;
    }
    /**
     * set the garage information for the property
     * @param garage true if it has garage, false otherwise
     */
    public void setGarage(boolean garage) {
        this.garage = garage;
    }
    /**
     * gets the neighborhood information of the property
     * @return the neighborhood information of the property
     */
    public Neighborhood getNInfo() {
        return nInfo;
    }
    /**
     * * sets the neighborhood information of the property to a new value
     * @param nInfo the new neighborhood information for the property
     */
    public void setNInfo(Neighborhood nInfo) {
        this.nInfo = nInfo;
    }
    /**
     * gets the coordinate information of the property
     * @return the coordinate information of the property
     */
    public Coordinates getCoordInfo() {
        return coordInfo;
    }
    /**
     * * sets the coordinate information of the property to a new value
     * @param coordInfo the new street name for the property
     */
    public void setCoordInfo(Coordinates coordInfo) {
        this.coordInfo = coordInfo;
    }
    /**
     * gets the street name of the property
     * @return the street name of the property
     */
    public Assessment getAssessment() {
        return assessment;
    }
    /**
     * * sets the assessment information of the property to a new value
     * @param assessment the new assessment information for the property
     */
    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    @Override
    public String toString() {
        return "Property{" +
                "accNum=" + accNum +
                ", suit='" + suit + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", StreetName='" + StreetName + '\'' +
                ", Garage=" + garage +
                ", nInfo=" + nInfo +
                ", coordInfo=" + coordInfo +
                ", assessment=" + assessment +
                '}';
    }
    /**
     * String representation of the PropertyAssessment class
     * @return String representation of the PropertyAssessment class
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyAssessment property = (PropertyAssessment) o;
        return garage == property.garage && Objects.equals(accNum, property.accNum) && Objects.equals(suit, property.suit) && Objects.equals(houseNumber, property.houseNumber) && Objects.equals(StreetName, property.StreetName) && Objects.equals(nInfo, property.nInfo) && Objects.equals(coordInfo, property.coordInfo) && Objects.equals(assessment, property.assessment);
    }
    /**
     * Override hashcode method of the object
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(accNum, suit, houseNumber, StreetName, garage, nInfo, coordInfo, assessment);
    }

    /**
     * Compares the assessment value when two PropertyAssessment classes are compared
     * @param b the object to be compared.
     * @return -1 for smaller, 0 for equal, and 1 for greater when object is compared to b
     */
    @Override
    public int compareTo(PropertyAssessment b) {
        return this.getAssessment().getValue().compareTo(b.getAssessment().getValue());
    }
}


