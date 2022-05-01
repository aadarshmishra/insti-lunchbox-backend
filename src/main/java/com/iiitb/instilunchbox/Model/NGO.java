package com.iiitb.instilunchbox.Model;

import javax.persistence.*;

@Entity
public class NGO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ngoId;
    private String name;
    private String address;
    private String contact;
    private String email;
    private Integer status = 0;
    @OneToOne
    private User user;


    public NGO(Long id, String ngoId, String name, String address, String contact, String email, Integer status, User user) {
        this.id = id;
        this.ngoId = ngoId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.status = status;
        this.user = user;
    }

    public NGO(String ngoId, String name, String address, String contact, String email, Integer status, User user) {
        this.ngoId = ngoId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.status = status;
        this.user = user;
    }

    public NGO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNgoId() {
        return ngoId;
    }

    public void setNgoId(String ngoId) {
        this.ngoId = ngoId;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
