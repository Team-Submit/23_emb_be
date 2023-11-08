package com.example.emb.domain.auth.exception;

import com.example.emb.global.error.exception.EmbException;
import com.example.emb.global.error.exception.GlobalErrorCode;

public class RefreshTokenNotFoundException extends EmbException {

    public static final EmbException EXCEPTION = new RefreshTokenNotFoundException();

    public RefreshTokenNotFoundException() {
        super(GlobalErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
