package com.abrus.task4;

class Address {
    private String city;
    private String street;

    Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    String getCity() {
        return city;
    }

    String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String toString() {
        return this.city + ", " + this.street;
    }
}
