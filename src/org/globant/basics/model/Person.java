package org.globant.basics.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    private String name;
    private String lastName;
    private int age;
    private int phoneNumber;
    private String emailAddress;
    private List<Course> coursePerson;

    public Person(String name, String lastName, int age, int phoneNumber, String emailAddress) {

        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Course> getCoursePerson() {
        return coursePerson;
    }

    public void setCoursePerson(List<Course> coursePerson) {
        this.coursePerson = coursePerson;
    }

    public void addCourse(Course course) {
        if (this.coursePerson == null) {
            this.coursePerson = (new ArrayList<>());
        }
        this.coursePerson.add(course);
    }
}
