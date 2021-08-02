package br.com.estudo.estoquebasico.controller.v1.produto.dto;

import br.com.estudo.estoquebasico.entidade.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ApiModel(description = "Resposta de uma consulta de um cadastro de produto")
public class ResponseConsultarProduto extends ProdutoDTO {

    @ApiModelProperty(required = true, value = "Id do produto")
    private Long id;

    public ResponseConsultarProduto(Produto produto) {
        super(produto);
        this.id = produto.getId();
    }
}
