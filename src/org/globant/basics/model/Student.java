package org.globant.basics.model;

import java.util.List;

public class Student extends Person {

    private int studentCode;
    private Double average;
    private int semester;
    private String program;


    public Student(String name, String lastName, int age, int phoneNumber, String emailAdress, int studentCode, Double average, int semester, String program) {
        super(name, lastName, age, phoneNumber, emailAdress);
        this.studentCode = studentCode;
        this.average = average;
        this.semester = semester;
        this.program = program;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }


}
