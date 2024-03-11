package com.pharmacy.Pharmacy.dto;


public class PharmacyBranchDTO {
    private String pharmacyCountry;
    private String pharmacyCity;
    private String pharmacyStreet;
    private String pharmacyName;

    public String getPharmacyCountry() {
        return pharmacyCountry;
    }

    public String getPharmacyCity() {
        return pharmacyCity;
    }

    public String getPharmacyStreet() {
        return pharmacyStreet;
    }

    public void setPharmacyCountry(String pharmacyCountry) {
        this.pharmacyCountry = pharmacyCountry;
    }

    public void setPharmacyCity(String pharmacyCity) {
        this.pharmacyCity = pharmacyCity;
    }

    public void setPharmacyStreet(String pharmacyStreet) {
        this.pharmacyStreet = pharmacyStreet;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }
}
