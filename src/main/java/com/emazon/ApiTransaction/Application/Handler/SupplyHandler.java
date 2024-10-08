package com.emazon.ApiTransaction.Application.Handler;

import com.emazon.ApiTransaction.Application.Response.SupplyResponse;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyHandler {
    SupplyResponse toResponse(Supply supply);
}
