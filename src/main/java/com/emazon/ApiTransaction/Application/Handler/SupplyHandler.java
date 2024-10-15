package com.emazon.ApiTransaction.Application.Handler;

import com.emazon.ApiTransaction.Application.Response.SupplyResponse;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import org.mapstruct.Mapper;
import static com.emazon.ApiTransaction.Application.Utils.AppConstants.SPRING;

@Mapper(componentModel = SPRING)
public interface SupplyHandler {
    SupplyResponse toResponse(Supply supply);
}
