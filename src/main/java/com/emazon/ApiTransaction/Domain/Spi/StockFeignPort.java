package com.emazon.ApiTransaction.Domain.Spi;

import com.emazon.ApiTransaction.Domain.Model.Supply;

public interface StockFeignPort {
    void updateStock(Supply supply);
}
