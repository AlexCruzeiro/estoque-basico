package br.com.estudo.estoquebasico.excecao;

public class ProdutoNaoEncontradoException extends Exception {
    private Long idProduto;

    public ProdutoNaoEncontradoException(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    @Override
    public String getMessage() {
        return "O produto de id " + idProduto + " não existe.";
    }
}
