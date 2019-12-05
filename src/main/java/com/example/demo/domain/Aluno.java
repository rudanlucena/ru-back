package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Aluno {
	
	@Id
	private String uuid;
	private String nome;
	private String matricula;
	private String situacao;
	private String cota;
	private String senha;

	@OneToOne
	private Auxilio auxilio;

	public Aluno(String uuid, String nome, String matricula, String situacao, String cota) {
		this.uuid = uuid;
		this.nome = nome;
		this.matricula = matricula;
		this.situacao = situacao;
		this.cota = cota;
	}

	public Aluno() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getCota() {
		return cota;
	}

	public void setCota(String conta) {
		this.cota = conta;
	}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

	public Auxilio getAuxilio() {
		return auxilio;
	}

	public void setAuxilio(Auxilio auxilio) {
		this.auxilio = auxilio;
	}
}
