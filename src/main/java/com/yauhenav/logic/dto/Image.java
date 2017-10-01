package com.yauhenav.logic.dto;

import javax.persistence.*;

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
    private int tag_id;
    private byte[] file;

    public Image () {

    }

    public Image (int id, String title, String description, int user_id, int tag_id, byte[] file) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
        this.tag_id = tag_id;
        this.file = file;
    }

    @Id
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

    @Basic
    @Column(name = "tag_id")
    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id (int tag_id) {
        this.tag_id = tag_id;
    }

    @Basic
    @Column(name = "file")
    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString () {
        return "[Image name: " + this.title + ", owner: " + this.user_id + ", tag: " + this.tag_id + ", id No.: " + this.id + "]";
    }

}
