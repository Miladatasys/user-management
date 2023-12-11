package com.javaev.usermanagement.model;
import jakarta.persistence.*;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator; 

@Entity
public class Phone {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String number;
    private String cityCode;
    private String countryCode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountrycode(String countryCode) {
        this.countryCode = countryCode;
    }
    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

}
