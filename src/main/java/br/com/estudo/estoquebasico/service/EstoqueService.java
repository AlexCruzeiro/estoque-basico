package br.com.estudo.estoquebasico.service;

import br.com.estudo.estoquebasico.controller.v1.estoque.dto.RequestAlterarEstoque;
import br.com.estudo.estoquebasico.controller.v1.estoque.dto.ResponseConsultarEstoque;
import br.com.estudo.estoquebasico.excecao.ProdutoNaoEncontradoException;

public interface EstoqueService {
    void alterarEstoque(RequestAlterarEstoque requestAlterarEstoque) throws ProdutoNaoEncontradoException;

    ResponseConsultarEstoque consultarEstoque(Long idProduto) throws ProdutoNaoEncontradoException;
}
