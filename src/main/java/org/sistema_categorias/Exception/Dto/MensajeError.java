package org.sistema_categorias.Exception.Dto;

import org.springframework.http.HttpStatus;

public class MensajeError {

    private HttpStatus httpStatus;
    private String mensaje;

    public MensajeError() {
    }

    public MensajeError(HttpStatus httpStatus, String mensaje) {
        this.httpStatus = httpStatus;
        this.mensaje = mensaje;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
