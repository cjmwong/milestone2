package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiPropertyAssessmentDAO {
    private Pair allProperties;

    public static PropertyAssessment getByAccountNumber(int accountNumber) {
        String endpoint = "https://data.edmonton.ca/resource/q7d6-ambg.csv";
        String query = endpoint + "?account_number=" + accountNumber;

        HttpClient client = HttpClient.newHttpClient();
        // GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(query))
                .GET()
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Scanner scanner = new Scanner(response.body());
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            String[] propertyInfo = scanner.nextLine().split(",", -1);

            for (int i  = 0; i < propertyInfo.length; i++) {
                propertyInfo[i] = propertyInfo[i].replaceAll("\"", "");
            }

            return LoadData.buildProperty(propertyInfo);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void getByNeighbourhood(String neighbourhood) {
        String endpoint = "https://data.edmonton.ca/resource/q7d6-ambg.csv";
        String query = endpoint + "?" + "$select=*" + "&$limit=5000";
        HttpClient client = HttpClient.newHttpClient();
        // GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(query))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Scanner scanner = new Scanner(response.body());
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            String[] propertyInfo;
            List<PropertyAssessment> neighbourhoodList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                propertyInfo = scanner.nextLine().split(",", -1);
                for (int i = 0; i < propertyInfo.length; i++) {
                    propertyInfo[i] = propertyInfo[i].replaceAll("\"", "");
                }
                neighbourhoodList.add(LoadData.buildProperty(propertyInfo));
            }
            System.out.println(neighbourhoodList.size());
        } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

    }
    /*
    List<PropertyAssessment> getByAssessmentClass(String assessmentClass)
    List<PropertyAssessment> getAll()
     */
    public static void main(String[] args) {
        getByNeighbourhood("GRANVILLE");
    }
}
