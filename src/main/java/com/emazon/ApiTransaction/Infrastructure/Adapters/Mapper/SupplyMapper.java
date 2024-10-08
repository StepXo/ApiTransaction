package com.emazon.ApiTransaction.Infrastructure.Adapters.Mapper;

import com.emazon.ApiTransaction.Domain.Model.Supply;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Entity.SupplyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyMapper {
    Supply toSupply(SupplyEntity entity);
    SupplyEntity toSupplyEntity(Supply supply);
}
