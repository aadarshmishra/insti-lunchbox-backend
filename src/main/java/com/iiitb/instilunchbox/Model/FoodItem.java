package com.iiitb.instilunchbox.Model;

import javax.persistence.*;

@Entity
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String fqty;
    private String fremark;
    private String ngoemail = "";
    private Integer status = 0;
    @ManyToOne
    private Lunchbox lunchbox;

    public FoodItem(Long id, String fname, String fqty, String fremark, String ngoemail, Integer status, Lunchbox lunchbox) {
        this.id = id;
        this.fname = fname;
        this.fqty = fqty;
        this.fremark = fremark;
        this.ngoemail = ngoemail;
        this.status = status;
        this.lunchbox = lunchbox;
    }

    public FoodItem(String fname, String fqty, String fremark, String ngoemail, Integer status, Lunchbox lunchbox) {
        this.fname = fname;
        this.fqty = fqty;
        this.fremark = fremark;
        this.ngoemail = ngoemail;
        this.status = status;
        this.lunchbox = lunchbox;
    }

    public FoodItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFqty() {
        return fqty;
    }

    public void setFqty(String fqty) {
        this.fqty = fqty;
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark;
    }

    public Lunchbox getLunchbox() {
        return lunchbox;
    }

    public void setLunchbox(Lunchbox lunchbox) {
        this.lunchbox = lunchbox;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNgoemail() {
        return ngoemail;
    }

    public void setNgoemail(String ngoemail) {
        this.ngoemail = ngoemail;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", fqty='" + fqty + '\'' +
                ", fremark='" + fremark + '\'' +
                ", lunchbox=" + lunchbox +
                '}';
    }
}
