package com.example.web2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="telepites")
public class Telepites {
    @Id
    private int id;
    @Column(name="verzio")
    private String verzio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVerzio() {
        return verzio;
    }

    public void setVerzio(String verzio) {
        this.verzio = verzio;
    }
}
