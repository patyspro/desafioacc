package com.desafio.repository;

import com.desafio.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {

    @Query(value = "SELECT * FROM  tb_fornecedor t WHERE t.cpf_cnpj = ?1", nativeQuery = true)
    Fornecedor findByCpf_Cnpj(String cpf_cnpj);

    @Query(value = "SELECT * FROM  tb_fornecedor t WHERE t.nome_fantasia LIKE %?1%", nativeQuery = true)
    Fornecedor findByNome(String nome_fantasia);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tb_fornecedor t WHERE t.cpf_cnpj = ?1", nativeQuery = true)
    void deleteByCpf_Cnpj(String cpf_cnpj);
}