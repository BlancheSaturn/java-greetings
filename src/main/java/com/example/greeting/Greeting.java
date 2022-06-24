package com.example.greeting;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
// this class is going to model what our greeting will look like
@Entity
public class Greeting {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String createdBy;
    private String greeting;
    private String originCountry;
    private LocalDateTime dateCreated;

    public Greeting() {
        this.dateCreated = LocalDateTime.now();;
    }

    public Greeting(String createdBy, String originCountry, String greeting) {
        this.createdBy = createdBy;
        this.originCountry = originCountry;
        this.greeting = greeting;
        //dateCreated should be the time Now
        this.dateCreated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getGreeting() {
        return greeting;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

}
