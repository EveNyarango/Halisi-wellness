package com.example.halisiwellness.models;


import org.parceler.Parcel;

@Parcel
public class UserData {
    private String username;
    private String email;
    private String password;



    public UserData(String username, String email, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserData(String username,String password){
        this.username = username;
        this.password = password;
    }

    public UserData(String email,String password, int number){
        this.email = email;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
