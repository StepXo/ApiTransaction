package com.emazon.ApiTransaction.Application.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyResponse {
    private long id;
    private long idUser;
    private long idItem;
    private int quantity;
    private String date;
}
