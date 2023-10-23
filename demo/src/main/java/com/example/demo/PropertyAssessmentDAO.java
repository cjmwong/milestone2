package com.example.demo;

import java.util.List;

public interface PropertyAssessmentDAO {
    PropertyAssessment getByAccountNumber(int accountNumber);
    List<PropertyAssessment> getByNeighbourhood(String neighbourhood);
    List<PropertyAssessment> getByAssessmentClass(String assessmentClass);
}
