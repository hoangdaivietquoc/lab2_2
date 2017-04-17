package com.polytech.business;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
@Entity
@Table(name = "POST")
public class Post implements Serializable {
    @Id
    @Column(name="idPost")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment in sql
    private  Long id;

    @Column(name="CONTENT")
    private String content;

    @Column(name="username")
    private String username;
    public Post() {}

    @Override
    public String toString() {
        return "idPost = "+id+" username "+username+" Post{" + "content= " + content +" }";
    }

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}