package com.abrus.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private String school;
    private Address address;
    private List<Grade> grades;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    Student(String name, int age, String school, String city, String street) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.address = new Address(city, street);
        this.grades = new ArrayList<>();
    }

    void addGrade(String subject, double score) {
        this.grades.add(new Grade(subject, score));
    }

    public String toString() {
        return this.name + " [ age: " + this.age + ", " + this.address + ", \n\t grades: "
                + this.grades.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                + " \n]";
    }
}
