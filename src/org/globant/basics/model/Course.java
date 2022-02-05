package org.globant.basics.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {
    private String nameCourse;
    private int capacity;
    private String day;
    private String hour;
    private List<Professor> professorList;
    private List<Student> studentList;
    private List<Course> courseList;


    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public List<Professor> getProfessors() {
        return professorList;
    }

    public void setProfessors(List<Professor> professors) {
        this.professorList = professors;
    }

    public List<Student> getStudents() {
        return studentList;
    }

    public void setStudents(List<Student> students) {
        this.studentList = students;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Course(String name, int capacity, String day, String hour, List<Professor> professorList, List<Student> studentList) {

        this.nameCourse = name;
        this.capacity = capacity;
        this.day = day;
        this.hour = hour;
        this.professorList = professorList;
        this.studentList = studentList;
        this.courseList = new ArrayList<>();
    }

    public void addStudentToCurse(Student student) {
        if (this.studentList == null) {
            this.studentList = new ArrayList<>();
        }
        this.studentList.add(student);
    }

}
