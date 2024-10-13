package com.emazon.ApiTransaction.Application.Service;

import com.emazon.ApiTransaction.Application.Handler.SupplyHandler;
import com.emazon.ApiTransaction.Application.Request.SupplyRequest;
import com.emazon.ApiTransaction.Application.Response.SupplyResponse;
import com.emazon.ApiTransaction.Domain.Api.SupplyServicePort;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplyService {
    private final SupplyHandler handler;
    private final SupplyServicePort supplyServicePort;

    public SupplyResponse saveSupply(SupplyRequest request) {

        Supply supply =Supply.builder().
                setId(request.getId())
                .setIdItem(request.getItemId())
                .setQuantity(request.getQuantity())
                .build();

        return handler.toResponse(supplyServicePort.saveSupply(supply));
    }

    public String checkDate(long id) {
        return supplyServicePort.checkDate(id);
    }

    public String checkDate(List<Long> id) {
        return supplyServicePort.checkDate(id);
    }
}
