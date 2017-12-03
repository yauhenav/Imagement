package com.yauhenav.logic.dto;

import javax.persistence.*;

/**
 * Created by yauhenav on 30.9.17.
 */
@Entity
@Table(name = "users", schema = "imagement")
public class User {

    private int id;
    private String username;
    private String email;
    private String password;

    public User() {

    }

    public User (int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User (String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    @Basic
    @Column (name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "[Username: " + this.username + ", email: " + this.email + ", password: " + this.password + ", id No.: " + this.id + "]";
    }
}
