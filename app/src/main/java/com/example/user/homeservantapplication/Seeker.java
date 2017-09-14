package com.example.user.homeservantapplication;

/**
 * Created by User on 3/21/2017.
 */

public class Seeker {
    private String seekerFirstName;
    private String seekerLastName;
    private String seekerUserName;
    private String seekerGender;
    private String seekerAge;
    private String seekerPhoneNumber;
    private String seekerNID;
    private String seekerLocation;
    private String seekerAddress;
    private String seekerPassword;


    public Seeker(String seekerFirstName, String seekerLastName, String seekerUserName, String seekerGender, String seekerAge, String seekerLocation, String seekerPhoneNumber, String seekerNID, String seekerAddress, String seekerPassword) {
        this.seekerFirstName = seekerFirstName;
        this.seekerLastName = seekerLastName;
        this.seekerUserName = seekerUserName;
        this.seekerGender = seekerGender;
        this.seekerAge = seekerAge;
        this.seekerLocation = seekerLocation;
        this.seekerPhoneNumber = seekerPhoneNumber;
        this.seekerNID = seekerNID;
        this.seekerAddress = seekerAddress;
        this.seekerPassword = seekerPassword;
    }


    public String getSeekerFirstName() {
        return seekerFirstName;
    }

    public void setSeekerFirstName(String seekerFirstName) {
        this.seekerFirstName = seekerFirstName;
    }

    public String getSeekerLastName() {
        return seekerLastName;
    }

    public void setSeekerLastName(String seekerLastName) {
        this.seekerLastName = seekerLastName;
    }

    public String getSeekerUserName() {
        return seekerUserName;
    }

    public void setSeekerUserName(String seekerUserName) {
        this.seekerUserName = seekerUserName;
    }

    public String getSeekerGender() {
        return seekerGender;
    }

    public void setSeekerGender(String seekerGender) {
        this.seekerGender = seekerGender;
    }

    public String getSeekerAge() {
        return seekerAge;
    }

    public void setSeekerAge(String seekerAge) {
        this.seekerAge = seekerAge;
    }

    public String getSeekerLocation() {
        return seekerLocation;
    }

    public void setSeekerLocation(String seekerLocation) {
        this.seekerLocation = seekerLocation;
    }

    public String getSeekerPhoneNumber() {
        return seekerPhoneNumber;
    }

    public void setSeekerPhoneNumber(String seekerPhoneNumber) {
        this.seekerPhoneNumber = seekerPhoneNumber;
    }

    public String getSeekerNID() {
        return seekerNID;
    }

    public void setSeekerNID(String seekerNID) {
        this.seekerNID = seekerNID;
    }

    public String getSeekerAddress() {
        return seekerAddress;
    }

    public void setSeekerAddress(String seekerAddress) {
        this.seekerAddress = seekerAddress;
    }

    public String getSeekerPassword() {
        return seekerPassword;
    }

    public void setSeekerPassword(String seekerPassword) {
        this.seekerPassword = seekerPassword;
    }
}
