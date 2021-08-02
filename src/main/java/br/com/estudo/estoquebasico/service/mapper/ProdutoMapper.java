package br.com.estudo.estoquebasico.service.mapper;

import br.com.estudo.estoquebasico.controller.v1.produto.dto.*;
import br.com.estudo.estoquebasico.entidade.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapper {
    public static Produto fromRequestInserirProdutoToProduto(RequestInserirProduto requestInserirProduto) {
        return new Produto(requestInserirProduto.getProduto().getDescricao(),
                requestInserirProduto.getProduto().getValor(),
                requestInserirProduto.getProduto().getDataValidade());
    }

    public static ResponseInserirProduto fromProdutoToResponseInserirProduto(Produto produto) {
        return new ResponseInserirProduto(produto);
    }

    public static ResponseConsultarProduto fromProdutoToResponseConsultarProduto(Produto produto) {
        return new ResponseConsultarProduto(produto);
    }

    public static ResponseListarProdutos fromListaProdutoToResponseListarProdutos(List<Produto> produtos,
                                                                                  Integer pagina) {
        List<ResponseConsultarProduto> produtosResponse = new ArrayList<>();
        for (Produto produto : produtos) {
            produtosResponse.add(new ResponseConsultarProduto(produto));
        }
        return new ResponseListarProdutos(produtosResponse, pagina);
    }
}
