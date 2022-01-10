package com.tappyplanner.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/* Giovanni Brex created
 * on 1/4/2022 inside
 * the package -
 * com.tappyplanner.models */


@Entity
public class Task extends AbstractEntity{


    public Task(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }

    @Size(min = 3, max = 50)
    private String name;

    @Size(min = 3, max = 250 , message = "Description must be between 3 and 250 characters.")
    private String description;



    public Task() { }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
