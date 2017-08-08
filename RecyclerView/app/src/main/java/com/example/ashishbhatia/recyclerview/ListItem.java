package com.example.ashishbhatia.recyclerview;

/**
 * Created by ashishbhatia on 08/08/17.
 */

public class ListItem {

    private String heading,description;

    public ListItem() {
    }

    public ListItem(String heading, String description) {
        this.heading = heading;
        this.description = description;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
