package br.com.estudo.estoquebasico.controller.v1.estoque.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Requisição para alteração do estoque")
public class RequestAlterarEstoque {

    @Min(value = 0, message = "A quantidade deve ser no mínimo 0")
    @ApiModelProperty(required = true, value = "Quantidade de unidades em estoque")
    private Integer quantidade;

    @NotNull(message = "O id do produto não pode ser nulo")
    @ApiModelProperty(required = true, value = "Id do produto que terá o seu estoque alterado")
    private Long idProduto;

}
