package br.com.estudo.estoquebasico.service;

import br.com.estudo.estoquebasico.controller.v1.produto.dto.*;
import br.com.estudo.estoquebasico.dao.EstoqueDAO;
import br.com.estudo.estoquebasico.dao.ProdutoDAO;
import br.com.estudo.estoquebasico.entidade.Estoque;
import br.com.estudo.estoquebasico.entidade.Produto;
import br.com.estudo.estoquebasico.excecao.ProdutoNaoEncontradoException;
import br.com.estudo.estoquebasico.service.mapper.EstoqueMapper;
import br.com.estudo.estoquebasico.service.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final Integer TAMANHO_PAGINA = 10;

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private EstoqueDAO estoqueDAO;

    @Override
    @Transactional
    public ResponseInserirProduto inserirProduto(RequestInserirProduto requestInserirProduto) {
        Produto produto = salvarProduto(requestInserirProduto);
        salvarEstoque(produto, requestInserirProduto);
        return ProdutoMapper.fromProdutoToResponseInserirProduto(produto);
    }

    @Override
    public ResponseConsultarProduto consultarProduto(Long idProduto) throws ProdutoNaoEncontradoException {
        Produto produto = consultarProdutoPorId(idProduto);

        return ProdutoMapper.fromProdutoToResponseConsultarProduto(produto);
    }

    @Override
    public ResponseListarProdutos listarProdutos(Integer pagina) {
        Page<Produto> produtos = produtoDAO.findAll(PageRequest.of(pagina, TAMANHO_PAGINA));
        return ProdutoMapper
                .fromListaProdutoToResponseListarProdutos(produtos.get().collect(Collectors.toList()), pagina);
    }

    @Override
    @Transactional
    public void atualizarProduto(RequestAtualizarProduto requestAtualizarProduto) throws ProdutoNaoEncontradoException {
        Produto produto = consultarProdutoPorId(requestAtualizarProduto.getId());
        produto.setAtivo(requestAtualizarProduto.isAtivo());
        produto.setDataValidade(requestAtualizarProduto.getDataValidade());
        produto.setDescricao(requestAtualizarProduto.getDescricao());
        produto.setValor(requestAtualizarProduto.getValor());
        produtoDAO.save(produto);
    }

    private Produto salvarProduto(RequestInserirProduto requestInserirProduto) {
        Produto produto = ProdutoMapper.fromRequestInserirProdutoToProduto(requestInserirProduto);
        return produtoDAO.save(produto);
    }

    private void salvarEstoque(Produto produto, RequestInserirProduto requestInserirProduto) {
        Estoque estoque = EstoqueMapper.fromRequestInserirProdutoToEstoque(produto, requestInserirProduto);
        estoqueDAO.save(estoque);
    }

    private Produto consultarProdutoPorId(Long id) throws ProdutoNaoEncontradoException {
        Optional<Produto> produto = produtoDAO.findById(id);

        if (!produto.isPresent()) {
            throw new ProdutoNaoEncontradoException(id);
        }

        return produto.get();
    }
}
