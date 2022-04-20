package com.mvc.impl;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favLanguage;
    private String operatingSystem;
    private LinkedHashMap<String, String> countryMap;
    private LinkedHashMap<String, String> favLanguageOptions;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student(){
        countryMap = new LinkedHashMap<>();
        countryMap.put("AGR" , "Argentina");
        countryMap.put("BR" , "Brazil");
        countryMap.put("IND" , "India");
        countryMap.put("JP" , "Japan");

        favLanguageOptions = new LinkedHashMap<>();
        favLanguageOptions.put("Java", "Java");
        favLanguageOptions.put("Python", "Python");
        favLanguageOptions.put("C++", "C++");
    }

    public LinkedHashMap<String, String> getCountryMap() {
        return countryMap;
    }
    public String getFavLanguage() {
        return favLanguage;
    }

    public void setFavLanguage(String favLanguage) {
        this.favLanguage = favLanguage;
    }

    public LinkedHashMap<String, String> getFavLanguageOptions() {
        return favLanguageOptions;
    }

    public void setFavLanguageOptions(LinkedHashMap<String, String> favLanguageOptions) {
        this.favLanguageOptions = favLanguageOptions;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
