package com.synavos.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sajjadpervaiz on 17/08/2015.
 */

public class Profile {

    public User user;

    public Profile() {
    }

    @JsonCreator
    public Profile(@JsonProperty("user") User user) {
        this.user = user;
    }

    
    @Override
    public String toString() {
        return "ClassPojo [user = " + user + "]";
    }
}
