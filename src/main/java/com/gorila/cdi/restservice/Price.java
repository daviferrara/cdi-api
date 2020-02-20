package com.gorila.cdi.restservice;

import java.util.Date;

public class Price {
    public Date getDate() {
        return date;
    }

    public Price(Date date, double price) {
        this.date = date;
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;
}
