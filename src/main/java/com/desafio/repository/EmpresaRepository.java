package com.desafio.repository;

import com.desafio.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {

    @Query(value = "SELECT * FROM  tb_empresa t WHERE t.cnpj = ?1", nativeQuery = true)
    Empresa findByCnpj(String cnpj);

    @Query(value = "SELECT * FROM  tb_empresa t WHERE t.nome_fantasia LIKE %?1%", nativeQuery = true)
    List<Empresa> findByNome(String nome);

    @Modifying
    @Query(value = "DELETE FROM tb_empresa t WHERE t.cnpj = ?1", nativeQuery = true)
    void deleteByCnpj(String cnpj);
}
