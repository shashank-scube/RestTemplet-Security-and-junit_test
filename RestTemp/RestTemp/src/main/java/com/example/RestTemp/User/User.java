package com.example.RestTemp.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String fname;

    String lname;
    String cvv;
    String card_number;
    String expire_data;
    public User() {
    }
    public User(Long id) {
        this.id = id;
    }

    public User(String fname, String lname, String cvv, String card_number, String expire_data) {
        this.fname = fname;
        this.lname = lname;
        this.cvv = cvv;
        this.card_number = card_number;
        this.expire_data = expire_data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getExpire_data() {
        return expire_data;
    }

    public void setExpire_data(String expire_data) {
        this.expire_data = expire_data;
    }
}
