package com.example.halisiwellness.Response;

import com.example.halisiwellness.models.LastAppointmentObject;

public class MainResponseObjectClass {

    private String name;
    private String phone;
    private LastAppointmentObject lastAppointmentObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LastAppointmentObject getLastAppointmentObject() {
        return lastAppointmentObject;
    }

    public void setLastAppointmentObject(LastAppointmentObject lastAppointmentObject) {
        this.lastAppointmentObject = lastAppointmentObject;
    }
}
