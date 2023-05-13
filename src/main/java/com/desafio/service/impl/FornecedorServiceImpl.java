package com.desafio.service.impl;


import com.desafio.model.Fornecedor;
import com.desafio.repository.FornecedorRepository;
import com.desafio.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor buscarPeloCpf_Cnpj(String cpf_cnpj) {
        return fornecedorRepository.findByCpf_Cnpj(cpf_cnpj);
    }

    @Override
    public Fornecedor buscarPeloNome(String nome_fantasia) {

        return  fornecedorRepository.findByNome(nome_fantasia);
    }

    @Override
    public Fornecedor registrar(Fornecedor fornecedor) {
        System.out.println("vim salvar");
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public void excluir(String cpf_cnj) {
        fornecedorRepository.deleteByCpf_Cnpj(cpf_cnj);

    }

    @Override
    public Fornecedor atualizar(Fornecedor fornecedor) {

        return fornecedorRepository.save(fornecedor) ;
    }
}
