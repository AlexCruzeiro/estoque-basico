package br.com.estudo.estoquebasico.controller.v1.produto.dto;

import br.com.estudo.estoquebasico.entidade.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Representação de um cadastro de produto", value = "Produto")
public class ProdutoDTO {

    @NotEmpty(message = "A descrição não pode ser vazia")
    @NotNull(message = "A descrição não pode ser nula")
    @ApiModelProperty(required = true, value = "Descrição do produto")
    private String descricao;

    @Min(value = 1, message = "O valor mínimo é 1")
    @ApiModelProperty(required = true, value = "Valor monetário do produto")
    private BigDecimal valor;

    @NotNull(message = "O campo ativo não pode ser nulo")
    @ApiModelProperty(required = true, value = "Valor que determina se o produto está ativo ou não")
    private boolean ativo;

    @ApiModelProperty(value = "Data de validade do produto")
    private LocalDateTime dataValidade;

    public ProdutoDTO(Produto produto) {
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.dataValidade = produto.getDataValidade();
        this.ativo = produto.isAtivo();
    }
}

