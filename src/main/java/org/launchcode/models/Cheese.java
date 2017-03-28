package org.launchcode.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kevin on 3/22/2017.
 */
public class Cheese {

    // these annotations are for validation
    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
    private String description;

    private CheeseType type;

    private int cheeseId; // will be unique for each instance of cheese
    private static int nextId = 0; //static means this field will belong and be shared among all instances

    @NotNull
    @Min(1)
    @Max(5)
    private String rating;

    // constructor
    public Cheese(String name, String description) {
        this(); // says call the default constructor for the given class, it has to be the first line
        this.name = name;
        this.description = description;
    }

    // default or no-arg constructor
    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    // getters and setters
    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
