package br.com.estudo.estoquebasico.controller.v1.estoque.dto;

import br.com.estudo.estoquebasico.entidade.Estoque;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Resposta de uma consulta de um estoque")
public class ResponseConsultarEstoque extends EstoqueDTO {

    @ApiModelProperty(required = true, value = "Id do produto que teve o seu estoque alterado")
    private Long idProduto;

    public ResponseConsultarEstoque(Estoque estoque) {
        super(estoque);
        this.idProduto = estoque.getProduto().getId();
    }
}