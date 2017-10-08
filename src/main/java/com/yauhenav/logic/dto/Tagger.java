package com.yauhenav.logic.dto;

import javax.persistence.*;

/**
 * Created by yauhenav on 8.10.17.
 */
@Entity
@Table(name = "taggers", schema = "imagement")
public class Tagger {

    private int id;
    private int image_id;
    private int tag_id;

    public Tagger() {

    }

    public Tagger (int id, int image_id, int tag_id) {
        this.id = id;
        this.image_id = image_id;
        this.tag_id = tag_id;
    }

    @Id
    @Column (name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "image_id")
    public int getImage_id() {
        return image_id;
    }

    public void setImage_id (int image_id) {
        this.image_id = image_id;
    }

    @Basic
    @Column(name = "tag_id")
    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }
}
