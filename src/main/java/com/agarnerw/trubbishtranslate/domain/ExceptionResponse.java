package com.agarnerw.trubbishtranslate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionResponse {
    private String code;
    private String exception;
    private String message;
}
