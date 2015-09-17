package com.starkhorn.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by starkhorn on 9/17/2015.
 */
public class Crime {
    private UUID id;
    private String title;
    private Date date;
    private boolean solved;

    public Crime() {
        this.id = UUID.randomUUID();
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
