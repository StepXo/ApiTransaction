package com.emazon.ApiTransaction.Domain.Utils;

import com.emazon.ApiTransaction.Domain.Exeption.InvalidItemIdException;
import com.emazon.ApiTransaction.Domain.Exeption.InvalidQuantityException;
import com.emazon.ApiTransaction.Domain.Exeption.TokenMalformationException;
import com.emazon.ApiTransaction.Domain.Model.Supply;

import static com.emazon.ApiTransaction.Domain.Utils.DomConstants.ZERO;

public class Validation {
    public static void validate(Supply supply,String tokenId){
        validateQuantity(supply.getQuantity());
        validateIdItem(supply.getIdItem());
        validateTokenId(tokenId);

    }
    private static void validateTokenId(String token) {
        if (token == null) {
            throw new TokenMalformationException();
        }


    }
        private static void validateQuantity(long quantity) {
        if (quantity <= ZERO) {
            throw new InvalidQuantityException();
        }
    }

    private static void validateIdItem(Long idItem) {
        if (idItem <= ZERO) {
            throw new InvalidItemIdException();
        }
    }
}
