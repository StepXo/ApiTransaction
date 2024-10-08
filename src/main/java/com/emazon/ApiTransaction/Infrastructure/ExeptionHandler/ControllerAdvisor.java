package com.emazon.ApiTransaction.Infrastructure.ExeptionHandler;


import com.emazon.ApiTransaction.Domain.Exeption.InvalidItemIdExeption;
import com.emazon.ApiTransaction.Domain.Exeption.InvalidQuantityExeption;
import com.emazon.ApiTransaction.Domain.Exeption.TokenIlegalFormatExeption;
import com.emazon.ApiTransaction.Domain.Exeption.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";


    //BadRequest
    @ExceptionHandler(TokenIlegalFormatExeption.class)
    public ResponseEntity<Map<String, String>> tokenIlegalFormatExeption(
            TokenIlegalFormatExeption tokenIlegalFormatExeption) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.TOKEN_FORMAT.getMessage()));
    }

    @ExceptionHandler(InvalidItemIdExeption.class)
    public ResponseEntity<Map<String, String>> invalidItemIdExeption(
            InvalidItemIdExeption invalidItemIdExeption) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INVALID_ITEM_ID.getMessage()));
    }

    @ExceptionHandler(InvalidQuantityExeption.class)
    public ResponseEntity<Map<String, String>> invalidQuantityExeption(
            InvalidQuantityExeption invalidQuantityExeption) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INVALID_QUANTITY.getMessage()));
    }

    //NotFound
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Map<String, String>> userNotFound(
            UserNotFound userNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }



}
