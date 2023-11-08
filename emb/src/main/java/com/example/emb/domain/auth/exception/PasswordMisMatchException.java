package com.example.emb.domain.auth.exception;

import com.example.emb.global.error.exception.EmbException;
import com.example.emb.global.error.exception.GlobalErrorCode;

public class PasswordMisMatchException extends EmbException {

    public static final EmbException EXCEPTION = new PasswordMisMatchException();

    public PasswordMisMatchException() {
        super(GlobalErrorCode.PASSWORD_MISMATCH);
    }
}
