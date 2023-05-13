package com.desafio.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_empresa")
public class Empresa {
    @Id
    private String cnpj;

    private String nome_fantasia;

    private String cep;

    @ManyToMany
    @JoinTable(
            name = "fornecedores_empresa",
            joinColumns = @JoinColumn(name = "cnpj"),
            inverseJoinColumns = @JoinColumn(name = "cpf_cnpj"))
    @JsonManagedReference
    @JsonIgnore
    List<Fornecedor> fornecedoresEmpresa;

    public Empresa(){

    }

    public Empresa(String cnpj, String nome_fantasia, String cep, List<Fornecedor> fornecedoresEmpresa) {
        this.cnpj = cnpj;
        this.nome_fantasia = nome_fantasia;
        this.cep = cep;
        this.fornecedoresEmpresa = fornecedoresEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Fornecedor> getFornecedoresEmpresa() {
        return fornecedoresEmpresa;
    }

    public void setFornecedoresEmpresa(List<Fornecedor> fornecedoresEmpresa) {
        this.fornecedoresEmpresa = fornecedoresEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                ", cnpj='" + cnpj + '\'' +
                ", nome_fantasia='" + nome_fantasia + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }


}
