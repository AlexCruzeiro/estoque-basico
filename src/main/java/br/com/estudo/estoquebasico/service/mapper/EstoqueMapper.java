package br.com.estudo.estoquebasico.service.mapper;

import br.com.estudo.estoquebasico.controller.v1.estoque.dto.ResponseConsultarEstoque;
import br.com.estudo.estoquebasico.controller.v1.produto.dto.RequestInserirProduto;
import br.com.estudo.estoquebasico.entidade.Estoque;
import br.com.estudo.estoquebasico.entidade.Produto;

public class EstoqueMapper {
    public static Estoque fromRequestInserirProdutoToEstoque(Produto produto,
                                                             RequestInserirProduto requestInserirProduto) {
        return new Estoque(produto, requestInserirProduto.getEstoque().getQuantidade(),
                requestInserirProduto.getEstoque().getQuantidadeMinima());
    }

    public static ResponseConsultarEstoque fromEstoqueToResponseConsultarEstoque(Estoque estoque) {
        return new ResponseConsultarEstoque(estoque);
    }
}
