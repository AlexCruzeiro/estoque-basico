package br.com.estudo.estoquebasico.controller.v1.estoque;

import br.com.estudo.estoquebasico.controller.v1.estoque.dto.RequestAlterarEstoque;
import br.com.estudo.estoquebasico.controller.v1.estoque.dto.ResponseConsultarEstoque;
import br.com.estudo.estoquebasico.excecao.ProdutoNaoEncontradoException;
import br.com.estudo.estoquebasico.service.EstoqueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.estudo.estoquebasico.configuracao.SpringFoxConfig.TAG_ESTOQUE_CONTROLLER_V1;

@RestController
@RequestMapping("/api/v1")
@Validated
@Api(tags = {TAG_ESTOQUE_CONTROLLER_V1})
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PutMapping("/estoque")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Alterar o estoque de um produto")
    public void alterarEstoque(
            @RequestBody @Valid RequestAlterarEstoque requestAlterarEstoque) throws ProdutoNaoEncontradoException {
        this.estoqueService.alterarEstoque(requestAlterarEstoque);
    }

    @GetMapping("/estoque/{idProduto}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Consultar o estoque de um produto")
    public ResponseConsultarEstoque consultarEstoque(
            @PathVariable("idProduto") Long idProduto) throws ProdutoNaoEncontradoException {
        return this.estoqueService.consultarEstoque(idProduto);
    }
}
