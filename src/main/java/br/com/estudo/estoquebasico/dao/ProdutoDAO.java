package br.com.estudo.estoquebasico.dao;

import br.com.estudo.estoquebasico.entidade.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoDAO extends PagingAndSortingRepository<Produto, Long> {
}
