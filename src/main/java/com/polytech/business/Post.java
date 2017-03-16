package com.polytech.business;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
public class Post {

    private String content;

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                '}';
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
}