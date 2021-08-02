package br.com.estudo.estoquebasico.controller.v1.produto.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(description = "Resposta de uma listagem de produtos")
public class ResponseListarProdutos {

    @ApiModelProperty(required = true, value = "Lista de produtos")
    private List<ResponseConsultarProduto> produtos;

    @ApiModelProperty(required = true, value = "Número da página consultada")
    private Integer pagina;

    public ResponseListarProdutos(List<ResponseConsultarProduto> produtos, Integer pagina) {
        this.produtos = produtos;
        this.pagina = pagina;
    }
}
