package br.com.estudo.estoquebasico.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class Audit {

    @Column(name = "ultima_atualizacao")
    protected LocalDateTime ultimaAtualizacao;

    @Column(name = "data_criacao")
    protected LocalDateTime dataCriacao;

}
