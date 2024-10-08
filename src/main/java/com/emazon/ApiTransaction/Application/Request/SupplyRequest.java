package com.emazon.ApiTransaction.Application.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyRequest {
    private long id;
    private long itemId;
    private long quantity;
}
