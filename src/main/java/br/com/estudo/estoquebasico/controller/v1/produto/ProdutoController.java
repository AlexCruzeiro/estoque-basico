package br.com.estudo.estoquebasico.controller.v1.produto;


import br.com.estudo.estoquebasico.controller.v1.produto.dto.*;
import br.com.estudo.estoquebasico.excecao.ProdutoNaoEncontradoException;
import br.com.estudo.estoquebasico.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.estudo.estoquebasico.configuracao.SpringFoxConfig.TAG_PRODUTO_CONTROLLER_V1;

@RestController
@RequestMapping("/api/v1")
@Validated
@Api(tags = {TAG_PRODUTO_CONTROLLER_V1})
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastrar um produto")
    public ResponseInserirProduto inserirProduto(@RequestBody @Valid RequestInserirProduto requestInserirProduto) {
        return this.produtoService.inserirProduto(requestInserirProduto);
    }

    @GetMapping("/produto/{idProduto}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Consultar um produto")
    public ResponseConsultarProduto consultarProduto(
            @PathVariable("idProduto") Long idProduto) throws ProdutoNaoEncontradoException {
        return this.produtoService.consultarProduto(idProduto);
    }

    @GetMapping("/produto")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Listar todos os produtos com paginação")
    public ResponseListarProdutos listarProdutos(@RequestParam("pagina") Integer pagina) {
        return this.produtoService.listarProdutos(pagina);
    }

    @PutMapping("/produto")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualizar o cadastro de um produto")
    public void atualizarProduto(
            @RequestBody RequestAtualizarProduto requestAtualizarProduto) throws ProdutoNaoEncontradoException {
        this.produtoService.atualizarProduto(requestAtualizarProduto);
    }
}
