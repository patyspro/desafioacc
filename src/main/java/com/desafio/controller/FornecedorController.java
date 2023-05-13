package com.desafio.controller;

import com.desafio.model.Fornecedor;
import com.desafio.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping()
    public ResponseEntity<Fornecedor> registrar(@RequestBody Fornecedor fornecedor) {
        System.out.println(fornecedor);
        return ResponseEntity.ok(fornecedorService.registrar(fornecedor));

    }

    @GetMapping("/{nome}")
    public ResponseEntity<Fornecedor> buscarPeloNome(@PathVariable String nome) {
        Fornecedor fornecedor = fornecedorService.buscarPeloNome(nome);

        return ResponseEntity.ok(fornecedor);

    }

    @PutMapping()
    public ResponseEntity<Fornecedor> atualizar(@RequestBody Fornecedor fornecedor) {
        ResponseEntity<Fornecedor> response = null;

        response = ResponseEntity.ok(fornecedorService.atualizar(fornecedor));

        return response;
    }

    @DeleteMapping("/cpf_cnpj/{cpf_cnpj}")
    public ResponseEntity<String> deletarPorCNPJ(@PathVariable String cpf_cnpj) {
        ResponseEntity<String> response = null;

        if (fornecedorService.buscarPeloCpf_Cnpj(cpf_cnpj).getCpf_cnpj().equals(cpf_cnpj)) {
            fornecedorService.excluir(cpf_cnpj);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Excluído");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }


    @GetMapping
    public ResponseEntity<List<Fornecedor>> buscarTodos() {
        return ResponseEntity.ok(fornecedorService.buscarTodos());
    }


    @GetMapping("/cpf_cnpj/{cpf_cnpj}")
    public ResponseEntity<Fornecedor> buscarPeloCnpj(@PathVariable String cpf_cnpj) {
        ResponseEntity<Fornecedor> response = null;

        if (fornecedorService.buscarPeloCpf_Cnpj(cpf_cnpj).getCpf_cnpj().equals(cpf_cnpj)) {
            response = ResponseEntity.ok(fornecedorService.buscarPeloCpf_Cnpj(cpf_cnpj));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
}
