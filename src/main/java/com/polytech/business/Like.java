package com.polytech.business;

import javax.persistence.*;

/**
 * Created by daivietquochoang on 16/04/2017.
 */
@Entity
@Table(name = "tbLike")
public class Like {
    @Id
    @Column(name="idLike")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment in sql
    private  Long id;



    @Column(name="username")
    private String username;

    @Column(name="idPost")
    private Long idPost;

    public Like(){}

    @Override
    public String toString() {
        return "id = "+id+"---username = "+username+"----idPost="+idPost;
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

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }
}
