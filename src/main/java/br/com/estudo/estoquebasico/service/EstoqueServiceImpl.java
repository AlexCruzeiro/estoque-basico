package br.com.estudo.estoquebasico.service;

import br.com.estudo.estoquebasico.controller.v1.estoque.dto.RequestAlterarEstoque;
import br.com.estudo.estoquebasico.controller.v1.estoque.dto.ResponseConsultarEstoque;
import br.com.estudo.estoquebasico.dao.EstoqueDAO;
import br.com.estudo.estoquebasico.entidade.Estoque;
import br.com.estudo.estoquebasico.excecao.ProdutoNaoEncontradoException;
import br.com.estudo.estoquebasico.service.mapper.EstoqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueDAO estoqueDAO;

    @Override
    @Transactional
    public void alterarEstoque(RequestAlterarEstoque requestAlterarEstoque) throws ProdutoNaoEncontradoException {
        Estoque estoque = consultarEstoquePorIdProduto(requestAlterarEstoque.getIdProduto());
        estoque.setQuantidade(requestAlterarEstoque.getQuantidade());
        estoqueDAO.save(estoque);
    }

    @Override
    public ResponseConsultarEstoque consultarEstoque(Long idProduto) throws ProdutoNaoEncontradoException {
        Estoque estoque = consultarEstoquePorIdProduto(idProduto);
        return EstoqueMapper.fromEstoqueToResponseConsultarEstoque(estoque);
    }

    private Estoque consultarEstoquePorIdProduto(Long idProduto) throws ProdutoNaoEncontradoException {
        Optional<Estoque> estoque = estoqueDAO.findByProdutoId(idProduto);

        if (!estoque.isPresent()) {
            throw new ProdutoNaoEncontradoException(idProduto);
        }

        return estoque.get();
    }
}
