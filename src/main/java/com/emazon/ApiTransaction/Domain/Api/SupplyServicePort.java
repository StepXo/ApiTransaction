package com.emazon.ApiTransaction.Domain.Api;

import com.emazon.ApiTransaction.Domain.Model.Supply;

public interface SupplyServicePort {
    Supply saveSupply(Supply supply);
}
