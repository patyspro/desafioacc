package com.desafio.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_empresa")
public class Empresa {
    @Id
    private String cnpj;

    private String nome_fantasia;

    private String cep;

    public Empresa(){

    }

    public Empresa(String cnpj, String nome_fantasia, String cep, Set<Fornecedor> fornecedores_empresas) {
        this.cnpj = cnpj;
        this.nome_fantasia = nome_fantasia;
        this.cep = cep;
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

    @Override
    public String toString() {
        return "Empresa{" +
                ", cnpj='" + cnpj + '\'' +
                ", nome_fantasia='" + nome_fantasia + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }


}
