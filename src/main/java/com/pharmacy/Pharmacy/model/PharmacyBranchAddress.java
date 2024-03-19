package com.pharmacy.Pharmacy.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "pharmacy_branch_address")
public class PharmacyBranchAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_branch_address_id")
    private Long id;
    private String country;
    private String city;
    private String street;

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PharmacyBranchAddress)) return false;
        PharmacyBranchAddress that = (PharmacyBranchAddress) o;
        return Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreet(), that.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getCity(), getStreet());
    }
}
