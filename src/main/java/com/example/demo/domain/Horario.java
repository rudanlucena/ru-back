package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Horario {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Almoco almoco;
    @OneToOne(cascade = CascadeType.ALL)
    private Jantar jantar;

    public Horario(long id, Almoco almoco, Jantar jantar) {
        this.id = id;
        this.almoco = almoco;
        this.jantar = jantar;
    }

    public Horario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Almoco getAlmoco() {
        return almoco;
    }

    public void setAlmoco(Almoco almoco) {
        this.almoco = almoco;
    }

    public Jantar getJantar() {
        return jantar;
    }

    public void setJantar(Jantar jantar) {
        this.jantar = jantar;
    }
}
