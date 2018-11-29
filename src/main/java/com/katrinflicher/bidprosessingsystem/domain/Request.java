package com.katrinflicher.bidprosessingsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private Double bid;
    private Date date;
    private String accept = "Not Defined";

    public Request() {
    }

    public Request(String text, Double bid, Date data) {
        this.text = text;
        this.bid = bid;
        //this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

   /* public Data getData() {
        return date;
    }

    public void setData(Data date) {
        this.date = date;
    }*/

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }
}
