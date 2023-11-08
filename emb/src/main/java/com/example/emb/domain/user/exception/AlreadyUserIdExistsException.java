package com.example.emb.domain.user.exception;

import com.example.emb.global.error.exception.EmbException;
import com.example.emb.global.error.exception.GlobalErrorCode;

public class AlreadyUserIdExistsException extends EmbException {

    public static final EmbException EXCEPTION = new AlreadyUserIdExistsException();

    private AlreadyUserIdExistsException() {
        super(GlobalErrorCode.ALREADY_ID_EXISTS);
    }
}
