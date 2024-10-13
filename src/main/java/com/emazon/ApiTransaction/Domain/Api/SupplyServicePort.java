package com.emazon.ApiTransaction.Domain.Api;

import com.emazon.ApiTransaction.Domain.Model.Supply;

import java.util.List;

public interface SupplyServicePort {
    Supply saveSupply(Supply supply);

    String checkDate(long id);

    String checkDate(List<Long> id);
}
