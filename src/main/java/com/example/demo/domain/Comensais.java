package com.example.demo.domain;

import java.time.LocalDate;

public class Comensais {
    private String datax;
    private int almoco;
    private int jantar;

    public Comensais(String datax, int almoco, int jantar) {
        this.datax = datax;
        this.almoco = almoco;
        this.jantar = jantar;
    }

    public Comensais() {
    }

    public String getDatax() {
        return datax;
    }

    public void setDatax(String datax) {
        this.datax = datax;
    }

    public int getAlmoco() {
        return almoco;
    }

    public void setAlmoco(int almoco) {
        this.almoco = almoco;
    }

    public int getJantar() {
        return jantar;
    }

    public void setJantar(int jantar) {
        this.jantar = jantar;
    }
}
