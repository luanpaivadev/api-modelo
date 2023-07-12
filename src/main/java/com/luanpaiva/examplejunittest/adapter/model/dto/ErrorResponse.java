package com.luanpaiva.examplejunittest.adapter.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ErrorResponse {

    @Schema(example = "404")
    private String code;
    @Schema(example = "Recurso com id 1, não encontrado.")
    private String message;
    private String detail;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(Integer code, String message) {
        this.code = String.valueOf(code);
        this.message = message;
    }

    public ErrorResponse(String code, String message, String detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public ErrorResponse(Integer code, String message, String detail) {
        this.code = String.valueOf(code);
        this.message = message;
        this.detail = detail;
    }

}
