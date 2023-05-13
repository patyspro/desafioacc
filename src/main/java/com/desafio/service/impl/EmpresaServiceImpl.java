package com.desafio.service.impl;

import com.desafio.model.Empresa;
import com.desafio.repository.EmpresaRepository;
import com.desafio.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private  EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> buscarTodos() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa buscarPeloCnpj(String cnpj) {

        return empresaRepository.findByCnpj(cnpj);
    }

    @Override
    public List<Empresa> buscarPeloNome(String nome) {
        return empresaRepository.findByNome(nome);
    }

    @Override
    public Empresa registrarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa) ;
    }

    @Override
    public void excluir(String cnpj) {
        empresaRepository.deleteByCnpj(cnpj);
    }

    @Override
    public Empresa atualizar(Empresa empresa) {
        return empresaRepository.save(empresa);

    }
}
