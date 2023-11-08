package com.example.emb.global.exception;

import com.example.emb.global.error.exception.EmbException;
import com.example.emb.global.error.exception.GlobalErrorCode;

public class UserNotFoundException extends EmbException {

    public static final EmbException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(GlobalErrorCode.USER_NOT_FOUND);
    }
}
