package br.com.usuario.exception;

import br.com.usuario.response.ErrorMessage;

public class CampanhaNotFoundException extends NotFoundException {

    private ErrorMessage errorMessage;

    public CampanhaNotFoundException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
