package br.com.estudo.estoquebasico.entidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produto extends Entidade {

    @Column
    private String descricao;

    @Column
    private BigDecimal valor;

    @Column
    private boolean ativo = true;

    @Column
    private LocalDateTime dataValidade;

    public Produto(String descricao, BigDecimal valor, LocalDateTime dataValidade) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataValidade = dataValidade;
    }
}
