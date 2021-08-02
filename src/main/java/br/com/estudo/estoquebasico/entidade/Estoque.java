package br.com.estudo.estoquebasico.entidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Estoque extends Entidade {

    @Column
    private Integer quantidade;

    @Column
    private Integer quantidadeMinima;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private Produto produto;

    public Estoque(Produto produto, Integer quantidade, Integer quantidadeMinima) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
    }
}
