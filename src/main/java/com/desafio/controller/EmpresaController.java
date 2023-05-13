package com.desafio.controller;

import com.desafio.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.desafio.service.EmpresaService;
import java.util.List;


@RestController
@RequestMapping("/empresas")
public class EmpresaController {

        @Autowired
        EmpresaService empresaService;

        @PostMapping()
        public ResponseEntity<Empresa> registrarEmpresa(@RequestBody Empresa empresa) {

                return ResponseEntity.ok(empresaService.registrarEmpresa(empresa));

        }

        @GetMapping("/nome/{nomefantasia}")
        public ResponseEntity<List<Empresa>> buscarPeloNome(@PathVariable String nomefantasia) {
                return ResponseEntity.ok(empresaService.buscarPeloNome(nomefantasia));


        }

        @PutMapping()
        public ResponseEntity<Empresa> atualizar(@RequestBody Empresa empresa) {
                ResponseEntity<Empresa> response = null;

                response = ResponseEntity.ok(empresaService.atualizar(empresa));

                return response;
        }

        @DeleteMapping("/cnpj/{cnpj}")
        public ResponseEntity<String> excluir(@PathVariable String cnpj) {
                ResponseEntity<String> response = null;

                if (empresaService.buscarPeloCnpj(cnpj).getCnpj().equals(cnpj)) {
                        empresaService.excluir(cnpj);
                        response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Excluído");
                } else {
                        response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }

                return response;
        }

        @GetMapping
        public ResponseEntity<List<Empresa>> buscarTodos() {
                return ResponseEntity.ok(empresaService.buscarTodos());
        }


        @GetMapping("/cnpj/{cnpj}")
        public ResponseEntity<Empresa> buscarPeloCnpj(@PathVariable String cnpj) {
                ResponseEntity<Empresa> response = null;
                try{
                        Empresa empresa = empresaService.buscarPeloCnpj(cnpj);
                        if (empresa.getCnpj().equals(cnpj)){
                                response = ResponseEntity.ok(empresa);
                        };

                }catch (Exception e){
                        response =  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }

                return response;
        }
}