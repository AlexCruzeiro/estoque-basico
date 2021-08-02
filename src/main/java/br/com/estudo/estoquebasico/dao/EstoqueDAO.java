package br.com.estudo.estoquebasico.dao;

import br.com.estudo.estoquebasico.entidade.Estoque;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EstoqueDAO extends PagingAndSortingRepository<Estoque, Long> {
    Optional<Estoque> findByProdutoId(Long produtoId);
}
