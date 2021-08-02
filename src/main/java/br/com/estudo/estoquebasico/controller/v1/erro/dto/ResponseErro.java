package br.com.estudo.estoquebasico.controller.v1.erro.dto;


import lombok.Getter;

import java.util.List;

@Getter
public class ResponseErro {

    private List<String> erros;

    public ResponseErro(List<String> erros) {
        this.erros = erros;
    }
}
