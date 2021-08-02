package br.com.estudo.estoquebasico.utils;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ErroUtils {

    public static String getCampoErroInvalidFormatException(InvalidFormatException invalidFormatException) {
        String campo = "";
        for (JsonMappingException.Reference reference : invalidFormatException.getPath()) {
            campo = campo.concat(campo.isEmpty() ? reference.getFieldName() : "." + reference.getFieldName());
        }

        return campo;
    }

}
