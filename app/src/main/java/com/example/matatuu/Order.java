package com.example.matatuu;

import android.widget.EditText;



public class Order {
    private String from,to,departure,payment;

    public Order(String from, String to, String departure, String payment) {
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.payment = payment;
    }

    public Order() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTo() {
        return to;
    }

    public String getDeparture() {
        return departure;
    }

    public String getPayment() {
        return payment;
    }

}
