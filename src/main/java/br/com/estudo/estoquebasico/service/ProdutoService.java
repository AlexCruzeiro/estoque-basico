package br.com.estudo.estoquebasico.service;

import br.com.estudo.estoquebasico.controller.v1.produto.dto.*;
import br.com.estudo.estoquebasico.excecao.ProdutoNaoEncontradoException;

public interface ProdutoService {

    ResponseInserirProduto inserirProduto(RequestInserirProduto requestInserirProduto);

    ResponseConsultarProduto consultarProduto(Long idProduto) throws ProdutoNaoEncontradoException;

    ResponseListarProdutos listarProdutos(Integer pagina);

    void atualizarProduto(RequestAtualizarProduto requestAtualizarProduto) throws ProdutoNaoEncontradoException;
}
