package com.emazon.ApiTransaction.Infrastructure.Input;

import com.emazon.ApiTransaction.Application.Request.SupplyRequest;
import com.emazon.ApiTransaction.Application.Response.SupplyResponse;
import com.emazon.ApiTransaction.Application.Service.SupplyService;
import com.emazon.ApiTransaction.Infrastructure.Utils.InfraConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.emazon.ApiTransaction.Infrastructure.Utils.InfraConstants.TRANSACTION;

@RestController
@RequestMapping(TRANSACTION)
@RequiredArgsConstructor
public class SupplyController {
    private final SupplyService service;

    @PostMapping(InfraConstants.SUPPLY)
    public ResponseEntity<SupplyResponse> newSupply(
            @Valid @RequestBody SupplyRequest request
    ) {
        return ResponseEntity.ok(service.saveSupply(request));
    }

    @GetMapping(InfraConstants.CHECK_1DATE)
    public ResponseEntity<String> checkDate(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(service.checkDate(id));
    }
    @GetMapping(InfraConstants.CHECK_DATES)
    public ResponseEntity<String> checkDates(
            @RequestParam List<Long> id
    ) {
        return ResponseEntity.ok(service.checkDate(id));
    }


}
