package com.example.emb.global.exception;

import com.example.emb.global.error.exception.EmbException;
import com.example.emb.global.error.exception.GlobalErrorCode;

public class ExpiredJwtException extends EmbException {

    public static final ExpiredJwtException EXCEPTION = new ExpiredJwtException();

    public ExpiredJwtException() {
        super(GlobalErrorCode.EXPIRED_JWT);
    }
}
