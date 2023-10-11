package com.example.emb.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EmbException extends RuntimeException {

    private final GlobalErrorCode errorCode;

}