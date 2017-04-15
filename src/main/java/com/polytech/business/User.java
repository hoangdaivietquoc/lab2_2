package com.polytech.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by daivietquochoang on 14/04/2017.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="ENABLED")
    private Boolean enabled;

    public User(){
       this.enabled=true;
    }

    @Override
    public String toString() {
        return "username = "+this.username+" and password = "+this.password+" and enabled ="+enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
