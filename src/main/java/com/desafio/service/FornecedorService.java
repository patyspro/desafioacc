package com.desafio.service;


import com.desafio.model.Fornecedor;
import java.util.List;

public interface FornecedorService {

    public List<Fornecedor> buscarTodos();

    public  Fornecedor buscarPeloCpf_Cnpj(String cpf_cnpj);

    public Fornecedor buscarPeloNome(String nome);

    public Fornecedor registrar(Fornecedor fornecedor);

    public void excluir(String cnpj);

    public Fornecedor atualizar(Fornecedor fornecedor);
}
