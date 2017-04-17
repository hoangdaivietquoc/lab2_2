package com.polytech.business;

import javax.persistence.*;

/**
 * Created by daivietquochoang on 16/04/2017.
 */
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name="idComment")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment in sql
    private  Long idComment;

    @Column(name="username")
    private String username;

    @Column(name="idPost")
    private Long idPost;

    @Column(name="content")
    private String content;

    public Comment(){}

    @Override
    public String toString() {
        return "idComment = "+idComment+" username = "+username+" idPost = "+idPost +" content = "+content;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
