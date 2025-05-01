package br.org.serratec.projeto;

import java.time.LocalDate;


public abstract class Pessoa {
    private String nome;
    private int cpf;
    private LocalDate dataNascimento;

    public Pessoa(String nome, int cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
