package br.com.estudo.estoquebasico.controller.v1.erro;

import br.com.estudo.estoquebasico.controller.v1.erro.dto.ResponseErro;
import br.com.estudo.estoquebasico.excecao.ProdutoNaoEncontradoException;
import br.com.estudo.estoquebasico.utils.ErroUtils;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ErroController {
    @ExceptionHandler(value = ProdutoNaoEncontradoException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseErro produtoNaoEncontradoException(ProdutoNaoEncontradoException produtoNaoEncontradoException) {
        return new ResponseErro(Arrays.asList(produtoNaoEncontradoException.getMessage()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseErro methodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> erros = new ArrayList<>();
        for (FieldError fieldError : methodArgumentNotValidException.getFieldErrors()) {
            erros.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }
        return new ResponseErro(erros);
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseErro invalidFormatException(
            InvalidFormatException invalidFormatException) {
        List<String> erros = new ArrayList<>();
        erros.add(ErroUtils.getCampoErroInvalidFormatException(
                invalidFormatException) + ": O valor " + invalidFormatException
                .getValue() + " não é do tipo " + invalidFormatException.getTargetType().getName());
        return new ResponseErro(erros);
    }
}
