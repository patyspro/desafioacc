package com.desafio.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor {
    @Id
    private String cpf_cnpj;

    private String nome;

    private String email;

    private String cep;

    private Date data_nascimento;

    private String rg;

    public Fornecedor() {
    }

    public Fornecedor(String cpf_cnpj, String nome, String email, String cep, Date data_nascimento, String rg) {
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.data_nascimento = data_nascimento;
        this.rg = rg;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }



    @Override
    public String toString() {
        return "Fornecedor{" +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cep='" + cep + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", rg='" + rg + '\'' +
                '}';
    }
}
