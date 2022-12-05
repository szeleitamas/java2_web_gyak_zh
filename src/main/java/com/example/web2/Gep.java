package com.example.web2;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="gep")
public class Gep {
    @Id
    private int id;
    @Column(name="hely")
    private String hely;
    @Column(name="tipus")
    private String tipus;
    @Column(name="ipcim")
    private String ipcim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHely() {
        return hely;
    }

    public void setHely(String hely) {
        this.hely = hely;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getIpcim() {
        return ipcim;
    }

    public void setIpcim(String ipcim) {
        this.ipcim = ipcim;
    }
}
