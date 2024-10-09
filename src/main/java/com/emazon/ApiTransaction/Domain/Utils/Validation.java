package com.emazon.ApiTransaction.Domain.Utils;

import com.emazon.ApiTransaction.Domain.Exeption.InvalidItemIdExeption;
import com.emazon.ApiTransaction.Domain.Exeption.InvalidQuantityExeption;
import com.emazon.ApiTransaction.Domain.Exeption.TokenIlegalFormatExeption;
import com.emazon.ApiTransaction.Domain.Model.Supply;

public class Validation {
    public static void validate(Supply supply,String tokenId){
        validateQuantity(supply.getQuantity());
        validateIdItem(supply.getIdItem());
        validateTokenId(tokenId);

    }
    private static void validateTokenId(String token) {
        if (token == null) {
            throw new TokenIlegalFormatExeption();
        }


    }
        private static void validateQuantity(long quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityExeption();
        }
    }

    private static void validateIdItem(Long idItem) {
        if (idItem <= 0) {
            throw new InvalidItemIdExeption();
        }
    }
}
