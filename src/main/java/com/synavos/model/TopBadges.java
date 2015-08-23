package com.synavos.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class TopBadges {
    public String image75px;
    public String earnedMessage;
    public String shareImage640px;
    public String dateTime;
    public String image50px;
    public String badgeGradientEndColor;
    public String timesAchieved;
    public String mobileDescription;
    public String marketingDescription;
    public String category;
    public String shortDescription;
    public String badgeGradientStartColor;
    public String description;
    public String name;
    public String image125px;
    public String value;
    public String shareText;
    public String[] cheers;
    public String shortName;
    public String encodedId;
    public String image300px;
    public String badgeType;
    public String image100px;
    public String unit;

    //Default Constructor
    public TopBadges() {
    }

    @JsonCreator
    public TopBadges(@JsonProperty("image75px") String image75px, @JsonProperty("earnedMessage") String earnedMessage, @JsonProperty("shareImage640px") String shareImage640px, @JsonProperty("dateTime") String dateTime, @JsonProperty("image50px") String image50px, @JsonProperty("badgeGradientEndColor") String badgeGradientEndColor, @JsonProperty("timesAchieved") String timesAchieved, @JsonProperty("mobileDescription") String mobileDescription, @JsonProperty("marketingDescription") String marketingDescription, @JsonProperty("category") String category, @JsonProperty("shortDescription") String shortDescription, @JsonProperty("badgeGradientStartColor") String badgeGradientStartColor, @JsonProperty("description") String description, @JsonProperty("name") String name, @JsonProperty("image125px") String image125px, @JsonProperty("value") String value, @JsonProperty("shareText") String shareText, @JsonProperty("cheers") String[] cheers, @JsonProperty("shortName") String shortName, @JsonProperty("encodedId") String encodedId, @JsonProperty("image300px") String image300px, @JsonProperty("badgeType") String badgeType, @JsonProperty("image100px") String image100px, @JsonProperty("unit") String unit) {
        this.image75px = image75px;
        this.earnedMessage = earnedMessage;
        this.shareImage640px = shareImage640px;
        this.dateTime = dateTime;
        this.image50px = image50px;
        this.badgeGradientEndColor = badgeGradientEndColor;
        this.timesAchieved = timesAchieved;
        this.mobileDescription = mobileDescription;
        this.marketingDescription = marketingDescription;
        this.category = category;
        this.shortDescription = shortDescription;
        this.badgeGradientStartColor = badgeGradientStartColor;
        this.description = description;
        this.name = name;
        this.image125px = image125px;
        this.value = value;
        this.shareText = shareText;
        this.cheers = cheers;
        this.shortName = shortName;
        this.encodedId = encodedId;
        this.image300px = image300px;
        this.badgeType = badgeType;
        this.image100px = image100px;
        this.unit = unit;
    }
}
