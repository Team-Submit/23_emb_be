package com.example.emb.domain.manager.exception;

import com.example.emb.global.error.exception.EmbException;
import com.example.emb.global.error.exception.GlobalErrorCode;

public class AlreadyManagerExistException extends EmbException {

    public static final EmbException EXCEPTION = new AlreadyManagerExistException();

    private AlreadyManagerExistException() {
        super(GlobalErrorCode.ALREADY_ID_EXISTS);
    }
}
