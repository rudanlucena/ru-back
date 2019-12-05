package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Auxilio {

    @Id
    @GeneratedValue
    private long id;
    private boolean almoco;
    private boolean jantar;

    @OneToOne
    private Periodo periodo;

    public Auxilio() {
    }

    public boolean isAlmoco() {
        return almoco;
    }

    public void setAlmoco(boolean almoco) {
        this.almoco = almoco;
    }

    public boolean isJantar() {
        return jantar;
    }

    public void setJantar(boolean jantar) {
        this.jantar = jantar;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
