package br.com.estudo.estoquebasico.controller.v1.estoque.dto;

import br.com.estudo.estoquebasico.entidade.Estoque;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Representação do estoque de um produto", value = "Estoque")
public class EstoqueDTO {

    @Min(value = 0, message = "A quantidade deve ser no mínimo 0")
    @ApiModelProperty(required = true, value = "Quantidade de unidades em estoque")
    private Integer quantidade;

    @Min(value = 0, message = "A quantidade mínima deve ser pelo menos 0")
    @ApiModelProperty(required = true, value = "Valor mínimo para a quantidade de unidades em estoque do produto")
    private Integer quantidadeMinima;

    public EstoqueDTO(Estoque estoque) {
        this.quantidade = estoque.getQuantidade();
        this.quantidadeMinima = estoque.getQuantidadeMinima();
    }
}
