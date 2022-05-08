package com.iiitb.instilunchbox.Model;

import javax.persistence.*;

@Entity
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Integer contact;
    private String email;
    private Integer status = 0;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Institute() {
    }

    public Institute(Long id, String name, String address, Integer contact, String email, Integer status, User user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.status = status;
        this.user = user;
    }

    public Institute(String name, String address, Integer contact, String email, Integer status, User user) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }
}
