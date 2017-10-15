package br.com.usuario.response;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessage {

    private List<String> errors = new ArrayList<>();

    public ErrorMessage () { }

    public ErrorMessage(String error) {
        this.errors.add(error);
    }

    public ErrorMessage(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
