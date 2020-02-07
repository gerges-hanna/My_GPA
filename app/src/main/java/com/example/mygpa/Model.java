package com.example.mygpa;

public class Model {
    double grade;
    double hour;

    public Model(double grade, double hour) {
        this.grade = grade;
        this.hour = hour;
    }

    public Model() {
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }
}
