package com.snt.minijira.model;

import com.snt.minijira.enums.Difficulty;
import com.snt.minijira.enums.TimeConsuming;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String number;

    private String description;

    private String status;

    private String epicLink;

    private String component;
    private String assignedUser;
    @Enumerated
    private TimeConsuming timeConsuming;
    @Enumerated
    private Difficulty difficulty;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Ticket() {
    }

    public Ticket(Long id) {
        this.id = id;
    }

    public Ticket(Long id, String number, String description, String status, String epicLink, String component, String assignedUser, TimeConsuming timeConsuming, Difficulty difficulty) {
        this.id = id;
        this.number = number;
        this.description = description;
        this.status = status;
        this.epicLink = epicLink;
        this.component = component;
        this.assignedUser = assignedUser;
        this.timeConsuming = timeConsuming;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEpicLink() {
        return epicLink;
    }

    public void setEpicLink(String epicLink) {
        this.epicLink = epicLink;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public TimeConsuming getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(TimeConsuming timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", epicLink='" + epicLink + '\'' +
                ", component='" + component + '\'' +
                ", assignedUser='" + assignedUser + '\'' +
                ", timeConsuming=" + timeConsuming +
                ", difficulty=" + difficulty +
                ", user=" + user +
                '}';
    }
}
