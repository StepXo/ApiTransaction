package com.emazon.ApiTransaction.Infrastructure.Adapters.Respository;

import com.emazon.ApiTransaction.Infrastructure.Adapters.Entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity,Long> {
}
