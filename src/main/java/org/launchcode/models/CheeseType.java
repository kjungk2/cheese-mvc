package org.launchcode.models;

/**
 * Created by Kevin on 3/25/2017.
 */
public enum CheeseType {

    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    private final String name;

    // constructor that has default access level
    CheeseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
