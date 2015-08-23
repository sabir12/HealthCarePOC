package com.synavos.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	public String dateOfBirth;
    public String weight;
    public String glucoseUnit;
    public String foodsLocale;
    public String locale;
    public String averageDailySteps;
    public String startDayOfWeek;
    public String timezone;
    public String avatar150;
    public String height;
    public String age;
    public String heightUnit;
    public String gender;
    public String waterUnit;
    public String strideLengthWalking;
    public String memberSince;
    public String weightUnit;
    public String offsetFromUTCMillis;
    public String avatar;
    public String waterUnitName;
    public String strideLengthRunning;
    public String fullName;
    public TopBadges[] topBadges;
    public String encodedId;
    public String distanceUnit;
    public String displayName;

    //Default Constructor
    public User() {
    }

    @JsonCreator
    public User(@JsonProperty("dateOfBirth") String dateOfBirth, @JsonProperty("weight") String weight, @JsonProperty("glucoseUnit") String glucoseUnit, @JsonProperty("foodsLocale") String foodsLocale, @JsonProperty("locale") String locale, @JsonProperty("averageDailySteps") String averageDailySteps, @JsonProperty("startDayOfWeek") String startDayOfWeek, @JsonProperty("timezone") String timezone, @JsonProperty("avatar150") String avatar150, @JsonProperty("height") String height, @JsonProperty("age") String age, @JsonProperty("heightUnit") String heightUnit, @JsonProperty("gender") String gender, @JsonProperty("waterUnit") String waterUnit, @JsonProperty("strideLengthWalking") String strideLengthWalking, @JsonProperty("memberSince") String memberSince, @JsonProperty("weightUnit") String weightUnit, @JsonProperty("offsetFromUTCMillis") String offsetFromUTCMillis, @JsonProperty("avatar") String avatar, @JsonProperty("waterUnitName") String waterUnitName, @JsonProperty("strideLengthRunning") String strideLengthRunning, @JsonProperty("fullName") String fullName, @JsonProperty("topBadges") TopBadges[] topBadges, @JsonProperty("encodedId") String encodedId, @JsonProperty("distanceUnit") String distanceUnit, @JsonProperty("displayName") String displayName) {
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.glucoseUnit = glucoseUnit;
        this.foodsLocale = foodsLocale;
        this.locale = locale;
        this.averageDailySteps = averageDailySteps;
        this.startDayOfWeek = startDayOfWeek;
        this.timezone = timezone;
        this.avatar150 = avatar150;
        this.height = height;
        this.age = age;
        this.heightUnit = heightUnit;
        this.gender = gender;
        this.waterUnit = waterUnit;
        this.strideLengthWalking = strideLengthWalking;
        this.memberSince = memberSince;
        this.weightUnit = weightUnit;
        this.offsetFromUTCMillis = offsetFromUTCMillis;
        this.avatar = avatar;
        this.waterUnitName = waterUnitName;
        this.strideLengthRunning = strideLengthRunning;
        this.fullName = fullName;
        this.topBadges = topBadges;
        this.encodedId = encodedId;
        this.distanceUnit = distanceUnit;
        this.displayName = displayName;
    }
	
	
}
