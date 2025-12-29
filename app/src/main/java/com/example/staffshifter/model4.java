package com.example.staffshifter;

public class model4 {
    String absent_staff,free_staff,class1,time1,subject1;

    public model4(String absent_staff, String free_staff,String class1,String time1,String subject1) {
        this.absent_staff = absent_staff;
        this.free_staff = free_staff;
        this.subject1=subject1;
        this.class1=class1;
        this.time1=time1;
    }

    public String getAbsent_staff() {
        return absent_staff;
    }

    public void setAbsent_staff(String absent_staff) {
        this.absent_staff = absent_staff;
    }

    public String getFree_staff() {
        return free_staff;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public void setFree_staff(String free_staff) {
        this.free_staff = free_staff;
    }
}