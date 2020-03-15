package com.example.demo.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RegistroDiario {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate dataRegistro;

    @ManyToOne
    private Aluno aluno;
    private String refeicao;

    public RegistroDiario() {
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }
}
