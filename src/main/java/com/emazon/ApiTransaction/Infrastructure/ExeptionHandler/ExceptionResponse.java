package com.emazon.ApiTransaction.Infrastructure.ExeptionHandler;


public enum ExceptionResponse {
    TOKEN_FORMAT("Ensure the JWT token is valid and provided."),
    USER_NOT_FOUND("No user was found"),
    INVALID_ITEM_ID("Item ID must be a positive number."),
    INVALID_QUANTITY("Quantity must be greater than zero."),

    ;


    private String message;

    ExceptionResponse(String message) {
            this.message = message;
        }
        public String getMessage() {
            return this.message;
        }

}
