package com.yauhenav.logic.dto;

import javax.persistence.*;

/**
 * Created by yauhenav on 1.10.17.
 */
@Entity
@Table(name = "tags", schema = "imagement")
public class Tag {

    private int id;
    private String tagword;

    public Tag () {

    }

    public Tag (int id, String tagword) {
        this.id = id;
        this.tagword = tagword;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tagword")
    public String getTagword() {
        return tagword;
    }

    public void setTagword(String tagword) {
        this.tagword = tagword;
    }

    @Override
    public String toString() {
        return "[Tag word: " + this.tagword + ", id No.: " + this.id + "]";
    }
}
