package com.example.demo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Assessment class to hold assessment information of the property
 * @author Calvin Wong
 */
public class Assessment{
    private BigDecimal value;
    private String classPercent1;
    private String classPercent2;
    private String classPercent3;
    private String class1;
    private String class2;
    private String class3;

    /**
     * Assessment Class Constructor
     * @param value
     * @param classPercent1
     * @param classPercent2
     * @param classPercent3
     * @param class1
     * @param class2
     * @param class3
     */
    public Assessment(BigDecimal value, String classPercent1, String classPercent2, String classPercent3, String class1, String class2, String class3) {
        this.value = value;
        this.classPercent1 = classPercent1;
        this.classPercent2 = classPercent2;
        this.classPercent3 = classPercent3;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
    }

    /**
     * Returns assessment value of the property
     * @return assessment value of the property
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Set new assessment value for the property
     * @param value the new assessment value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the assessment class one percentage of the property
     * @return assessment class one percentage
     */
    public String getClassPercent1() {
        return classPercent1;
    }

    /**
     * Set a new class percentage for assessment class one
     * @param classPercent1 assessment class percentage
     */
    public void setClassPercent1(String classPercent1) {
        this.classPercent1 = classPercent1;
    }
    /**
     * Gets the assessment class two percentage of the property
     * @return assessment class two percentage
     */
    public String getClassPercent2() {
        return classPercent2;
    }
    /**
     * Set a new class percentage for assessment class two
     * @param classPercent2 assessment class percentage
     */
    public void setClassPercent2(String classPercent2) {
        this.classPercent2 = classPercent2;
    }
    /**
     * Gets the assessment class three percentage of the property
     * @return assessment class three percentage
     */
    public String getClassPercent3() {
        return classPercent3;
    }
    /**
     * Set a new class percentage for assessment class three
     * @param classPercent3 assessment class percentage
     */
    public void setClassPercent3(String classPercent3) {
        this.classPercent3 = classPercent3;
    }

    /**
     * Gets the class assessment type
     * @return class assessment type
     */
    public String getClass1() {
        return class1;
    }

    /**
     * Set class assessment type to another class
     * @param class1 new class assessment
     */
    public void setClass1(String class1) {
        this.class1 = class1;
    }
    /**
     * Gets the class assessment type
     * @return class assessment type
     */
    public String getClass2() {
        return class2;
    }
    /**
     * Set class assessment type to another class
     * @param class2 new class assessment
     */
    public void setClass2(String class2) {
        this.class2 = class2;
    }
    /**
     * Gets the class assessment type
     * @return class assessment type
     */
    public String getClass3() {
        return class3;
    }
    /**
     * Set class assessment type to another class
     * @param class3 new class assessment
     */
    public void setClass3(String class3) {
        this.class3 = class3;
    }

    /**
     * A string representation of Assessment object
     * @return string representation of Assessment object
     */
    @Override
    public String toString() {
        return "Assessment{" +
                "value=" + value +
                ", classPercent1='" + classPercent1 + '\'' +
                ", classPercent2='" + classPercent2 + '\'' +
                ", classPercent3='" + classPercent3 + '\'' +
                ", class1='" + class1 + '\'' +
                ", class2='" + class2 + '\'' +
                ", class3='" + class3 + '\'' +
                '}';
    }

    /**
     * Compares an object to Assessment class to check for equality
     * @param o object to compare to
     * @return True if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assessment that = (Assessment) o;
        return Objects.equals(value, that.value) && Objects.equals(classPercent1, that.classPercent1) && Objects.equals(classPercent2, that.classPercent2) && Objects.equals(classPercent3, that.classPercent3) && Objects.equals(class1, that.class1) && Objects.equals(class2, that.class2) && Objects.equals(class3, that.class3);
    }

    /**
     * Overrided hashcode method of the object
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, classPercent1, classPercent2, classPercent3, class1, class2, class3);
    }
}


