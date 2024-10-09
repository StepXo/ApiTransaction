package com.emazon.ApiTransaction.Domain.Spi;

import com.emazon.ApiTransaction.Domain.Model.Supply;

public interface SupplyRepositoryPort {
    Supply saveSupply(Supply supply);
}
