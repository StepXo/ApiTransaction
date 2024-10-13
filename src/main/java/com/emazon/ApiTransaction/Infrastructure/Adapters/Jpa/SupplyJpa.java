package com.emazon.ApiTransaction.Infrastructure.Adapters.Jpa;

import com.emazon.ApiTransaction.Domain.Model.Supply;
import com.emazon.ApiTransaction.Domain.Spi.SupplyRepositoryPort;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Mapper.SupplyMapper;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Respository.SupplyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyJpa implements SupplyRepositoryPort {
    private final SupplyMapper mapper;
    private final SupplyRepository repository;

    @Override
    public Supply saveSupply(Supply supply) {
        return mapper.toSupply(repository.save(mapper.toSupplyEntity(supply)));
    }

    @Override
    public Supply getItem(long id) {
        return mapper.toSupply(repository.findById(id).orElse(null));
    }
}
