package org.globant.basics.model;

public class Professor extends Person {

    private Double salary;
    private String profession;
    private boolean isFullTime;
    private int experienceYears;
    private int hoursPerWeek;


    public Professor(String name, String lastName, int age, int phoneNumber, String emailAdress, Double salary, String profession, boolean isFullTime, int expirenceYears
            , int hoursPerWeek) {
        super(name, lastName, age, phoneNumber, emailAdress);
        this.salary = (this.isFullTime() ? expirenceYears * 0.8 : hoursPerWeek * 0.5);
        this.profession = profession;
        this.isFullTime = isFullTime;
        this.experienceYears = expirenceYears;
        this.hoursPerWeek = hoursPerWeek;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public int getExpirenceYears() {
        return experienceYears;
    }

    public void setExpirenceYears(int expirenceYears) {
        this.experienceYears = expirenceYears;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }



}
