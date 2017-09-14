package com.example.user.homeservantapplication;

/**
 * Created by User on 3/21/2017.
 */

public class Maid {
    private String maidFirstName;
    private String maidLastName;
    private String maidUserName;
    private String maidGender;
    private String maidAge;
    private String maidPhoneNumber;
    private String maidNID;
    private String maidLocation;
    private String maidAddress;
    private String maidPassword;


    public Maid(String maidFirstName, String maidLastName, String maidUserName, String maidGender, String maidAge, String maidLocation, String maidPhoneNumber, String maidNID, String maidAddress, String maidPassword) {
        this.maidFirstName = maidFirstName;
        this.maidLastName = maidLastName;
        this.maidUserName = maidUserName;
        this.maidGender = maidGender;
        this.maidAge = maidAge;
        this.maidLocation = maidLocation;
        this.maidPhoneNumber = maidPhoneNumber;
        this.maidNID = maidNID;
        this.maidAddress = maidAddress;
        this.maidPassword = maidPassword;
    }



    public String getMaidFirstName() {

        return maidFirstName;
    }

    public void setMaidFirstName(String maidFirstName) {
        this.maidFirstName = maidFirstName;
    }

    public String getMaidLastName() {

        return maidLastName;
    }

    public void setMaidLastName(String maidLastName) {

        this.maidLastName = maidLastName;
    }

    public String getMaidUserName() {

        return maidUserName;
    }

    public void setMaidUserName(String maidUserName) {
        this.maidUserName = maidUserName;
    }

    public String getMaidGender() {
        return maidGender;
    }

    public void setMaidGender(String maidGender) {
        this.maidGender = maidGender;
    }

    public String getMaidAge() {
        return maidAge;
    }

    public void setMaidAge(String maidAge) {
        this.maidAge = maidAge;
    }

    public String getMaidLocation() {
        return maidLocation;
    }

    public void setMaidLocation(String maidLocation) {
        this.maidLocation = maidLocation;
    }

    public String getMaidPhoneNumber() {
        return maidPhoneNumber;
    }

    public void setMaidPhoneNumber(String maidPhoneNumber) {
        this.maidPhoneNumber = maidPhoneNumber;
    }

    public String getMaidNID() {
        return maidNID;
    }

    public void setMaidNID(String maidNID) {
        this.maidNID = maidNID;
    }

    public String getMaidAddress() {
        return maidAddress;
    }

    public void setMaidAddress(String maidAddress) {
        this.maidAddress = maidAddress;
    }

    public String getMaidPassword() {
        return maidPassword;
    }

    public void setMaidPassword(String maidPassword) {

        this.maidPassword = maidPassword;
    }
}
