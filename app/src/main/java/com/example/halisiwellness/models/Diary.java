
package com.example.halisiwellness.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diary implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("meal")
    @Expose
    private String meal;
    @SerializedName("meal_category")
    @Expose
    private Object mealCategory;
    @SerializedName("meal_time")
    @Expose
    private String mealTime;
    private final static long serialVersionUID = 8206795509254294281L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Diary() {
    }

    /**
     * 
     * @param meal
     * @param mealTime

     * @param mealCategory
     */
    public Diary(String meal, Object mealCategory, String mealTime) {
        super();

        this.meal = meal;
        this.mealCategory = mealCategory;
        this.mealTime = mealTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Object getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(Object mealCategory) {
        this.mealCategory = mealCategory;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

}
