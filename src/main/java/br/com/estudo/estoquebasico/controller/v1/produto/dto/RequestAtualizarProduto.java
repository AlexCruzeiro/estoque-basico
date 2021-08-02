package br.com.estudo.estoquebasico.controller.v1.produto.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Requisição para atualização de um cadastro de produto")
public class RequestAtualizarProduto extends ProdutoDTO {

    @NotNull(message = "O id do produto não pode ser nulo")
    @ApiModelProperty(required = true, value = "Id do produto que terá o seu cadastro alterado")
    private Long id;
}
