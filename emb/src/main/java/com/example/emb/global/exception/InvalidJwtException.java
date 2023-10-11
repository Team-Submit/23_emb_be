package com.example.emb.global.exception;

import com.example.emb.global.error.exception.EmbException;
import com.example.emb.global.error.exception.GlobalErrorCode;

public class InvalidJwtException extends EmbException {

    public static final EmbException EXCEPTION = new InvalidJwtException();

    public InvalidJwtException() {
        super(GlobalErrorCode.INVALID_JWT);
    }
}
