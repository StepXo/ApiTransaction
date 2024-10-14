package com.emazon.ApiTransaction.Domain.Usecase;

import com.emazon.ApiTransaction.Domain.Api.SupplyServicePort;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import com.emazon.ApiTransaction.Domain.Spi.StockFeignPort;
import com.emazon.ApiTransaction.Domain.Spi.SupplyRepositoryPort;
import com.emazon.ApiTransaction.Domain.Spi.UserJwtPort;
import com.emazon.ApiTransaction.Domain.Utils.DomConstants;
import com.emazon.ApiTransaction.Domain.Utils.Validation;

import java.time.LocalDate;
import java.util.List;

public class SupplyUseCase implements SupplyServicePort {

    private final SupplyRepositoryPort supplyRepositoryPort;
    private final StockFeignPort stockFeignPort;
    private final UserJwtPort userJwt;

    public SupplyUseCase(SupplyRepositoryPort supplyRepositoryPort, StockFeignPort stockFeignPort, UserJwtPort userJwt) {
        this.supplyRepositoryPort = supplyRepositoryPort;
        this.stockFeignPort = stockFeignPort;
        this.userJwt = userJwt;
    }

    @Override
    public Supply saveSupply(Supply supply) {
        String userIdString = userJwt.extractUserId();
        Validation.validate(supply,userIdString);

        supply.setDate(LocalDate.now().toString());
        supply.setIdUser(Long.parseLong(userJwt.extractUserId()));

        stockFeignPort.updateStock(supply);

        return supplyRepositoryPort.saveSupply(supply);
    }

    @Override
    public String checkDate(long id) {
        Supply item = supplyRepositoryPort.getItem(id);
        if (item == null) {
            return DomConstants.NOT_SUPPLYED;
        }
        return DomConstants.RESPONSE_1 + item.getIdItem() + DomConstants.RESPONSE_2 + item.getDate();
    }

    @Override
    public String checkDate(List<Long> id) {
        StringBuilder sb = new StringBuilder();
        for (long itemId : id) {
            sb.append(checkDate(itemId)).append(DomConstants.NEW_LINE);
        }
        return sb.toString();

    }

}
