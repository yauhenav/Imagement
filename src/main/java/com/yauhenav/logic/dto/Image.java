package com.yauhenav.logic.dto;

import javax.persistence.*;
import java.io.InputStream;
import java.sql.Blob;

/**
 * Created by yauhenav on 1.10.17.
 */
@Entity
@Table(name = "images", schema = "imagement")
public class Image {

    private int id;
    private String title;
    private String description;
    private int user_id;
    private byte[] file;

    public Image () {

    }

    public Image (int id, String title, String description, int user_id, byte[] file) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
        this.file = file;
    }

    public Image (String title, String description, int user_id, byte[] file) {

        this.title = title;
        this.description = description;
        this.user_id = user_id;
        this.file = file;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "user_id")
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Lob
    @Column (name = "file")
    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString () {
        return "[Image name: " + this.title + ", owner: " + this.user_id + ", tag: " + ", id No.: " + this.id + "]";
    }

}
