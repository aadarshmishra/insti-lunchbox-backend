package com.iiitb.instilunchbox.Model;

import javax.persistence.*;

@Entity
public class Lunchbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Institute institute;

    public Lunchbox(Long id, Institute institute) {
        this.id = id;
        this.institute = institute;
    }

    public Lunchbox(Institute institute) {
        this.institute = institute;
    }

    public Lunchbox() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "Lunchbox{" +
                "id=" + id +
                ", institute=" + institute +
                '}';
    }
}
