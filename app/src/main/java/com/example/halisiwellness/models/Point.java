
package com.example.halisiwellness.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Point implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("date")
    @Expose
    private String date;
//    @SerializedName("created_at")
//    @Expose
//    private String createdAt;
    private final static long serialVersionUID = -5795465696252247829L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Point() {
    }

    /**
     * 
     * @param date
     *  @param phone
     * @param name
     * @param id
     */
    public Point(Integer id, String name, String phone, String date) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.date = date;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}
