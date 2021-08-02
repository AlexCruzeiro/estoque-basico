package br.com.estudo.estoquebasico.controller.v1.produto.dto;

import br.com.estudo.estoquebasico.controller.v1.estoque.dto.EstoqueDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Requisição para o cadastro de um novo produto")
public class RequestInserirProduto {

    @Valid
    private ProdutoDTO produto;
    @Valid
    private EstoqueDTO estoque;

}
