package com.example.halisiwellness.models;

public class dataObjectClass {

    private String name;
    private String phone;
    private LastAppointmentObject lastAppointmentObject;

    public dataObjectClass(String name, String phone, LastAppointmentObject lastAppointmentObject) {
        this.name = name;
        this.phone = phone;
        this.lastAppointmentObject = lastAppointmentObject;
    }
}
