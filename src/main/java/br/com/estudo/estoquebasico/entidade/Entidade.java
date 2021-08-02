package br.com.estudo.estoquebasico.entidade;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.audit.setDataCriacao(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.audit.setUltimaAtualizacao(LocalDateTime.now());
    }
}
