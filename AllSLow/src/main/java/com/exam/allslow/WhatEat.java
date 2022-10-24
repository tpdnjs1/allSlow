package com.exam.allslow;

import java.time.LocalDate;

public class WhatEat {
    private String name;
    private String calorie;
    private LocalDate date;
    private String time;

    public WhatEat(String name, String calorie,LocalDate date, String time){
        this.name = name;
        this.calorie = calorie;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
