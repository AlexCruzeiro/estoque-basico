package br.com.estudo.estoquebasico.controller.v1.produto.dto;

import br.com.estudo.estoquebasico.entidade.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(description = "Resposta de um cadastro de produto")
public class ResponseInserirProduto {

    @ApiModelProperty(required = true, value = "Id do produto que que foi cadastrado")
    private Long idProduto;

    public ResponseInserirProduto(Produto produto) {
        this.idProduto = produto.getId();
    }
}
