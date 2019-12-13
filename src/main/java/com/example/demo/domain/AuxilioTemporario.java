package com.example.demo.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class AuxilioTemporario {
    @Id
    @GeneratedValue
    private long id;
    private boolean almoco;
    private boolean jantar;
    private String inicio;
    private String fim;
    private String motivo;
    private String anexo;

    @OneToOne
    private Aluno aluno;

    private String status;

    public AuxilioTemporario() {
        this.status = "pendente";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
