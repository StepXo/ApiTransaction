package com.emazon.ApiTransaction.Infrastructure.ExeptionHandler;


import com.emazon.ApiTransaction.Domain.Exeption.InvalidItemIdException;
import com.emazon.ApiTransaction.Domain.Exeption.InvalidQuantityException;
import com.emazon.ApiTransaction.Domain.Exeption.TokenMalformationException;
import com.emazon.ApiTransaction.Domain.Exeption.UserNotFound;
import com.emazon.ApiTransaction.Infrastructure.Utils.InfraConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {


    //BadRequest
    @ExceptionHandler(TokenMalformationException.class)
    public ResponseEntity<Map<String, String>> tokeMalFormatException(
            TokenMalformationException tokenMalformationException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.TOKEN_FORMAT.getMessage()));
    }

    @ExceptionHandler(InvalidItemIdException.class)
    public ResponseEntity<Map<String, String>> invalidItemIdException(
            InvalidItemIdException invalidItemIdException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.INVALID_ITEM_ID.getMessage()));
    }

    @ExceptionHandler(InvalidQuantityException.class)
    public ResponseEntity<Map<String, String>> invalidQuantityException(
            InvalidQuantityException invalidQuantityException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.INVALID_QUANTITY.getMessage()));
    }

    //NotFound
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Map<String, String>> userNotFound(
            UserNotFound userNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }



}
