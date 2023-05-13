package com.desafio.service;

import com.desafio.model.Empresa;

import java.util.List;
import java.util.Optional;


public interface EmpresaService {

    public List<Empresa> buscarTodos();

    public Empresa buscarPeloCnpj (String cnpj);

    public List<Empresa> buscarPeloNome(String nome_fantasia);

    public Empresa registrarEmpresa (Empresa empresa);

    public default void excluir(String cnpj) {

    }

    public Empresa atualizar(Empresa empresa);

}
