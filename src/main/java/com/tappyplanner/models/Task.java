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

    @Size(min = 3, max = 250 , message = "Description must be between 3 and 250 characters.")
    private String description;

    @NotNull(message = "Date is required.")
    private Date date;

    //TODO implement functionality that connects with user email or phone api
    //     to send a reminder at a predetermined time


    @NotNull(message = "Please choose if you'd like to be reminded of this task.")
    private Boolean reminder;

    @ManyToOne
    @JoinColumn(name = "User_id")
    @NotNull(message = "Field required.")
    private User user;


    public Task() {

    }

    public Task(String description, Date date, Boolean reminder) {
        super();
        this.description = description;
        this.date = date;
        this.reminder = reminder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getReminder() {
        return reminder;
    }

    public void setReminder(Boolean reminder) {
        this.reminder = reminder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
